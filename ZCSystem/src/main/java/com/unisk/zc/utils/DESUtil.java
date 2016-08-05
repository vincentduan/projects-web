package com.unisk.zc.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DESUtil {
	private static Log log = LogFactory.getLog(DESUtil.class);
	
	/**
	 * 加密解密公钥
	 */
	public static final String PALM_KEY = "unisk^";
	

	// ///////////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////使用字符串密钥进行加密解密//////////////////////////////////////////////

	/**
	 * 通过secretkey密钥对inputstring进行DES加密
	 * 
	 * @param inputstring
	 * @param secretkey
	 * @return 加密后的字符串
	 */
	public static String EncryptByDESFromStringKey(String inputstring, String secretkey) {
		String res = null;
		byte[] res_b = null;
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = null;
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		SecretKeyFactory keyFactory = null;
		// 一个SecretKey对象
		SecretKey securekey = null;
		// Cipher对象实际完成加密操作
		Cipher cipher = null;
		try {
			
			byte[] input_b = inputstring.getBytes("UTF-8");
			int num = 0;
			if(input_b.length % 8 != 0){
				num = input_b.length + (8 - (input_b.length % 8));
			}else{
				num = input_b.length;
			}
			byte[] tmp_b = new byte[num];
			System.arraycopy(input_b, 0, tmp_b, 0, input_b.length);
			
			dks = new DESKeySpec(secretkey.getBytes("UTF-8"));
			keyFactory = SecretKeyFactory.getInstance("DES");
			securekey = keyFactory.generateSecret(dks);
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			// 现在，获取数据并加密，正式执行加密操作
			res_b = cipher.doFinal(tmp_b);
			if (res_b != null) {
				res = byte2hex(res_b);
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return res;
	}

	/**
	 * 通过secretkey密钥对outputstring进行DES解密
	 * 
	 * @param outputstring
	 * @param secretkey
	 * @return 解密后的字符串
	 */
	public static String DecryptByDESFromStringKey(String outputstring, String secretkey) {
		String res = null;
		byte[] res_b = null;
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = null;
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		SecretKeyFactory keyFactory = null;
		// 一个SecretKey对象
		SecretKey securekey = null;
		// Cipher对象实际完成解密操作
		Cipher cipher = null;
		try {
			dks = new DESKeySpec(secretkey.getBytes("UTF-8"));
			keyFactory = SecretKeyFactory.getInstance("DES");
			securekey = keyFactory.generateSecret(dks);
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			// 现在，获取数据并解密，正式执行解密操作
			res_b = cipher.doFinal(hex2byte(outputstring));
			if (res_b != null) {
				res = new String(res_b, "UTF-8").trim();
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return res;
	}
	
	/**
	 * 将二进制转化为16进制字符串
	 * 
	 * @param b
	 *            二进制字节数组
	 * @return String
	 */
	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
	
	/**
	 * 十六进制字符串转化为2进制
	 * 
	 * @param hex
	 * @return
	 */
	private static byte[] hex2byte(String hex) {
		byte[] hexb = hex.getBytes();
		if ((hexb.length % 2) != 0)
			throw new IllegalArgumentException("String字符串密钥的长度不是偶数");
		byte[] ret = new byte[hexb.length / 2];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = uniteBytes(hexb[i * 2], hexb[i * 2 + 1]);
		}
		return ret;
	}
	
	/**
	 * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
	 * 
	 * @param src0
	 *            byte
	 * @param src1
	 *            byte
	 * @return byte
	 */
	private static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

}
