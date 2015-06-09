package se.she1kh.myislam10.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import se.she1kh.myislam10.MainActivity;
import se.she1kh.myislam10.MyService;
import se.she1kh.myislam10.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    public final String TAG = "HOSSI BlankFragment ";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        TextView tv = (TextView) view.findViewById(R.id.fragment_txt);
        tv.setText(getArguments().getString("msg"));


        ((MainActivity)getActivity()).isMyServiceRunning(MyService.class);

        Log.i(TAG, "ANSWER IS = "+ ((MainActivity)getActivity()).isMyServiceRunning(MyService.class));
        return view;
    }

    public static BlankFragment newInstance(int num) {

        BlankFragment f = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
}
