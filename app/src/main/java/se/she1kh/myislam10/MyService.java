package se.she1kh.myislam10;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Usman on 2015-03-21.
 *
 */
public class MyService  extends Service implements LocationListener {

    private Location location;
    private double latitude, longitude;
    private static final String TAG= "HOSSI MyService ";

    private Activity activity;

    public MyService(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"HOSSI onBind ");

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "HOSSI onCreate");
    }

    public Location getLocation() {
        Log.e("TRACKER", "Service 2");

        try {
            LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

            boolean isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
            // getting network status
            boolean isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            int MIN_TIME_BW_UPDATES = 1000*60*60;                  //in milliseconds , every hour
            int MIN_DISTANCE_CHANGE_FOR_UPDATES = 1000;      //in meter , one km

                // First get location from Network Provider
            if (isNetworkEnabled) {

                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                Log.d("Network", "Network");
                Log.e("TRACKER", "Service 3");

                location = locationManager
                        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                        Log.i("KNOW", "KNOW networkproivder " + location.getTime());
                if (location != null) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    if (twoHours(location.getTime())) {
                        Log.i("KNOW", "KNOW got new location netwoek " + latitude + longitude + " " + location.getTime());
                        return location;
                    }
                }

            }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        Log.e("TRACKER","Service 3");

                        location = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        Log.i("KNOW", "KNOW got GPS PROVIDER " + location.getTime());

                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            Log.i("KNOW", "KNOW got new location GPS");

                            if (twoHours(location.getTime())){
                                Log.i("KNOW", "KNOW got new location netwoek " + latitude + longitude + " " + location.getTime());
                                return location;
                            }


                        }
                    }
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("TRACKER", "Service 4");

        return location;
    }

    private boolean twoHours(long time) {
        Date d = new Date();
        d.getTime();
        long twohours = 7200000;
        long millis = System.currentTimeMillis();
        long t = millis - time;
        Log.d("HOSSI","HOSSI " + t);

            return millis - time < twohours;
    }


    @Override
    public void onLocationChanged(Location location) {
        double lattemp = location.getLatitude();
        double longtemp = location.getLongitude();
        Log.e("TRACKER","Service 5");

        if (latitude - 1 < lattemp && lattemp > latitude + 1) {

            Log.e("TRACKER","Service 6 " + "send lat " + latitude + lattemp);
            sendResult("ONLOCATIONCHANGED", "HOSSI latitude chaged " + latitude + " temp " + lattemp);
        }
        if (longitude - 1 < longtemp && longtemp > longitude + 1) {

            Log.e("TRACKER","Service 6 " + "send long " + longitude + longtemp);
            sendResult("ONLOCATIONCHANGED", "HOSSI longitute chaged " + longitude + " temp " + longtemp);

        }
        Log.e("TRACKER","Service 7 " + "send " + location.getLongitude() + " " + location.getLatitude());
        sendResult("ONLOCATIONCHANGED", "Den är ändrad " + location.getLongitude() + " " + location.getLatitude());
//        sendLocation("ONLOCATIONCHANGED",location);
        latitude = location.getLatitude();
        longitude = location.getLongitude();
//        String mlat = String.valueOf(latitude);
//        String mlon = String.valueOf(longitude);
//        Log.i("HOSSI", "SERVICE onLocationChanged 4 lat" + mlat + " long " + mlon);

        getNameofLocation(location);
//        new PostData().execute(mlat, mlon, mtime);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}
    @Override
    public void onProviderEnabled(String provider) {}
    @Override
    public void onProviderDisabled(String provider) {}


    private void getNameofLocation(Location location) {

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//            Log.i("HOSSI", "HOSSI HOSSI GOT STAD " + addresses.get(0).getLocality());
//            String city = addresses.get(0).getLocality();
//            String prayerMode = "1";
//            Log.i("HOSSI", "HOSSI getNameofLocation 6 startThread next ");
            Log.e("TRACKER","Service 8 " + "send " + addresses.get(0).getLocality());
            sendResult("CITYNAME",addresses.get(0).getLocality());
//            new GetPrayerTime().execute(prayerMode, city);

        } catch (IOException ignored) {

        }

    }


    private void sendResult(String msg, String result) {
        Intent intent = new Intent("EVENT");
        // add data
        intent.putExtra(msg, result);

        Log.i("HOSSI", "HOSSI sendRes 10 " + msg + " " + result);


        LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(intent);
        Log.i("HOSSI", "HOSSI SEND message: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG,"HOSSI onDestroy ");
    }
}