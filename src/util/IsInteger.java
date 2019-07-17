package util;

import java.util.regex.Pattern;

public class IsInteger {
	/**
	 * 判断是否str是否为数字
	 * @param str
	 * @return 是整数返回true，否则返回false
	 */
	public static boolean isInteger(String str) {
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	     return pattern.matcher(str).matches();  
	}
}
