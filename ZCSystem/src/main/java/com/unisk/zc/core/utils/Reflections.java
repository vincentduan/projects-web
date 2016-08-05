// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Reflections.java

package com.unisk.zc.core.utils;

import java.lang.reflect.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class Reflections
{

    public Reflections()
    {
    }

    public static Object invokeGetter(Object obj, String propertyName)
    {
        Object object = obj;
        String as[];
        int j = (as = StringUtils.split(propertyName, ".")).length;
        for(int i = 0; i < j; i++)
        {
            String name = as[i];
            String getterMethodName = (new StringBuilder("get")).append(StringUtils.capitalize(name)).toString();
            object = invokeMethod(object, getterMethodName, new Class[0], new Object[0]);
        }

        return object;
    }

    public static void invokeSetter(Object obj, String propertyName, Object value)
    {
        Object object = obj;
        String names[] = StringUtils.split(propertyName, ".");
        for(int i = 0; i < names.length; i++)
            if(i < names.length - 1)
            {
                String getterMethodName = (new StringBuilder("get")).append(StringUtils.capitalize(names[i])).toString();
                object = invokeMethod(object, getterMethodName, new Class[0], new Object[0]);
            } else
            {
                String setterMethodName = (new StringBuilder("set")).append(StringUtils.capitalize(names[i])).toString();
                invokeMethodByName(object, setterMethodName, new Object[] {
                    value
                });
            }

    }

    public static Object getFieldValue(Object obj, String fieldName)
    {
        Field field = getAccessibleField(obj, fieldName);
        if(field == null)
            throw new IllegalArgumentException((new StringBuilder("Could not find field [")).append(fieldName).append("] on target [").append(obj).append("]").toString());
        Object result = null;
        try
        {
            result = field.get(obj);
        }
        catch(IllegalAccessException e)
        {
            logger.error("\u4E0D\u53EF\u80FD\u629B\u51FA\u7684\u5F02\u5E38{}", e.getMessage());
        }
        return result;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value)
    {
        Field field = getAccessibleField(obj, fieldName);
        if(field == null)
            throw new IllegalArgumentException((new StringBuilder("Could not find field [")).append(fieldName).append("] on target [").append(obj).append("]").toString());
        try
        {
            field.set(obj, value);
        }
        catch(IllegalAccessException e)
        {
            logger.error("\u4E0D\u53EF\u80FD\u629B\u51FA\u7684\u5F02\u5E38:{}", e.getMessage());
        }
    }

    public static Object invokeMethod(Object obj, String methodName, Class parameterTypes[], Object args[])
    {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if(method == null)
            throw new IllegalArgumentException((new StringBuilder("Could not find method [")).append(methodName).append("] on target [").append(obj).append("]").toString());
        try
        {
            return method.invoke(obj, args);
        }
        catch(Exception e)
        {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Object invokeMethodByName(Object obj, String methodName, Object args[])
    {
        Method method = getAccessibleMethodByName(obj, methodName);
        if(method == null)
            throw new IllegalArgumentException((new StringBuilder("Could not find method [")).append(methodName).append("] on target [").append(obj).append("]").toString());
        try
        {
            return method.invoke(obj, args);
        }
        catch(Exception e)
        {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Field getAccessibleField(Object obj, String fieldName)
    {
        Validate.notNull(obj, "object can't be null");
        Validate.notEmpty(fieldName, "fieldName can't be blank");
        for(Class superClass = obj.getClass(); superClass != java.lang.Object.class;)
            try
            {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            }
            catch(NoSuchFieldException nosuchfieldexception)
            {
                superClass = superClass.getSuperclass();
            }

        return null;
    }

    public static  Method getAccessibleMethod(Object obj, String methodName, Class parameterTypes[])
    {
        Validate.notNull(obj, "object can't be null");
        Validate.notEmpty(methodName, "methodName can't be blank");
        for(Class searchType = obj.getClass(); searchType != java.lang.Object.class;)
            try
            {
                Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
                makeAccessible(method);
                return method;
            }
            catch(NoSuchMethodException nosuchmethodexception)
            {
                searchType = searchType.getSuperclass();
            }

        return null;
    }

    public static Method getAccessibleMethodByName(Object obj, String methodName)
    {
        Validate.notNull(obj, "object can't be null");
        Validate.notEmpty(methodName, "methodName can't be blank");
        for(Class searchType = obj.getClass(); searchType != java.lang.Object.class; searchType = searchType.getSuperclass())
        {
            Method methods[] = searchType.getDeclaredMethods();
            Method amethod[];
            int j = (amethod = methods).length;
            for(int i = 0; i < j; i++)
            {
                Method method = amethod[i];
                if(method.getName().equals(methodName))
                {
                    makeAccessible(method);
                    return method;
                }
            }

        }

        return null;
    }

    public static void makeAccessible(Method method)
    {
        if((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers())) && !method.isAccessible())
            method.setAccessible(true);
    }

    public static void makeAccessible(Field field)
    {
        if((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier.isFinal(field.getModifiers())) && !field.isAccessible())
            field.setAccessible(true);
    }

    public static Class getClassGenricType(Class clazz)
    {
        return getClassGenricType(clazz, 0);
    }

    public static Class getClassGenricType(Class clazz, int index)
    {
        Type genType = clazz.getGenericSuperclass();
        if(!(genType instanceof ParameterizedType))
        {
            logger.warn((new StringBuilder(String.valueOf(clazz.getSimpleName()))).append("'s superclass not ParameterizedType").toString());
            return clazz;
        }
        Type params[] = ((ParameterizedType)genType).getActualTypeArguments();
        if(index >= params.length || index < 0)
        {
            logger.warn((new StringBuilder("Index: ")).append(index).append(", Size of ").append(clazz.getSimpleName()).append("'s Parameterized Type: ").append(params.length).toString());
            return clazz;// return java.lang.Object.class;
        }
        if(!(params[index] instanceof Class))
        {
            logger.warn((new StringBuilder(String.valueOf(clazz.getSimpleName()))).append(" not set the actual class on superclass generic parameter").toString());
            return clazz;//return java/lang/Object;
        } else
        {
            return (Class)params[index];
        }
    }

    public static Class getUserClass(Object instance)
    {
        Assert.notNull(instance, "Instance must not be null");
        Class clazz = instance.getClass();
        if(clazz != null && clazz.getName().contains("$$"))
        {
            Class superClass = clazz.getSuperclass();
            if(superClass != null && !clazz.equals(superClass))
                return superClass;
        }
        return clazz;
    }

    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e)
    {
        if((e instanceof IllegalAccessException) || (e instanceof IllegalArgumentException) || (e instanceof NoSuchMethodException))
            return new IllegalArgumentException(e);
        if(e instanceof InvocationTargetException)
            return new RuntimeException(((InvocationTargetException)e).getTargetException());
        if(e instanceof RuntimeException)
            return (RuntimeException)e;
        else
            return new RuntimeException("Unexpected Checked Exception.", e);
    }

    private static final String SETTER_PREFIX = "set";
    private static final String GETTER_PREFIX = "get";
    private static final String CGLIB_CLASS_SEPARATOR = "$$";
    private static Logger logger = LoggerFactory.getLogger( com.unisk.zc.core.utils.Reflections.class );

}
