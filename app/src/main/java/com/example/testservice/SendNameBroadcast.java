package com.example.testservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SendNameBroadcast extends
        BroadcastReceiver {
    public static final String BROADCAST_ACTION =
            "com.example.testservice.BROADCAST_ACTION";
    private static final String TAG = "SendNameBroadcast";
    TextView textView;

    @Override
    public void onReceive(Context context,
                          Intent intent) {
        Log.d(TAG, "onReceive: ");
        if (intent != null) {
            if (intent.getAction().equals(BROADCAST_ACTION)) {
                Log.d(TAG, "onReceive: " + intent.getStringExtra(MusicPlayer.SERVICE_NAME));
                MainActivity.setTextViewName(
                        intent.getStringExtra(MusicPlayer.SERVICE_NAME)
                );
            }
        }
    }
}
