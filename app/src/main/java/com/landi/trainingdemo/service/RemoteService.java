package com.landi.trainingdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.landi.trainingdemo.IRemoteInterface;
import com.landi.trainingdemo.bean.Person;


/**
 * Created by guoj on 2019/8/26.
 */

public class RemoteService extends Service{
    private IBinder iBinder=new IRemoteBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }


    private class IRemoteBinder extends IRemoteInterface.Stub{

        public double calc(double a, double b) throws RemoteException {
            return (long) (a+b);
        }

        @Override
        public String showInfo(Person person) throws RemoteException {
            return "个人信息："+person.toString();
        }

    }
}
