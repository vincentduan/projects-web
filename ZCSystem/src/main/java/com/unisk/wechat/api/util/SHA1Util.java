package com.unisk.wechat.api.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.Sha1Hash;

public class SHA1Util {

	public static String encode(String source) {
		String sha1Str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(source.getBytes());
			byte[] digest = md.digest();
			sha1Str = toHex(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sha1Str;
	}

	public static String toHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String source = "jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VJ7YjpOcS2XXTI-znbXim-33ewpE7TVp7HWAD0l4Uk-OYftv5Wd5UNa_WrelNyKeoQ&noncestr=4tQ7yvJsD6BwmLYY&timestamp=1452327404&url=http://zhongchou.unisk.cn/wechat/notice/toPublish.do";
		System.out.println(encode(source));

		System.out.println(new Sha1Hash(source).toHex());
		System.out.println(new Sha1Hash(source).toBase64());

		System.out.println(System.currentTimeMillis() / 1000);

	}
}
