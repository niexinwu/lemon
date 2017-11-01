package com.lemon.sp.common;

import java.util.ResourceBundle;

public class OAuthAppConfig {
	
	static ResourceBundle bundle;
	
	private static ResourceBundle getResourceBundle() {
		try {
			if (bundle == null){
				bundle = ResourceBundle.getBundle("config");
				System.out.println("bundle:"+bundle);
			}
			// org.noe.framework.util.log.Log.debug(bundle.getString("WGET_DB.driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bundle;
	}

	public static String getString(String s) {
		try {
			return getResourceBundle().getString(s);
		} catch (Exception e) {
//            e.printStackTrace();
		}
		return null;
	}
	
}
