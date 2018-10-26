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
import com.ict.app.pojo.StudentProfile;

public class StudentProfileAdapter  extends ArrayAdapter<StudentProfile> {
	
	private Context context;
    private List<StudentProfile> students;
    
	public StudentProfileAdapter(Context context, int resource, List<StudentProfile> students) {
		super(context, resource, students);
        this.context = context;
        this.students = students;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.student_profile_rows, parent, false);
		
		StudentProfile student = students.get(position);
		
		TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
		TextView textViewBirthdate = (TextView) view.findViewById(R.id.textViewBirthdate);
		TextView textViewGender = (TextView) view.findViewById(R.id.textViewGender);
         
	   // Display information
		textViewName.setText("Name: " + student.getStudentSurname() + " " + student.getStudentInitials());
		textViewBirthdate.setText("Date of Birth: " + student.getStudentBirthdate());
		textViewGender.setText("Gender: " + student.getStudentGender());
		
		return view; 
	}
}
