// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cryptos.java

package com.unisk.zc.core.utils;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.unisk.zc.exceptions.UniskException;

public class Cryptos
{

    public Cryptos()
    {
    }

    public static byte[] hmacSha1(byte input[], byte key[])
    {
        try
        {
            SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKey);
            return mac.doFinal(input);
        }
        catch(GeneralSecurityException e)
        {
            throw UniskException.unchecked(e);
        }
    }

    public static boolean isMacValid(byte expected[], byte input[], byte key[])
    {
        byte actual[] = hmacSha1(input, key);
        return Arrays.equals(expected, actual);
    }

    public static byte[] generateHmacSha1Key()
    {
        try
        {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
            keyGenerator.init(160);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        }
        catch(GeneralSecurityException e)
        {
            throw UniskException.unchecked(e);
        }
    }

    public static byte[] aesEncrypt(byte input[], byte key[])
    {
        return aes(input, key, 1);
    }

    public static byte[] aesEncrypt(byte input[], byte key[], byte iv[])
    {
        return aes(input, key, iv, 1);
    }

    public static String aesDecrypt(byte input[], byte key[])
    {
        byte decryptResult[] = aes(input, key, 2);
        return new String(decryptResult);
    }

    public static String aesDecrypt(byte input[], byte key[], byte iv[])
    {
        byte decryptResult[] = aes(input, key, iv, 2);
        return new String(decryptResult);
    }

    private static byte[] aes(byte input[], byte key[], int mode)
    {
        try
        {
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, secretKey);
            return cipher.doFinal(input);
        }
        catch(GeneralSecurityException e)
        {
            throw UniskException.unchecked(e);
        }
    }

    private static byte[] aes(byte input[], byte key[], byte iv[], int mode)
    {
        try
        {
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(mode, secretKey, ivSpec);
            return cipher.doFinal(input);
        }
        catch(GeneralSecurityException e)
        {
            throw UniskException.unchecked(e);
        }
    }

    public static byte[] generateAesKey()
    {
        return generateAesKey(128);
    }

    public static byte[] generateAesKey(int keysize)
    {
        try
        {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keysize);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        }
        catch(GeneralSecurityException e)
        {
            throw UniskException.unchecked(e);
        }
    }

    public static byte[] generateIV()
    {
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        return bytes;
    }

    private static final String AES = "AES";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";
    private static final String HMACSHA1 = "HmacSHA1";
    private static final int DEFAULT_HMACSHA1_KEYSIZE = 160;
    private static final int DEFAULT_AES_KEYSIZE = 128;
    private static final int DEFAULT_IVSIZE = 16;
    private static SecureRandom random = new SecureRandom();

}
