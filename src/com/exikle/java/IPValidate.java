package com.exikle.java;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidate {

	private static final String IPADDRESS_STRING_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private static final Pattern IPADDRESS_PATTERN = Pattern
			.compile(IPADDRESS_STRING_PATTERN);

	public static void main(String[] args) {
		// final String ip = "22.2222.22.2";//invalid IP
		final String ip = "127.0.0.1";// valid IP
		Matcher matcher = IPADDRESS_PATTERN.matcher(ip);
		System.out.println(ip + " matches format?: " + matcher.matches());
	}

}
