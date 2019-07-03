package com.example.testservice;


import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;


public class MusicPlayer extends IntentService {

    public static final String SERVICE_NAME = MusicPlayer.
            class.getSimpleName() + "SERVICE_NAME";
    private static final String TAG = "MusicPlayer";
    private BroadcastReceiver broadcastReceiver;

    public MusicPlayer() {
        super("something");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        if(intent != null) {
            broadcastReceiver = new SendNameBroadcast();
//            registerBroadcastReceiver();
            String name = intent.getStringExtra(SERVICE_NAME);
            Intent intentBroadCast = new Intent();
            intentBroadCast.setClass(this,
                    SendNameBroadcast.class);
            intentBroadCast.putExtra(SERVICE_NAME, name);
            intentBroadCast.setAction(SendNameBroadcast.BROADCAST_ACTION);

            sendBroadcast(intentBroadCast);
        }
    }

    @Override
    public void onDestroy() {
//        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void registerBroadcastReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SendNameBroadcast.BROADCAST_ACTION);

        registerReceiver(broadcastReceiver,
                intentFilter);
    }

}