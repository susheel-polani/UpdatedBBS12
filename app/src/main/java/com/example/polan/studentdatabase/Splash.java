package com.example.polan.studentdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.os.Handler;
import android.content.Intent;

/**
 * Created by polan on 19-09-2017.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int seconddelayed=1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, Mainpage.class));
                finish();
            }
        }, seconddelayed * 1000);
    }
}
