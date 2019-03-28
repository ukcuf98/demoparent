package com.example.demo;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo</p>
 * <p>
 * <p>
 *
 * @author zwq
 * @version 1.0
 * @date 2019/1/22 14:18
 */
public class DemoUtil {

	public static String testMethod(String str) {
		return new StringBuilder("zwq-test-").append(str).toString();
	}

	/**
	 * 对象判空后返回字符串
	 *
	 * @param o
	 * @return
	 */
	public static String null2String(Object o) {
		return null2String(o, "");
	}

	/**
	 * 对象判空后返回字符串
	 *
	 * @param o
	 * @return
	 */
	public static String null2String(Object o, String defVal) {
		if (!isBlank(o)) {
			return o.toString();
		} else {
			return defVal;
		}
	}

	/**
	 * 字符串非空判断（"",null,"null"）
	 *
	 * @param o
	 * @return
	 */
	public static boolean isBlank(Object o) {
		if (null == o || o.toString().trim().length() == 0
				|| "null".equalsIgnoreCase(o.toString())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * object转为integer
	 *
	 * @param obj
	 * @return
	 */
	public static Integer getIntegerValue(Object obj) {
		if (isBlank(obj)) {
			return null;
		} else {
			try {
				return new Integer(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * object转为long
	 *
	 * @param obj
	 * @return
	 */
	public static Long getLongValue(Object obj) {
		if (null == obj) {
			return null;
		} else {
			try {
				return new Long(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换为double类型
	 *
	 * @param paramString
	 * @return
	 */
	public static Double getDoubleValue(String paramString) {
		if (null == paramString || paramString.trim().length() < 1) {
			return null;
		}
		Double b = null;
		try {
			b = Double.parseDouble(paramString);
		} catch (Exception e) {
		}
		return b;
	}

	public static void main(String[] args) {

	}
}
