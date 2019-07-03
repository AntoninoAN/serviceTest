package com.example.testservice;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btn_start, btn_stop;
    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBroadcastReceiver();
        btn_start = findViewById(R.id.btn_start_service);
        btn_stop = findViewById(R.id.btn_stop_service);
        textView = findViewById(R.id.tv_name);

        btn_start.setOnClickListener(view -> processService(view));
        btn_stop.setOnClickListener(view -> processService(view));
    }

    public void processService(View view){

        Intent intent = new Intent(this,
                MusicPlayer.class);
        intent.putExtra(MusicPlayer.SERVICE_NAME, "Misal");
        if(view.getId() == R.id.btn_start_service){
            startService(intent);
        }
        else{
            stopService(intent);
        }
    }

    public static void setTextViewName(String name){
        Log.d(TAG, "setTextViewName: ");
        textView.setText(name);
    }

    public void registerBroadcastReceiver(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SendNameBroadcast.BROADCAST_ACTION);

        registerReceiver(new SendNameBroadcast(),
                intentFilter);
    }
}
