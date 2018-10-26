package com.ict.app.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ict.app.R;
import com.ict.app.pojo.LecturerProfile;

public class LecturerProfileAdapter extends ArrayAdapter<LecturerProfile> {
	
	private Context context;
    private List<LecturerProfile> lecturers;
    
	public LecturerProfileAdapter(Context context, int resource, List<LecturerProfile> lecturers) {
		super(context, resource, lecturers);
        this.context = context;
        this.lecturers = lecturers;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lecturer_profile_rows, parent, false);
		
		LecturerProfile lecturer = lecturers.get(position);
		
		TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
		TextView textViewOffice = (TextView) view.findViewById(R.id.textViewOfficeNo);
         
	   // Display information
		textViewName.setText("Lecturer: " + lecturer.getLecturerName());
		textViewOffice.setText("Office Number: " + lecturer.getLecturerOfficeNo());
		
		return view; 
	}
}
