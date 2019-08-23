package com.landi.trainingdemo.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.landi.trainingdemo.LogUtil;
import com.landi.trainingdemo.MyApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by guoj on 2019/8/22.
 */

public class LongRunningService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ExecutorService executor=MyApplication.getThreadPoolExecutor();
        if(executor==null){
            executor= Executors.newSingleThreadExecutor();
        }
        executor.execute(()->LogUtil.i("LongRunningService",SystemClock.elapsedRealtime()+"服务开启了..."));
        executor.shutdown();
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        long triggerAtTime= SystemClock.elapsedRealtime()+60*60*1000;
        Intent i=new Intent(this,LongRunningService.class);
        PendingIntent pi=PendingIntent.getService(this,1,i,0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }
}
