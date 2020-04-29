package com.newasia.toollibrary;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import androidx.multidex.MultiDex;

public class CustomizedApplication extends Application
{
    public static Resources g_Res = null;
    @Override
    public void onCreate() {
        super.onCreate();
        g_Res = getResources();

        MultiDex.install(this);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                StatusBarUtil.setRootViewFitsSystemWindows(activity, false);
                StatusBarUtil.setTranslucentStatus(activity);
                if (!StatusBarUtil.setStatusBarDarkTheme(activity, true)) {
                    StatusBarUtil.setStatusBarColor(activity, Color.parseColor("#00008577"));
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
