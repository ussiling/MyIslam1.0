package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import se.she1kh.myislam10.R;

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
     * and it have to load the times wich could take more then a couple of seconds.
     */
    private void fillContent() {

        prayerName = new ArrayList<String>();
        prayerName.add("Fajr");
        prayerName.add("Sunrise");
        prayerName.add("Zuhr");
        prayerName.add("Asr");
        prayerName.add("Maghrib");
        prayerName.add("Isha");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1 ,prayerName );
        listView.setAdapter(adapter);
    }

    public static Prayerfragment newInstance(String text) {

        Prayerfragment f = new Prayerfragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
