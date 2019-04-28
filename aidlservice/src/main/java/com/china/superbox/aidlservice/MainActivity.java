package com.china.superbox.aidlservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.china.superbox.aidlclient.IHelloBinder;

public class MainActivity extends AppCompatActivity {

    private IHelloBinder iHelloBinder;
    //默认未绑定service
    private boolean isBind = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iHelloBinder = IHelloBinder.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iHelloBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 绑定服务
     *
     * @param view
     */
    public void bindServiceBtn(View view) {

        if (serviceConnection != null) {
            isBind = true;
            Toast.makeText(this, "服务绑定成功", Toast.LENGTH_SHORT).show();
            //
            Intent intent = new Intent();
            intent.setAction("com.china.superbox.aidlclient.remote");
            intent.setPackage("com.china.superbox.aidlclient");
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        } else {
            Toast.makeText(this, "ServiceConnection is null", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 解绑服务
     *
     * @param view
     */
    public void unBindServiceBtn(View view) {
        if (isBind) {
            if (serviceConnection != null) {
                isBind = false;
                Toast.makeText(this, "服务解绑成功", Toast.LENGTH_SHORT).show();
                unbindService(serviceConnection);
            } else {
                Toast.makeText(this, "ServiceConnection is null", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "服务未绑定，请先绑定服务", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 执行服务端的calcul方法
     *
     * @param view
     */
    public void excuteCalcul(View view) {
        if (iHelloBinder == null) {
            Toast.makeText(this, "IBinder is null,请先绑定服务", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Toast.makeText(this, "结果是多少" + iHelloBinder.hello("world"), Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBind) {
            if (serviceConnection != null) {
                isBind = false;
                unbindService(serviceConnection);
            }
        }
    }
}
