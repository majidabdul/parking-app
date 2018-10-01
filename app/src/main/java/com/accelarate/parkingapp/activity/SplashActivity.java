package com.accelarate.parkingapp.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.accelarate.parkingapp.parkingapp.R;

public class SplashActivity extends AppCompatActivity {
    Context context;
    ImageView imageView;
    ProgressBar progressBar;
    private int pStatus=0;
    //CoordinatorLayout coordinatorLayout;
    private static final int MY_LOCATION_REQUEST_CODE = 7;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        imageView = (ImageView) findViewById(R.id.imgView);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        imageView.setAnimation(anim);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //coordinatorLayout = (CoordinatorLayout) findViewById(R.id.myCoordinatorLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        recheck();
    }

    private void recheck() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (pStatus <= 20) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(pStatus);
                                if (pStatus >= 70) {

                                }
                            }
                        });
                        try {
                            Thread.sleep(70);
                        } catch (Exception e) {
                        }
                        pStatus++;
                    }
                }
            }).start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    /*if (checkNetwork.haveNetworkConnection()) {*/

                            if (ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }

                            else if (ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }

                            else if(ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }
                            else if(ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }
                            else if(ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }
                            else if(ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }
                            else if(ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA}, MY_LOCATION_REQUEST_CODE);
                            }
                            else{
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                            }
                    /*} else {
                        Snackbar.make(coordinatorLayout, "No Internet..", Snackbar.LENGTH_INDEFINITE)
                                .setAction("Enable", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                                    }
                                })
                                .show();
                    }*/
                }
            }, 5000);

    }
}
