package com.example.fragmentcommunication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//2. Implement Interface
public class MainActivity extends AppCompatActivity implements BlankFragment.ActivityInterface {

    private static final String TAG = "MainActivityTAG_";

    public static final String CUSTOM_EVENT_KEY = "CUSTOM_ACTION_BROADCAST";

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "doMagic: BroadcastReceiver");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(mMessageReceiver,
                        new IntentFilter(CUSTOM_EVENT_KEY));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager
                .getInstance(this)
                .unregisterReceiver(mMessageReceiver);
    }

    @Override
    public void doMagic() {
        Log.d(TAG, "doMagic: Interface");
    }
}
