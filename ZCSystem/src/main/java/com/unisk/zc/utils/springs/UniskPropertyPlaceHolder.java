package com.unisk.zc.utils.springs;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *
 * @author xuhao
 *
 */
public class UniskPropertyPlaceHolder extends PropertyPlaceholderConfigurer {

    public UniskPropertyPlaceHolder() {}

    private static Properties properties = null;

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        UniskPropertyPlaceHolder.properties = props;
    }

    /***
     * 根据属性文件中的键值获取对应属性文件中的值
     * @param key 属性文件中的键值
     * @return 对应属性文件中的属性值
     */
    public static String getProperty(String key, String defalut){
        String value = properties.getProperty(key);
        if(value == null) {
            return defalut;
        }
        return value;
    }

    public static int getProperty(String key, int defalut) {
        String value = properties.getProperty(key);
        if(value == null) {
            return defalut;
        }
        Integer i = null;
        try {
            i = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defalut;
        }
        return i;
    }

}
