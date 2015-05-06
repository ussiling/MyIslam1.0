package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import se.she1kh.myislam10.R;
import se.she1kh.myislam10.extra.ListViewAdapter;
import se.she1kh.myislam10.extra.PrayerItem;
import se.she1kh.myislam10.lib.prayer.Method;
import se.she1kh.myislam10.lib.prayer.PrayerTime;
import se.she1kh.myislam10.lib.prayer.PrayerTimeCalc;
import se.she1kh.myislam10.lib.prayer.PrayerTimes;
import se.she1kh.myislam10.lib.prayer.astro.Location;

/**
 * A simple {@link Fragment} subclass.
 */
public class Prayerfragment extends Fragment {
    ListView listView;
    ArrayList<String> prayerName;
    public Prayerfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        //Listview that shows the Alarm, Prayername and Prayertime.
        listView = (ListView) view.findViewById(R.id.listView);

        isPrayerAvalible();

        fillContent();
        return view;
    }

    private void isPrayerAvalible() {

    }


    /**
     * This method puts dummy times so the app is not empty the first time the apps opens
     * and it have to load the times witch could take more then a couple of seconds.
     */
    private void fillContent() {
//
//        prayerName = new ArrayList<String>();
//        prayerName.add("Fajr");
//        prayerName.add("Sunrise");
//        prayerName.add("Zuhr");
//        prayerName.add("Asr");
//        prayerName.add("Maghrib");
//        prayerName.add("Isha");
//
//
//

        // new Location(latitude, longitude, GMT diff, daylight saving time)
        Location location = new Location( 55.5645, 12.974, +1, 1);
        PrayerTimeCalc calculator = new PrayerTimeCalc(location, Method.NORTH_AMERICA);

    /* Calculate prayer times for today. */

        PrayerTimes prayerTimes = calculator.getPrayerTimes(new Date());


        ArrayList<PrayerItem> items = new ArrayList<PrayerItem>();
        PrayerItem prayerItem;

        prayerItem = new PrayerItem(getString(R.string.fajr),prayerTimes.get(PrayerTimes.FAJR));
        items.add(prayerItem);
        prayerItem = new PrayerItem(getString(R.string.sunrise),prayerTimes.get(PrayerTimes.SUNRISE));
        items.add(prayerItem);
        prayerItem = new PrayerItem(getString(R.string.zuhr),prayerTimes.get(PrayerTimes.ZUHR));
        items.add(prayerItem);
        prayerItem = new PrayerItem(getString(R.string.asr),prayerTimes.get(PrayerTimes.ASR));
        items.add(prayerItem);
        prayerItem = new PrayerItem(getString(R.string.maghrib),prayerTimes.get(PrayerTimes.MAGHRIB));
        items.add(prayerItem);
        prayerItem = new PrayerItem(getString(R.string.isha),prayerTimes.get(PrayerTimes.ISHA));
        items.add(prayerItem);

        ListViewAdapter customAdapter = new ListViewAdapter(getActivity(), items);
        listView.setAdapter(customAdapter);

//        ListViewAdapter adapter = new ListViewAdapter(getActivity(),,null);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1 ,prayerName );
//        listView.setAdapter(adapter);
    }

    public void testPrayer(){
    /* As an example, we use Depok (West Java, Indonesia) as the location
     * and Egyptian General Authority of Survey as the method.
     * */

        // new Location(latitude, longitude, GMT diff, daylight saving time)
        Location location = new Location( 55.5645, 12.974, +1, 1);
        PrayerTimeCalc calculator = new PrayerTimeCalc(location, Method.NORTH_AMERICA);

    /* Calculate prayer times for today. */

        PrayerTimes prayerTimes = calculator.getPrayerTimes(new Date());

    /* Print Fajr and sunrise time. */

        PrayerTime fajr = prayerTimes.get(PrayerTimes.FAJR);
        PrayerTime fajr2 = prayerTimes.get(PrayerTimes.SUNRISE);
        PrayerTime fajr3 = prayerTimes.get(PrayerTimes.ASR);
        PrayerTime fajr4 = prayerTimes.get(PrayerTimes.MAGHRIB);
        PrayerTime fajr5 = prayerTimes.get(PrayerTimes.ISHA);

        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr.getHour() + " : " + fajr.getMinute());
        Log.i("HOSSI" , "HOSSI " +" FAJR : " + fajr2.getHour() + " : " + fajr2.getMinute());
        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr3.getHour() + " : " + fajr3.getMinute());
        Log.i("HOSSI" , "HOSSI " +" FAJR : " + fajr4.getHour() + " : " + fajr4.getMinute());
        Log.i("HOSSI" , "HOSSI " +" FAJR : " + fajr5.getHour() + " : " + fajr5.getMinute());
    }

    public static Prayerfragment newInstance(String text) {

        Prayerfragment f = new Prayerfragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
