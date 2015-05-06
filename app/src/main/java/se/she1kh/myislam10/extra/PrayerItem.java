package se.she1kh.myislam10.extra;

import se.she1kh.myislam10.lib.prayer.PrayerTime;

/**
 * Created by Usman on 4/30/2015.
 */
public class PrayerItem {
    private String nameOfPrayer;
    private PrayerTime timeOfPrayer;


    public PrayerItem(String name , PrayerTime time){
        this.nameOfPrayer = name;
        this.timeOfPrayer = time;

    }
    public PrayerTime getTimeOfPrayer() {
        return timeOfPrayer;
    }

    public String getNameOfPrayer() {
        return nameOfPrayer;
    }

}
