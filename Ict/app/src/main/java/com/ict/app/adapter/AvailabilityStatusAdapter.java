package com.ict.app.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ict.app.R;
import com.ict.app.pojo.LecturerAvailability;


public class AvailabilityStatusAdapter extends ArrayAdapter<LecturerAvailability> {
	
	private Context context;
    private List<LecturerAvailability> subjects;

	private Typeface font = null;

	public AvailabilityStatusAdapter(Context context, int resource, List<LecturerAvailability> subjects) {
		super(context, resource, subjects);
        this.context = context;
        this.subjects = subjects;

		font = Typeface.createFromAsset(context.getAssets(), "font/PTN57F-webfont.ttf");

	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lecturer_rows, parent, false);
		
		LecturerAvailability lecturer = subjects.get(position);
		
		TextView textViewLecturerName = (TextView) view.findViewById(R.id.textViewSubjLecturer);
		TextView textViewSubjectName = (TextView) view.findViewById(R.id.textViewSubjName);
		TextView textViewAvailability = (TextView) view.findViewById(R.id.textViewAvailability);

		textViewLecturerName.setTypeface(font);
		textViewSubjectName.setTypeface(font);
		textViewAvailability.setTypeface(font);

		if (lecturer.getAvailabilityStatus().equals("Available")) {
			//Display information
			textViewLecturerName.setText("Lecturer: " + lecturer.getLecturerName());

			textViewSubjectName.setText("Subject: " + lecturer.getSubjectName() + "\nStatus: " + lecturer.getAvailabilityStatus() );
		    textViewAvailability.setText("Date Available: " + lecturer.getAvailabilityDate() + "\nTime Avilable: " + lecturer.getAvailabilityTime());
		} else {
			//Unavailable
			//Display information
			textViewLecturerName.setText("Lecturer: " + lecturer.getLecturerName());
			textViewSubjectName.setText("Subject: " + lecturer.getSubjectName() + "\nStatus: " + lecturer.getAvailabilityStatus());
			
		}
		
		return view; 
	}
}
