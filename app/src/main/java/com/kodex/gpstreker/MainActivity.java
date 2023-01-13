package com.kodex.gpstreker;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocListenerInterface {

    private TextView tvDistance, tvPassed, tvSpeed, tvCoordinates;
    private ProgressBar progressBar;
    private Location lastLocation;
    private LocationManager locationManager;
    private MyLocListener myLocListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkPermission();
    }

    private void init(){
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        myLocListener =new MyLocListener();
        myLocListener.setLocListenerInterface(this);
        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100 && grantResults[0] == RESULT_OK)
        {
            checkPermission();
        }
        else {
            Log.d("check", " No GPS Provider");
        }
    }

    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION},
                        100);
        }
        else
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 10, myLocListener);

            Log.d("check"," Что то пошло не так");
        }
    }
    @Override
    public void OnLocationChanged(Location loc) {

    }
}