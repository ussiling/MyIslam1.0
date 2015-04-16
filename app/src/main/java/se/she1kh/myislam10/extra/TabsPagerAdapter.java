package se.she1kh.myislam10.extra;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import se.she1kh.myislam10.fragment.BlankFragment;
import se.she1kh.myislam10.fragment.Prayerfragment;
import se.she1kh.myislam10.fragment.Swipefragment;

/**
 * Created by Usman on 2015-03-21.
 *
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return Prayerfragment.newInstance("FirstFragment, Instance 1");
            case 1: return BlankFragment.newInstance("SecondFragment, Instance 1");
            case 2: return Swipefragment.newInstance("ThirdFragment, Instance 1");
            case 3: return Prayerfragment.newInstance("ThirdFragment, Instance 2");
            case 4: return Swipefragment.newInstance("ThirdFragment, Instance 3");
            default: return Prayerfragment.newInstance("ThirdFragment, Default");

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

}