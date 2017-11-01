package com.lemon.sp.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UtiltyHelper {

	public final static String DATEFORMAT = "yyyy-MM-dd";
	public final static String DATEYEARFORMAT = "yyyy";
	public final static String DATETIME2FORMAT = "yyyy-MM-dd HH:mm";
	public final static String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

	public static int[] getRecentlyYears() {
		int currentYear = getCurrentYear();
		return new int[] { currentYear - 2, currentYear - 1, currentYear };
	}

	public static int getCurrentYear() {
		Calendar a = Calendar.getInstance();
		return a.get(Calendar.YEAR);
	}

	/**
	 * 系统当前时间 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String GetNowDate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(now);
	}

	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	public static String getNowYear() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return dateFormat.format(new Date());
	}

	/**
	 * 根据系统当前时间，得到前后多少天的日期 格式yyyy-MM-dd
	 * 
	 * @param day
	 *            与系统当前时间相差的天数
	 * @return
	 */
	public static String GetDateFromNow(int day) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		String theDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return theDate;
	}

	/**
	 * 去除'符号，防止SQL攻击
	 * 
	 * @param str
	 * @return
	 */
	public static String SafeString(String str) {
		str = str.replace("'", "");
		str = str.trim();
		return str;
	}

	public static String GetDateFromNow(String date, int day) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = null;
		try {
			myDate = formatter.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(myDate);
			c.add(Calendar.DATE, day);
			myDate = c.getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return formatter.format(myDate);
	}

	/**
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String GetDayDate(int day) throws ParseException {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date da = df.parse(df.format(d));
		return df.format(new Date(da.getTime() + day * 24 * 60 * 60 * 1000));
	}

	/**
	 * 根据日期查询星期
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String GetDateWeek(String date) throws ParseException {

		String dayNames[] = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar c = Calendar.getInstance();// 获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(sdf.parse(date));

		return dayNames[c.get(Calendar.DAY_OF_WEEK) - 1];
	}

	/**
	 * 判断是否为闰年
	 */
	public static boolean getIsRun(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * 返回某年某月有多少天。
	 */
	public static int getDay(int year, int month) {
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 闰年月份
		int[] day1 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 普通月份
		if (getIsRun(year)) {
			return day1[month - 1];

		} else {
			return day[month - 1];
		}
	}

	/**
	 * 返回这个月的1号是星期几
	 * 
	 * @throws ParseException
	 */
	public static int getWeek(int year, int month) throws ParseException {
		// Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(year + "-" + month + "-" + 01));
		return calendar.get(calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 生成一个随机文件名
	 * 
	 * @param orgFileName
	 * @return
	 */
	public static String CreateRandomFileName(String orgFileName) {
		String[] fileArr = orgFileName.split("\\.");
		String fileExt = fileArr[fileArr.length - 1];

		Random random = new Random();
		int rnd = Math.abs(random.nextInt()) % 1000;
		Date now = new Date();
		String str = String.format("%d%d.%s", now.getTime(), rnd, fileExt);
		return str;
	}

	public static String GetStringFromUrl(String str) {
		try {
			if (isNotEmpty(str)) {
				str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (Exception ex) {
		}
		return str;
	}

	/**
	 * 把秒转换成时分秒
	 * 
	 * @param second
	 *            秒
	 * @return
	 */
	public static String calSecond(Integer second) {
		int h = 0;
		int d = 0;
		int s = 0;
		if (second != null && second != 0) {
			int temp = second % 3600;
			if (second > 3600) {
				h = second / 3600;
				if (temp != 0) {
					if (temp > 60) {
						d = temp / 60;
						if (temp % 60 != 0) {
							s = temp % 60;
						}
					} else {
						s = temp;
					}
				}
			} else {
				d = second / 60;
				if (second % 60 != 0) {
					s = second % 60;
				}
			}
		}
		String hh = (h < 10) ? "0" + h : "" + h;
		String dd = (d < 10) ? "0" + d : "" + d;
		String ss = (s < 10) ? "0" + s : "" + s;
		return hh + ":" + dd + ":" + ss;
	}

	/**
	 * 把秒转换成 分秒(不带小时)
	 * 
	 * @param second
	 *            秒
	 * @return
	 */
	public static String calSecondWithoutHour(Integer second) {
		int h = 0;
		int d = 0;
		int s = 0;
		if (second != null && second != 0) {
			int temp = second % 3600;
			if (second > 3600) {
				h = second / 3600;
				if (temp != 0) {
					if (temp > 60) {
						d = temp / 60;
						if (temp % 60 != 0) {
							s = temp % 60;
						}
					} else {
						s = temp;
					}
				}
			} else {
				d = second / 60;
				if (second % 60 != 0) {
					s = second % 60;
				}
			}
		}
		int hh = h * 60;
		d = hh + d;
		String dd = (d < 10) ? "0" + d : "" + d;
		String ss = (s < 10) ? "0" + s : "" + s;
		return dd + ":" + ss;
	}

	/**
	 * 输入两个字符串型的日期，比较两者的大小 fromDate是否小于toDate
	 * 
	 * @param fromDate
	 *            String
	 * @param toDate
	 *            String
	 * @return boolean before为true
	 */
	public static boolean compareTwoDateBigOrSmall(String fromDate, String toDate) {
		Date dateFrom = switchStringToDate(fromDate, DATETIME2FORMAT);
		Date dateTo = switchStringToDate(toDate, DATETIME2FORMAT);
		if (dateFrom.before(dateTo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 输入两个字符串型的日期，比较两者的大小 fromDate是否小于toDate
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param type
	 * @return
	 */
	public static boolean compareTwoDateTimeBigOrSmall(String fromDate, String toDate, String type) {
		Date dateFrom = switchStringToDate(fromDate, type);
		Date dateTo = switchStringToDate(toDate, type);
		if (dateFrom.before(dateTo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将一个日期字符串转化成日期
	 * 
	 * @param sDate
	 *            String
	 * @return Date yyyy-MM-dd
	 */
	public static Date switchStringToDate(String sDate) {
		Date date = null;
		if (sDate != null) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				date = df.parse(sDate);
			} catch (Exception e) {
			}
		}
		return date;
	}

	/**
	 * 比较两个日期前后
	 * @param DATE1
	 * @param DATE2
	 * @return 1:dt1 在dt2前 -1: dt1在dt2后
	 */
	public static int compareDate(String DATE1, String DATE2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public static Date switchStringToDate(String sDate, String type) {
		Date date = null;
		if (sDate != null) {
			type = type == null ? DATEFORMAT : DATETIME2FORMAT;
			try {
				SimpleDateFormat df = new SimpleDateFormat(type);
				date = df.parse(sDate);
			} catch (Exception e) {
			}
		}
		return date;
	}

	/**
	 * 将一个日期字符串转化成日期
	 * 
	 * @param sDate
	 *            String
	 * @return Date yyyy.MM.dd
	 */
	public static Date stringToDate(String sDate) {
		Date date = null;
		if (sDate != null) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
				date = df.parse(sDate);
			} catch (Exception e) {
			}
		}
		return date;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 *            小日期
	 * @param date2
	 *            大日期
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		int betweenDays = 0;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			betweenDays = parseInteger(between_days);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return betweenDays;
	}

	/**
	 * 两个日期之间相差的秒数
	 * 
	 * @param startDate
	 * @return
	 */
	public static int calLastedTime(Date startDate) {
		long a = new Date().getTime();
		long b = startDate.getTime();
		int c = (int) ((a - b) / 1000);
		return c;
	}

	/**
	 * 将一个日期转化成日期字符串(按相应的格式)
	 * 
	 * @param date
	 * @param format
	 *            格式
	 * @return 日期字符串或""
	 */
	public static String dateToString(Date date, String format) {
		if (format == null || "".equals(format)) {
			format = "yyyy-MM-dd";
		}
		String newDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			if (date != null) {
				newDate = sdf.format(date);
			}
		} catch (Exception e) {
		}
		return newDate;
	}

	/**
	 * 将一个日期字符串转化成日期(按相应的格式)
	 * 
	 * @param date
	 * @param format
	 *            格式
	 * @return Date或null
	 */
	public static Date stringToDate(String date, String format) {
		if (format == null || format == "") {
			format = "yyyy-MM-dd";
		}
		Date newDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			if (date != null && !date.equals("")) {
				newDate = sdf.parse(date);
			}
		} catch (Exception e) {
		}
		return newDate;
	}

	/**
	 * 时间戳转换
	 * 
	 * @param Timestamps
	 *            如1429173760000
	 * @return 如2015-04-16
	 */
	public static String TimestampsToDate(String Timestamps) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sd = sdf.format(new Date(Long.parseLong(Timestamps)));
		return sd;
	}

	/**
	 * 是否为空白,包括null、""和空格
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o) {
		return o == null || o.toString().trim().length() == 0;
	}

	/**
	 * 是否为空白,包括null、""和空格
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}

	/**
	 * 是否为空白,包括null、""和空格
	 * 
	 * @param o
	 * @return
	 */
	public static String trim(Object o) {
		return o == null ? "" : o.toString().trim();
	}

	public static String parseString(Object o) {
		if (o == null) {
			return "";
		}
		return o.toString();
	}

	public static Long parseLong(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return null;
		}
		Number num = null;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.longValue() : Long.valueOf(o.toString());
	}

	/**
	 * 如果为空或不是数字，则为null
	 * 
	 * @param o
	 * @return
	 */
	public static Integer parseInteger(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return null;
		}
		Number num = null;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.intValue() : Integer.valueOf(o.toString());
	}

	/**
	 * 如果为空或不是数字，则为0，其他正常转化成数字
	 * 
	 * @param o
	 * @return
	 */
	public static Integer parseInt(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return 0;
		}
		Number num = 0;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.intValue() : Integer.valueOf(o.toString());
	}

	/**
	 * 如果为空或不是数字，则为null，其他正常转化成数字
	 * 
	 * @param o
	 * @return
	 */
	public static Float parseFloat(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return null;
		}
		Number num = null;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.floatValue() : Float.valueOf(o.toString());
	}

	/**
	 * 如果为空或不是数字，则为0f，其他正常转化成数字
	 * 
	 * @param o
	 * @return
	 */
	public static float parsefloat(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return 0f;
		}
		Number num = 0f;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.floatValue() : Float.valueOf(o.toString());
	}

	public static Double parseDouble(Object o) {
		o = trim(o);
		if (!isNumber(o)) {
			return null;
		}
		Number num = null;
		try {
			num = NumberFormat.getInstance().parse(o.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isNumberType(o) ? num.doubleValue() : Double.valueOf(o.toString());
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(Object str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return isEmpty(str) ? false : pattern.matcher(str.toString()).matches();
	}

	/**
	 * 判断是否为数字，包括double和float
	 * 
	 * @param o
	 *            传入Object
	 * @return 是数字返回true,否则返回false
	 */
	public static boolean isNumber(Object o) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+(.[\\d]+)?$");
		return isEmpty(o) ? false : isNumberType(o) || pattern.matcher(o.toString()).matches();
	}

	private static boolean isNumberType(Object o) {
		return (o instanceof Number);
	}

	/**
	 * 数字小数点后保留小数位
	 * 
	 * @param sNum
	 *            要处理的数字
	 * @param format
	 *            数字格式
	 * @return
	 */
	public static String parseDoubleToString(Double sNum, String format) {
		if (isEmpty(format)) {
			format = "#.##";
		}
		DecimalFormat decimalFormat = new DecimalFormat(format);
		String resultStr = decimalFormat.format(sNum);
		if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
			resultStr = resultStr.substring(0, resultStr.indexOf("."));
		}
		return resultStr;
	}

	/**
	 * 产生随机GUID
	 * 
	 * @return
	 */
	public static final String GenerateGUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	// 获得当前日期与本周一相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	// 获得当前周- 周一的日期
	public static String getCurrentMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		String preMonday = dateFormat.format(monday);
		return preMonday;
	}

	// 获得当前周- 周日 的日期
	public static String getPreviousSunday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();
		String preMonday = dateFormat.format(monday);
		return preMonday;

	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// 获得当前月--开始日期
	public static String getMinMonthDate(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	// 获得当前月--结束日期
	public static String getMaxMonthDate(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object copy(Object object) throws Exception {
		Class<?> classType = object.getClass();
		Object objectCopy = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
		Field fields[] = classType.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			if ("serialVersionUID".equalsIgnoreCase(fieldName)) {
				continue;
			}
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName, new Class[] {});
			Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });
			Object value = getMethod.invoke(object, new Object[] {});
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}

	/**
	 * 判断文件夹是否存在，不存在创建文件夹
	 * 
	 * @param filePath
	 */
	public static void createFilePath(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return;
		} else {
			file.mkdirs();
		}
	}

	/**
	 * 判断某个字符串是否存在于数组中
	 * 
	 * @param stringArray
	 *            原数组
	 * @param source
	 *            查找的字符串
	 * @return 是否找到
	 */
	public static boolean ifArrayContainsStr(String[] stringArray, String source) {
		// 转换为list
		List<String> tempList = Arrays.asList(stringArray);
		// 利用list的包含方法，进行判断
		if (tempList.contains(source)) {
			return true;
		}
		return false;
	}

	/**
	 * 计算两数的百分比
	 * 
	 * @param numerator
	 *            分子
	 * @param denominator
	 *            分母
	 * @return 如50%
	 */
	public static String DoPercent(double numerator, double denominator) {
		NumberFormat format = NumberFormat.getPercentInstance(); // 获取格式化类实例
		format.setMinimumFractionDigits(0); // 设置小数位
		return format.format(numerator / denominator); // 打印计算结果
	}

	/**
	 * 阿拉伯数字 转 中文数字，支持10亿以内 不想要“个”的话就把 ss[] 数组中的“个”改成空() 不过毕竟是机械的转换，有零的话不太符合语言习惯
	 * 
	 * @param arabicNumerals
	 *            阿拉伯数字
	 */
	public static String ArabicNumeralsToChineseNumerals(int arabicNumerals) {
		// String[] str = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String[] str = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		// String ss[] = new String[] {"元","拾","佰","仟","万","拾","佰","仟","亿"};
		String ss[] = new String[] { "", "十", "百", "千", "万", "十", "百", "千", "亿" }; // {"个","十","百","千","万","十","百","千","亿"}
		String s = parseString(arabicNumerals);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			String index = String.valueOf(s.charAt(i));
			sb = sb.append(str[Integer.parseInt(index)]);
		}
		String sss = String.valueOf(sb);
		int i = 0;
		for (int j = sss.length(); j > 0; j--) {
			sb = sb.insert(j, ss[i++]);
		}
		return sb.toString();
	}

	/**
	 * 获取当年的第一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getCurrYearFirst() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取当年的最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getCurrYearLast() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期对象
	 * @return String 日期字符串
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DATEFORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 格式化日期(年)
	 * 
	 * @param date
	 * @return String 日期字符串
	 */
	public static String formatDateYear(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DATEYEARFORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 清空数组中的空元素
	 * 
	 * @param arr
	 * @return
	 */
	public static String[] clearArrayEmptyArgs(String[] arr) {
		String[] arrReturn = null;
		if (arr != null && arr.length > 0) {
			int i = 0;
			arrReturn = new String[arr.length];
			for (String str : arr) {
				if (isNotEmpty(str)) {
					arrReturn[i] = str;
					i++;
				}
			}
		}
		return arrReturn;
	}

	/**
	 * sql注入过滤
	 * 
	 * @param value
	 * @return
	 */
	public static String cleanSql(String value) {
		String inj_str = "'|and|exec|insert|select|delete|update|count|chr|mid|master|truncate|char|declare|union|order by";
		value = value.replaceAll(inj_str, "");

		return value;

	}

	/**
	 * 接收用户上传文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String receiveFile(MultipartFile file, String path) throws IOException {

		if (file == null || file.getSize() == 0) {
			return null;
		}
		// 获得文件名：
		String filename = file.getOriginalFilename();

		/*
		 * // 判断是否在允许文件类型范围 if (!WebUtil.IsVailFile(fileType, 4)) { return ""; }
		 */
		// 写入文件
		String sepString = System.getProperty("file.separator");
		String filePath = path + sepString;
		UtiltyHelper.createFilePath(filePath);
		String writeFileName = UtiltyHelper.CreateRandomFileName(filename);
		File source = new File(filePath + writeFileName);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(source));
		stream.write(file.getBytes());
		stream.close();

		return writeFileName;
	}

	public static String sqlHolder(int size) {
		String[] paras = new String[size];
		Arrays.fill(paras, "?");
		// StringUtils.addStringToArray(paras, ",");
		return org.apache.commons.lang3.StringUtils.join(paras, ",");
	}

	/**
	 * 统计b中包含a中的元素是否与a的元素个数相同
	 */
	public static boolean containArray(String[] a, String[] b) {
		boolean flag = false;
		int k = 0;
		if (a.length <= b.length) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i].equals(b[j]) || a[i] == b[j]) {
						k++;
						continue;
					}
				}
			}
		}
		if (k == a.length) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 获取几天前的日期
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 将String转为可执行的java代码
	 * 
	 * @author jinjing20
	 * @param jexlExp
	 * @param map
	 * @return
	 */
	public static Object convertToCode(String jexlExp, Map<String, Object> map) {
		JexlEngine jexl = new JexlEngine();
		Expression e = jexl.createExpression(jexlExp);
		JexlContext jc = new MapContext();
		for (String key : map.keySet()) {
			jc.set(key, map.get(key));
		}
		if (null == e.evaluate(jc)) {
			return "";
		}
		return e.evaluate(jc);
	}

	// 由出生日期获得年龄
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}

	public static String listToString(List<Map<String, Object>> stringList) {
		if (stringList == null) {
			return null;
		}
		String result = "";
		boolean flag = false;
		for (Map<String, Object> map : stringList) {
			if (flag) {
				result += ",";
			} else {
				flag = true;
			}
			result += "'" + map.get("id").toString() + "'";
		}
		String s = (StringUtils.isEmpty(result) ? "''" : result.toString());
		return s;
	}

	/**
	 * 对map的key进行排序
	 * 
	 * @param param
	 * @return
	 */
	public static LinkedHashMap<String, Object> mapKeySort(Map<String, Object> param) {
		LinkedHashMap<String, Object> myMap = new LinkedHashMap<String, Object>();
		List<String> keyList = new ArrayList<String>();
		Iterator<String> it = param.keySet().iterator();
		while (it.hasNext()) {
			keyList.add(it.next());
		}
		Collections.sort(keyList);
		Iterator<String> it2 = keyList.iterator();
		while (it2.hasNext()) {
			String key = it2.next();
			myMap.put(key, param.get(key));
		}
		return myMap;
	}

	/**
	 * 将map中的value转为List
	 * 
	 * @param map
	 * @return
	 */
	public static List<Object> mapToList(Map<String, Object> map) {
		List<Object> list = new ArrayList<Object>();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			list.add(map.get(key));
		}
		return list;
	}

	public static List<Object> mapToList1(Map<String, Object> map) {
		List<Object> list = new ArrayList<Object>();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			Map<String, Object> map1 = new HashMap<String, Object>();
			list.add(map.get(key));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	// 实体对象转Map
	public static Map ConvertObjToMap(Object obj) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					reMap.put(fields[i].getName(), o);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return reMap;
	}

	public static String getStr4SQLINParam(List<String> values) {
		String str = "";
		for (int i = 0; i < values.size(); i++) {
			str += "'" + values.get(i) + "', ";
		}
		return str.substring(0, str.length() - 2);
	}

}