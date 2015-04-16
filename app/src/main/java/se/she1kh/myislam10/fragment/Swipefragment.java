package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.she1kh.myislam10.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Swipefragment extends Fragment {


    public Swipefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_swipefragment, container, false);
    }
    public static Swipefragment newInstance(String text) {

        Swipefragment f = new Swipefragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
