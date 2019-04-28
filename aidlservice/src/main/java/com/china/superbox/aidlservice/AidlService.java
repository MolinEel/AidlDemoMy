package com.china.superbox.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2019/4/28.
 */

public class AidlService extends Service {

    private IAidlBinder.Stub iAidlBinder = new IAidlBinder.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int calcul(int num1, int num2) throws RemoteException {
            return num1+num2;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iAidlBinder;
    }
}
