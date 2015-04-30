package se.she1kh.myislam10.extra;

/**
 * Created by Usman on 4/30/2015.
 */
public class PrayerItem {
    private String nameOfPrayer;
    private String timeOfPrayer;


    public PrayerItem(String name , String time){
        this.nameOfPrayer = name;
        this.timeOfPrayer = time;

    }
    public String getTimeOfPrayer() {
        return timeOfPrayer;
    }

    public String getNameOfPrayer() {
        return nameOfPrayer;
    }

}
