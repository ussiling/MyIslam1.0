package se.she1kh.myislam10;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import se.she1kh.myislam10.extra.TabsPagerAdapter;
import se.she1kh.myislam10.lib.prayer.Method;
import se.she1kh.myislam10.lib.prayer.PrayerTime;
import se.she1kh.myislam10.lib.prayer.PrayerTimeCalc;
import se.she1kh.myislam10.lib.prayer.PrayerTimes;
import se.she1kh.myislam10.lib.prayer.astro.Location;

//Usman
public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiates viewpager
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));

        prefs  = getSharedPreferences("STATUS",Context.MODE_PRIVATE);

        String cityName = prefs.getString("isCityAvailable", "-1");
        removeableToast(cityName);
        if (cityName.equals("-1")) {
            //Step One - checking if LocationSetting is on
            checkLocationSetting();
        }else{
            startLocationService(false);
            removeableToast("Gillar du " +cityName);

//            setPrayerTimes();
        }
    }



    /**
     * Step one - check if the users Locationserivce is on
     * if not - openLocationSettings
     * else - start Service.
     */
    private void checkLocationSetting() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // getting GPS status
        boolean isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // getting network status
        boolean isNetworkEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!isGPSEnabled && !isNetworkEnabled) {
            // no network provider is enabled
            openLocationSettings();
        } else {
            //LocationSetting is ON - Step three
            Log.e("TRACKER","ACTIVITY 1");

            startLocationService(true);

            removeableToast("LOCATION IS ON");
        }


    }


    /**
     * Step two - a dialog ask the user if user want to open setting to start Locationservice
     * or enter it manually
     * or exit the app.
     */
    private void openLocationSettings() {
        new AlertDialog.Builder(this)
                .setTitle("Use Location?")
                .setMessage("We need to know where you are to get the right prayer times")

                        //Open Locationsettings
                .setPositiveButton(R.string.turnon, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // open setting
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                    }
                })
                        //Enter location manually
                .setNeutralButton(R.string.manually, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // open dialog to manuell input
                        removeableToast("Manuellt");
//                        inputLocation();
                    }
                })
                        //Exit app
                .setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // exit app
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    /**
     * Step two part two - when returning from the setting it goes back and checks
     * if user turned on the setting or not.
     *
     * @param requestCode - no use
     * @param resultCode  - no use
     * @param data        - no use
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        checkLocationSetting();

    }


    /**
     * Step three - start the service that gets the current location of the device
     * @param startgetLocation - getLocation again or just start the onLocationChange
     */
    public void startLocationService(boolean startgetLocation) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        MyService serv = new MyService(this);

        if (startgetLocation) {
            Log.i("ACITIVTY", "LOCATION " + serv.getLocation());
        }
    }


    /**
     * Alternativ Step three - if user chooses to enter it manually a Dialog show
     * where the user can enter their city name.
     */
    //___________________________________________________________________________
    public void inputLocation() {

    }


    //___________________________________________________________________________
    //Alternativ Step four - Tries to find the city name and convert it to a cordinates.
    private List<Address> processInput(String city) {
        Geocoder gcd = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gcd.getFromLocationName(city, 10);
            if (addresses.size() > 0) {
                for (int i = 0; i < addresses.size(); i++) {
                    Log.i("HOSSI", "HOSSI " + addresses.get(i).getLocality() + " lat " + addresses.get(i).getLatitude() + " long " + addresses.get(i).getLongitude());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return addresses;

    }
//

    private void removeableToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onResume() {
        super.onResume();

        // Register mMessageReceiver to receive messages.
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("EVENT"));
    }

    // handler for received Intents for the "my-event" event
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("TRACKER","ACTIVITY 2");

            // Extract data included in the Intent
//            String message = intent.getStringExtra("MSG");

//            Log.i("receiver", "Got message: " + intent.getStringExtra("ONLOCATIONCHANGED"));


            String result = intent.getStringExtra("ONLOCATIONCHANGED");
            String city = intent.getStringExtra("CITYNAME");

            Log.e("TRACKER","ACTIVITY 3 "+ result + city);

            if (city!=null){
                Toast.makeText(getApplicationContext(), city, Toast.LENGTH_LONG).show();
                prefs.edit().putString("isCityAvailable",city).apply();
            }

//            if (result.equals("START")) {
//                startApplication();
//            } else {
            if (result != null) {

                    Log.e("TRACKER","ACTIVITY 4");

                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();




            }
        }
//        }
    };


    @Override
    protected void onPause() {
        // Unregister since the activity is not visible
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onPause();
    }




}














