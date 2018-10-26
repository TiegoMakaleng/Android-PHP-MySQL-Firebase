package com.ict.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ict.app.R;

import java.util.List;

/**
 * Created by Student on 2017-10-29.
 */

public class AboutInfoAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> info;

    private Typeface font = null;

    public AboutInfoAdapter(Context context, int resource, List<String> info) {
        super(context, resource, info);
        this.context = context;
        this.info = info;

        font = Typeface.createFromAsset(context.getAssets(), "font/PTN57F-webfont.ttf");

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.about_rows, parent, false);

        String about = info.get(position);

        TextView textViewDev = (TextView) view.findViewById(R.id.textViewDev);
        TextView textViewDetails = (TextView) view.findViewById(R.id.textViewDetails);
        textViewDetails.setTypeface(font);
        // Display information
        textViewDetails.setText(about);
  //      textViewBDetails.setText("Faculty: " + about.getFaculty() + "\nDepartment: " + about.getDepartment() + "\nYear: " + about.getYear());

        return view;
    }
}
