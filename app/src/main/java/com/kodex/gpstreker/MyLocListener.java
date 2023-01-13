package com.kodex.gpstreker;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.List;

public class MyLocListener implements LocationListener {
      LocListenerInterface locListenerInterface;
    @Override
    public void onLocationChanged(@NonNull Location location) {


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    public void setLocListenerInterface(LocListenerInterface locListenerInterface) {
        this.locListenerInterface = locListenerInterface;
    }
}
