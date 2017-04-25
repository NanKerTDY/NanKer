package com.ztb.nankerlibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/**
 * 一个用来输出打印日志的，可以知道日志是在程序中哪一个类中哪一个方法哪一行输出的
 * @author  BlueWind 473790228@qq.com
 * @time 下午2:58:53
 */
public class LogUtil {
	private static final String TAG_DEBUG = "wd";
	private static final String TAG_ERROR = "we";
	private static int LOG_MAXLENGTH = 2000;


	public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        LogUtil.debug = debug;
    }

    private static boolean debug = true;
	private static boolean error = true;
    public static void debug(Object msg) {
        if (debug) {
            StackTraceElement line = new Throwable().getStackTrace()[1];
            if (line != null) {
                String fileName = line.getFileName();
                String methodName = line.getMethodName();
                int lineNumber = line.getLineNumber();
                Log.d(TAG_DEBUG, String.format("%s[%4d] ==> %s ==>%s", fileName,lineNumber,methodName,msg));
            }
        }
	}
    
    public static void debug(String tag, Object msg) {
		if (debug) {
			StackTraceElement line = new Throwable().getStackTrace()[1];
			if (line != null) {
				String fileName = line.getFileName();
				String methodName = line.getMethodName();
				int lineNumber = line.getLineNumber();
				Log.d(tag, String.format("%s[%4d] ==> %s ==>%s", fileName,lineNumber,methodName,msg));
			}
		}
	}

	public static void LoogDebug(String msg) {
		if (debug) {

			int strLength = msg.length();
			int start = 0;
			int end = LOG_MAXLENGTH;
			for (int i = 0; i < 100; i++) {
				if (strLength > end) {
					Log.e("TAG_DEBUG___" + i, msg.substring(start, end));
					start = end;
					end = end + LOG_MAXLENGTH;
				} else {
					Log.e("TAG_DEBUG___" + i, msg.substring(start, strLength));
					break;
				}
			}
		}
	}

	public static void LoogDebug(String type, String msg) {

		if (debug) {

			int strLength = msg.length();
			int start = 0;
			int end = LOG_MAXLENGTH;
			for (int i = 0; i < 100; i++) {
				if (strLength > end) {
					Log.e(type + "___" + i, msg.substring(start, end));
					start = end;
					end = end + LOG_MAXLENGTH;
				} else {
					Log.e(type + "___" + i, msg.substring(start, strLength));
					break;
				}
			}
		}
	}

    public static void error(Object msg) {
        if (error) {
            StackTraceElement line = new Throwable().getStackTrace()[1];
            if (line != null) {
                String fileName = line.getFileName();
                String methodName = line.getMethodName();
                int lineNumber = line.getLineNumber();
                Log.e(TAG_ERROR, String.format("%s[%4d] ==> %s ==>%s", fileName, lineNumber, methodName, msg));
            }
        }
  	}
    
    public static void error(String tag, Object msg) {
  		if (error) {
  			StackTraceElement line = new Throwable().getStackTrace()[1];
  			if (line != null) {
  				String fileName = line.getFileName();
  				String methodName = line.getMethodName();
  				int lineNumber = line.getLineNumber();
  				Log.e(tag, String.format("%s[%4d] ==> %s ==>%s", fileName,lineNumber,methodName,msg));
  			}
  		}
  	}



	public static String getDeviceInfo(Context context) {
		try{
			org.json.JSONObject json = new org.json.JSONObject();
			android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
					.getSystemService(Context.TELEPHONY_SERVICE);

			String device_id = tm.getDeviceId();

			android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);

			String mac = wifi.getConnectionInfo().getMacAddress();
			json.put("mac", mac);

			if( TextUtils.isEmpty(device_id) ){
				device_id = mac;
			}

			if( TextUtils.isEmpty(device_id) ){
				device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),android.provider.Settings.Secure.ANDROID_ID);
			}

			json.put("device_id", device_id);

			return json.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
