package se.she1kh.myislam10.extra;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//import se.she1kh.myislam10.PrayerItem;
import se.she1kh.myislam10.R;

/**
 * Created by Usman on 4/30/2015.
 */
/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<String> pname;
    private ArrayList<String> ptime;

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
    }

    public ListViewAdapter(Context context, ArrayList pname, ArrayList ptime) {
        inflater = LayoutInflater.from(context);
        this.pname = pname;
        this.ptime = ptime;
    }

    public int getCount() {
        return pname.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.prayer_row, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.lv_prayerName);
            holder.textView2 = (TextView) convertView.findViewById(R.id.lv_prayerTime);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(pname.get(position));
        holder.textView2.setText(ptime.get(position));
        return convertView;
    }
}