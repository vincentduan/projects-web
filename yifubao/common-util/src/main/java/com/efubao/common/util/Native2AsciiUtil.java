/** 
  * Native2AsciiUtil.java
  * 
  * Copyright (c) 2013 by efubao.com.
  */
package com.efubao.common.util;

/**
 * parse native string to ASII, or ASII to native
 * you can use this to parse JavaScript data voiding messy code.
 */
public final class Native2AsciiUtil {

	/** prefix of ASII string of native character */
	private static final String PREFIX = "\\u";
	/** integer value 4 */
	private static final int NUM_4 = 4;
	/** integer value 6 */
	private static final int NUM_6 = 6;
	/** integer value 8 */
	private static final int NUM_8 = 8;
	/** integer value 16 */
	private static final int NUM_16 = 16;
	/** integer value 255 */
	private static final int NUM_255 = 0xFF;
	
	/**
	 * private constructor
	 */
	private Native2AsciiUtil() {
		
	}

	/**
	 * Native to ASII string. It's same as execute native2ascii.exe.
	 *
	 * @param str
	 * 		native string
	 * @return ASII string
	 */
	public static String native2Ascii(final String str) {
		char[] chars = str.toCharArray();
		// inner variable, so it's safe
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append(char2Ascii(chars[i]));
		}
		return sb.toString();
	}

	/**
	 * Native character to ASII string.
	 *
	 * @param c native character
	 * @return ASII string
	 */
	private static String char2Ascii(final char c) {
		if (c > NUM_255) {
			StringBuilder sb = new StringBuilder();
			sb.append(PREFIX);
			int code = (c >> NUM_8);
			String tmp = Integer.toHexString(code);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
			code = (c & NUM_255);
			tmp = Integer.toHexString(code);
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
			return sb.toString();
		} else {
			return Character.toString(c);
		}
	}

	/**
	 * ASII to native string. It's same as execute native2ascii.exe -reverse.
	 *
	 * @param str ASII string
	 * @return native string
	 */
	public static String ascii2Native(final String str) {
		StringBuilder sb = new StringBuilder();
		int begin = 0;
		int index = str.indexOf(PREFIX);
		while (index != -1) {
			sb.append(str.substring(begin, index));
			sb.append(ascii2Char(str.substring(index, index + NUM_6)));
			begin = index + NUM_6;
			index = str.indexOf(PREFIX, begin);
		}
		sb.append(str.substring(begin));
		return sb.toString();
	}

	/**
	 * ASII to native character.
	 *
	 * @param str ASII string
	 * @return native character
	 */
	private static char ascii2Char(final String str) {
		if (str.length() != NUM_6) {
			throw new IllegalArgumentException(
					"ASII string of a native character must be 6 character.");
		}
		if (!PREFIX.equals(str.substring(0, 2))) {
			throw new IllegalArgumentException(
					"ASII string of a native character must start with \"\\u\".");
		}
		String tmp = str.substring(2, NUM_4);
		int code = Integer.parseInt(tmp, NUM_16) << NUM_8;
		tmp = str.substring(NUM_4, NUM_6);
		code += Integer.parseInt(tmp, NUM_16);
		return (char) code;
	}

}

