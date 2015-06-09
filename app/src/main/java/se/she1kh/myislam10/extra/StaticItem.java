//package se.she1kh.myislam10.extra;
//
//import android.util.Log;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//import se.she1kh.myislam10.MyDatabase;
//
////import se.she1kh.myislam10.MyDatabase;
//
///**
// * Created by Ussi on 15-01-27.
// */
//
//public class StaticItem {
//    MyDatabase database;
//
//    public static final String ERROR = "-1";
//
//    public static final String Egyptian_General_Authority = "1";
//    public static final String Islamic_Sciences_Shafi = "2";
//    public static final String Islamic_Sciences_Hanafi = "3";
//    public static final String Islamic_North_America = "4";
//    public static final String Muslim_World_League = "5";
//    public static final String Umm_Al_Qura = "6";
//    public static final String Fixed_Isha = "7";
//
//    public static final String USER_TIME_MODE = "prayer_time_mode";
//    public static final String USER_CITY = "user_city";
//    public static final String IN_DATABASE = "times_in_database";
//    public static final String LOCATION_TO_CITY = "location_to_city";
//    public StaticItem(){
//    }
//
//    public String getCurrentDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String currentDate= sdf.format(new Date());
//        if (currentDate!=null) {
//            return currentDate;
//        }else {
//            return ERROR;
//        }
//    }
//
//    public String timeConvert(String ampm) {
//        String time = null;
//        try {
//            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
//            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
//            Date date = parseFormat.parse(ampm);
//            time = displayFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return time;
//    }
//
//    public String dateConvert(String gotDate) {
//        String time = null;
//        try {
//            SimpleDateFormat displayFormat = new SimpleDateFormat("yyyyMMdd");
//            SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = parseFormat.parse(gotDate);
//            time = displayFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return time;
//    }
//
//
//   public String rightnowPrayer(MyDatabase database){
//       this.database = database;
//       ArrayList prayDay = database.getDay();
//       ArrayList prayers = new ArrayList();
//       for (int i = 0; i< prayDay.size();i++){
//           prayers.add(prayDay.get(0)+" " + prayDay.get(i));
//
//       }
//
//       String start,end;
//       long startDate = 0,endDate = 0,now = 0;
//       Date startD = null;
//       Date endD = null;
//       try {
//           start = prayDay.get(0)+" " + prayDay.get(1);
//           end = prayDay.get(0)+" " + prayDay.get(2);
//           Log.i("DDATE", "DDATE start" + start + " end " + end);
//
//           startD = new SimpleDateFormat("yyyyMMdd HH:mm").parse(start);
//           endD = new SimpleDateFormat("yyyyMMdd HH:mm").parse(end);
//
//           Log.i("DDATE", "DDATE start" + startD + " end " + endD);
//
//           startDate = startD.getTime();
//           now = (new Date()).getTime();
//           endDate = endD.getTime();
//
//           Log.i("DDATE", "DDATE start" + startDate + " nu " + now + " end " + endDate);
//
//
//       } catch (ParseException e) {
//           e.printStackTrace();
//       }
//
//
//
////
////       }
//
//
//
////       for (int i = 0; i < prayDay.size(); i++) {
////
////           resultdate = (String)prayDay.get(1);
////            Log.i("HOSSI2","HOSSI2 " + resultdate);
////           //Hämtar tid i millis, nutid
////           long millis = System.currentTimeMillis();
////
////           //GÖR OM MILIS TILL TID
//////       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//////       Date resultdate = new Date(millis);
//////       Log.i("hossi", "hossi " + sdf.format(resultdate) + " milis " + millis);
////
////
////           //Gör tid till millis
//////           SimpleDateFormat sdf2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
////           SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
////           try {
////               Date mDate = sdf2.parse(sdf2.format(resultdate));
////               long timeInMilliseconds = mDate.getTime();
////
////               long tiden = millis - timeInMilliseconds;
////
////               Log.i("hossi", "hossi " + tiden);
////                skicka = tiden + " ";
////
////
////           } catch (ParseException e) {
////               e.printStackTrace();
////           }
//////       if ()
////       }
//
//       return "";
//   }
//
//    public String rightnowPrayer(ArrayList<String> prayTime, ArrayList<String> prayerName) {
//
//        String start,end,prayerNow ="-1";
//        long startDate = 0,endDate = 0,now = 0;
//        Date startD = null;
//        Date endD = null;
//        for (int i = 1;i<prayTime.size();i++) {
//            try {
//                Log.i("HOSSI3", "HOSSI3 " + prayTime.get(i) + " " + prayTime.size() + " " + i);
//
//                start = prayTime.get(0) + " " + prayTime.get(i);
//                if (i==6) {
//                    end = prayTime.get(0) + " " + prayTime.get(1);
//                    Log.i("HOSSI3", "HOSSI3 end if " + i);
//
//                }else{
//                    end = prayTime.get(0) + " " + prayTime.get(i + 1);
//                    Log.i("HOSSI3", "HOSSI3 end else " + i + 1);
//
//
//                }
//                    prayerNow = prayerName.get(i-1);
//                Log.i("DDATE", "DDATE start" + start + " end " + end);
//
//                startD = new SimpleDateFormat("yyyyMMdd HH:mm").parse(start);
//                endD = new SimpleDateFormat("yyyyMMdd HH:mm").parse(end);
//
//                Log.i("DDATE", "DDATE start" + startD + " end " + endD);
//
//                startDate = startD.getTime();
//                now = (new Date()).getTime();
//                endDate = endD.getTime();
//
//                Log.i("DDATE", "DDATE start" + startDate + " nu " + now + " end " + endDate);
//
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            if (startDate >= now && now <= endDate) {
//                return prayerNow;
//            }
//        }
//        return "-1";
//    }
//}
