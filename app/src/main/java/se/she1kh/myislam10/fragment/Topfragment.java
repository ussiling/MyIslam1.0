package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.she1kh.myislam10.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Topfragment extends Fragment {


    public Topfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topfragment, container, false);
    }


}
