package com.china.superbox.aidlclient;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2019/4/28.
 */

public class HelloService extends Service {

    private IHelloBinder.Stub iHelloBinder = new IHelloBinder.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String hello(String msg) throws RemoteException {
            return msg + "00";
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iHelloBinder;
    }
}
