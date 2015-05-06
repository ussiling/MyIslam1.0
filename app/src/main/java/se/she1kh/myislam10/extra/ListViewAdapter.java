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

import se.she1kh.myislam10.R;

/**
 * Created by Usman on 4/30/2015.
 */
/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<PrayerItem> items;

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
    }

    public ListViewAdapter(Context context, ArrayList<PrayerItem> objects) {
        inflater = LayoutInflater.from(context);
        this.items = objects;
    }

    public int getCount() {
        return items.size();
    }

    public PrayerItem getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
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
        holder.textView1.setText(items.get(position).getNameOfPrayer());
        holder.textView2.setText(items.get(position).getTimeOfPrayer().toString());
        return convertView;
    }
}