//package se.she1kh.myislam10;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//
////import se.she1kh.myislam10.extra.StaticItem;
//
///**
// * Created by Ussi on 15-01-27.
// *
// */
//public class MyDatabase extends SQLiteOpenHelper {
////    StaticItem si = new StaticItem();
//    private static final String DB_NAME = "DailyPrayers";
//    private static final int DB_VERSION = 1;
//    private SQLiteDatabase database;
//    private Cursor cursor;
//
//
//
//    public MyDatabase(Context context) {
//
//        super(context, DB_NAME, null, DB_VERSION);
//    }
//
//
//    /**
//     * Öppnar kopplingen
//     */
//    public void open() {
//        database = getWritableDatabase();
//    }
//
//    /**
//     * Stänger kopplingen
//     */
//    public void close() {
//        database.close();
//
//    }
//
//    /**
//     * Skapar mina tabeller här
//     *
//     * @param database Databasen
//     */
//    @Override
//    public void onCreate(SQLiteDatabase database) {
//        Log.i("HOSSI", "HOSSI MYDB ONCREATE FÖRST");
//        database.execSQL("create table prayDay (prayDate DATE PRIMARY KEY,prayOne VARCHAR(200),sunrise VARCHAR(200),prayTwo VARCHAR(200),prayThree VARCHAR(200),prayFour VARCHAR(200),prayFive VARCHAR(200) )" );
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}
//
//
////    public boolean checkDate(){
////        String currentDate = si.getCurrentDate();
////        String date = "";
////        open();
////
////        cursor = database.rawQuery("SELECT * FROM prayDay", null);
////        if (cursor.moveToFirst()) {
////                do {
////                    Log.i("HOSSI", "HOSSI DB GET KOLLAR DATUM ÄR = " + cursor.getString(0));
////                    date = cursor.getString(0);
////                    if(si.getCurrentDate().equals(cursor.getString(0))){
////                        cursor.close();
////                        close();
////                        return true;
////                    }
////                }while(cursor.moveToNext());
////        }
////
////        cursor.close();
////        close();
////        Log.i("HOSSI", "HOSSI datum JÄMFÖR  " + currentDate.equals(date) + " 1 +" + currentDate + " + 2 " + date);
////
////        return false;
////    }
//
//    public boolean addPrayers(String date, String fajr, String sunrise, String zuhr, String asr, String maghrib, String isha) {
//            try {
//                open();
//                ContentValues values = new ContentValues();
//
//                values.put("prayDate", date);
//                values.put("prayOne", fajr);
//                values.put("sunrise",sunrise);
//                values.put("prayTwo", zuhr);
//                values.put("prayThree", asr);
//                values.put("prayFour", maghrib);
//                values.put("prayFive", isha);
////                values.size();
//                Log.i("HOSSI", "HOSSI db  date " + date);
//
//                database.insertWithOnConflict("prayDay", null, values, SQLiteDatabase.CONFLICT_REPLACE);
//                close();
//            }catch (Exception e){
//                return false;
//            }
//        return true;
//    }
//
//
////    public ArrayList getDay() {
////
////        ArrayList allDay = new ArrayList();
////
////        open();
////
////        cursor = database.rawQuery("SELECT * FROM prayDay WHERE prayDate="+si.getCurrentDate(), null);
////        if (cursor.moveToFirst()) {
////            for (int i=0;i<7;i++) {
////                Log.i("HOSSI", "HOSSI DB GET ONETIME " + i + "= " + cursor.getString(i));
////                allDay.add(cursor.getString(i));
////            }
////        }
////
////        cursor.close();
////        close();
////
////        return allDay;
////    }
//
//
//}
