package com.landi.trainingdemo;


import android.app.Application;
import android.content.Context;

import android.util.Log;

import com.tencent.mmkv.MMKV;

import org.litepal.LitePal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static com.landi.trainingdemo.Utils.getCurProcessName;

/**
 * Created by guoj on 2019/7/29.
 */

public class MyApplication extends Application {
    String TAG="MyApplication";
    private static Context context;
    private static ExecutorService executor;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        LitePal.initialize(this);
        MMKV.initialize(this);
        Log.i(TAG, "onCreate: ProcessName:"+Utils.getCurProcessName(context));
    }

    public static Context getContext() {
        return context;
    }
    public static ExecutorService  getThreadPoolExecutor() {
        return executor;
    }
}
