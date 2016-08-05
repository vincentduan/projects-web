package com.unisk.zc.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DESTools {

	/** 字符串加密的key值 */
	private static final String strkey = "UNISK_Info_SRC";

	/**
	 * 函数名称: encryptDES 函数功能描述: 如果传入的字符串加密的时候没出现异常，就返回加密的字符串。如果出现异常就返回传入的字符串。
	 * 
	 * @param encryptString
	 *            字符串
	 * @return 返回字符串
	 */
	public static String encryptDES(String encryptString) {
		try {
			IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(strkey.getBytes("utf-8"));
			keyFactory.generateSecret(keySpec);
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
			byte[] encryptedData = cipher.doFinal(encryptString.getBytes("utf-8"));

			return parseByte2HexStr(encryptedData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return encryptString;
		}
	}

	/**
	 * 函数名称: decryptDES 函数功能描述: 返回解密的字符串，如果解密出现异常就返回需要解密的字符串
	 * 
	 * @param decryptString
	 *            字符串
	 * @return 返回字符串
	 */
	public static String decryptDES(String decryptString) {

		try {
			byte[] byteMi = parseHexStr2Byte(decryptString);
			IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			DESKeySpec keySpec = new DESKeySpec(strkey.getBytes("utf-8"));
			keyFactory.generateSecret(keySpec);
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "DES");
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
			byte[] decryptedData = cipher.doFinal(byteMi);

			return new String(decryptedData, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return decryptString;
		}
	}

	/**
	 * 函数名称: parseByte2HexStr 函数功能描述: 将二进制转换16进制
	 * 
	 * @param buf
	 *            byte字节的数组
	 * @return 返回字符串
	 */
	private static String parseByte2HexStr(byte[] buf) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 函数名称: parseHexStr2Byte 函数功能描述: 16进制转换为二进制
	 * 
	 * @param hexStr
	 *            字符串
	 * @return byte数组，如果出现异常返回为null
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(DESTools.decryptDES("95A408DC650CA5F0"));
	}

}
