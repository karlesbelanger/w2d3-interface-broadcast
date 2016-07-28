package com.example.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//2. Implement Interface
public class MainActivity extends AppCompatActivity implements BlankFragment.ActivityInterface {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void doMagic() {
        Log.d(TAG, "doMagic: ");
    }
}
