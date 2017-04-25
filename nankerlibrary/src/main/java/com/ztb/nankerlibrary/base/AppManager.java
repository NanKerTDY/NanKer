package com.ztb.nankerlibrary.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;


import com.ztb.nankerlibrary.utils.LogUtil;

import java.util.Stack;


/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {
	
	private static Stack<Activity> activityStack;
	private static AppManager instance;
	
	private AppManager(){}
	/**
	 * 单一实例
	 */
	public static AppManager getAppManager(){
		if(instance==null){
			instance=new AppManager();
		}
		return instance;
	}

    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }
	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity){
		if(activityStack==null){
			activityStack=new Stack<Activity>();
		}
		activityStack.add(activity);
	}
	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity(){
		Activity activity=activityStack.lastElement();
		return activity;
	}
	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity(){
		Activity activity=activityStack.lastElement();
		finishActivity(activity);
	}
	
	
	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity){
        if (isFinishAll){
            LogUtil.debug("正在关闭所有的");

        }
		if(activity!=null && !isFinishAll){
			activityStack.remove(activity);
			activity.finish();
			activity=null;
		}
	}
	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls){
		for (Activity activity : activityStack) {
			if(activity.getClass().equals(cls) ){
				finishActivity(activity);
			}
		}
	}
	public int getActivitySize(){
		int size = activityStack.size();
	    return size;
	}
	
	/**
	 * 结束栈中顶层几个activity
	 */
	public void finishSomeActivity(int count){
		int size = activityStack.size();
		LogUtil.debug("Activity 数量是"+size);
		for (int i = size -count; i <size; i++){
			LogUtil.debug("移除Activity 序号"+i);
            if (null != activityStack.get(i)){
            	activityStack.get(i).finish();
            }
	    }
	}
	/**
	 * 结束所有Activity 除了指定的Activity
	 */
	public void finishAllActivityBut(Class<?> cls){
        if (activityStack==null){
            return;
        }
		for (int i = 0, size = activityStack.size(); i < size; i++){
            if (null != activityStack.get(i)){
                if (activityStack.get(i).getClass().equals(cls)) {
                    return;
                }
            	activityStack.get(i).finish();
                activityStack.remove(activityStack.get(i));
            }
	    }
	}

    private boolean isFinishAll;
    public void finishAllActivity(){
        if (activityStack==null){
            return;
        }
        try {
            isFinishAll = true;
            for (int i = 0, size = activityStack.size(); i < size; i++){
                if (null != activityStack.get(i)){
                    activityStack.get(i).finish();
                }
            }
        }catch (Exception e){
            LogUtil.debug("关闭所有的界面====");
        }finally {
            activityStack.clear();
            isFinishAll = false;
        }

    }
	/**
	 * 退出应用程序
	 */
	@SuppressWarnings("deprecation")
	public void appExit(Context context) {
		try {
//			TODO nake 友盟统计
//			MobclickAgent.onKillProcess(context);//友盟统计
			finishAllActivity();
			ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.restartPackage(context.getPackageName());
			System.exit(0);
		} catch (Exception e) {	}
	}
}