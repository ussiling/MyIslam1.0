package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import se.she1kh.myislam10.PrayerTime;
import se.she1kh.myislam10.R;
import se.she1kh.myislam10.extra.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Prayerfragment extends Fragment {
    ListView listView;

    ArrayList<String> prayerTimes;
    ArrayList<String> prayerNames;
    public Prayerfragment() {
        // Required empty public constructor
    }


    public static Prayerfragment newInstance(int num)  {
        Log.i("HOSSI","HOSSI SECOND");

        Prayerfragment f = new Prayerfragment();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        Log.i("HOSSI", "HOSSI THIRD");

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        PrayerTime pt = new PrayerTime();
//        prayer = pt.test();
        Log.i("HOSSI","HOSSI FISRT");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        //Listview that shows the Alarm, Prayername and Prayertime.
        listView = (ListView) view.findViewById(R.id.listView);

        isPrayerAvalible();

//        fillContent();
        fillContent(55.533,13.1,2);
        return view;
    }

    private void isPrayerAvalible() {
//        test(55.533,13.1,2);
    }



//         public ArrayList test(double latitude,double longitude,double timezone ){
////            double latitude = 55.533;
////            double longitude = 13.1;
////            double timezone = 2;
//
//            // Test Prayer times here
//            PrayerTime prayers = new PrayerTime();
//
//            prayers.setTimeFormat(prayers.getTime12());
//            prayers.setCalcMethod(prayers.getJafari());
//            prayers.setAsrJuristic(prayers.getShafii());
//            prayers.setAdjustHighLats(prayers.getAngleBased());
//            int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
//            prayers.tune(offsets);
//
//            Date now = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(now);
//
//            ArrayList<String> prayerTimes = prayers.getPrayerTimes(cal,latitude, longitude, timezone);
//            ArrayList<String> prayerNames = prayers.getTimeNames();
//
////            ArrayList prayer = new ArrayList<>();
////
////            for (int i = 0; i < prayerTimes.size(); i++) {
////                System.out.println(prayerNames.get(i) + " - " + prayerTimes.get(i));
////                prayer.add(new PrayerItem(prayerNames.get(i),prayerTimes.get(i)));
////            }
////            return prayer;
//    }


    /**
     * This method puts dummy times so the app is not empty the first time the apps opens
     * and it have to load the times witch could take more then a couple of seconds.
     */
    private void fillContent(double latitude,double longitude,double timezone ) {

//        double latitude = 55.533;
//        double longitude = 13.1;
//        double timezone = 2;

        // Test Prayer times here
        PrayerTime prayers = new PrayerTime();

        prayers.setTimeFormat(prayers.getTime12());
        prayers.setCalcMethod(prayers.getJafari());
        prayers.setAsrJuristic(prayers.getShafii());
        prayers.setAdjustHighLats(prayers.getAngleBased());
        int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        prayerTimes = prayers.getPrayerTimes(cal,latitude, longitude, timezone);
        prayerNames = prayers.getTimeNames();


        ListViewAdapter customAdapter = new ListViewAdapter(getActivity(), prayerNames,prayerTimes);
        listView.setAdapter(customAdapter);

    }

//    public void testPrayer(){
//    /* As an example, we use Depok (West Java, Indonesia) as the location
//     * and Egyptian General Authority of Survey as the method.
//     * */
//
//        // new Location(latitude, longitude, GMT diff, daylight saving time)
//        Location location = new Location( 55.5645, 12.974, +1, 1);
//
//        ArrayList ray = new ArrayList();
//        ray.add(Method.NONE);
//        ray.add(Method.NORTH_AMERICA);
//        ray.add(Method.EGYPT_SURVEY);
//        ray.add(Method.FIXED_ISHAA);
//        ray.add(Method.KARACHI_HANAF);
//        ray.add(Method.MUSLIM_LEAGUE);
//        ray.add(Method.KARACHI_SHAF);
//        ray.add(Method.UMM_ALQURRA);
//    for (int i=0; i<8 ;i++) {
//        PrayerTimeCalc calculator = new PrayerTimeCalc(location, (Method)ray.get(i));
//
//
//    /* Calculate prayer times for today. */
//
//        PrayerTimes prayerTimes = calculator.getPrayerTimes(new Date());
//
//    /* Print Fajr and sunrise time. */
//
//        PrayerTime fajr = prayerTimes.get(PrayerTimes.FAJR);
//        PrayerTime fajr2 = prayerTimes.get(PrayerTimes.SUNRISE);
//        PrayerTime fajr3 = prayerTimes.get(PrayerTimes.ASR);
//        PrayerTime fajr4 = prayerTimes.get(PrayerTimes.MAGHRIB);
//        PrayerTime fajr5 = prayerTimes.get(PrayerTimes.ISHA);
//
//        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr.getHour() + " : " + fajr.getMinute());
//        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr2.getHour() + " : " + fajr2.getMinute());
//        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr3.getHour() + " : " + fajr3.getMinute());
//        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr4.getHour() + " : " + fajr4.getMinute());
//        Log.i("HOSSI", "HOSSI " + " FAJR : " + fajr5.getHour() + " : " + fajr5.getMinute());
//        Log.i("HOSSI","_____________________________________________________________");
//
//    }
//    }


}
