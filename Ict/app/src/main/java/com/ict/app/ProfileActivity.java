package com.ict.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ict.app.adapter.StudentProfileAdapter;
import com.ict.app.constant.Ict;
import com.ict.app.pojo.StudentProfile;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private ListView listViewProfile;
    private List<StudentProfile> students;
    private StudentProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle(Ict.PROFILE_TITLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewProfile = (ListView) findViewById(android.R.id.list);
        students = new ArrayList<>();

        // First check if the device is connected to the internet
        if (isOnline()) {
            // There is internet connection
            // display student subject registration details
            getStudentProfile();
        }
        else {
            // No internet
           Toast.makeText(ProfileActivity.this, "There is no internet connection.", Toast.LENGTH_LONG).show();
        }
    }


    // check for internet connectivity
    protected boolean isOnline() {
        ConnectivityManager connectManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    // Student Registration details
    public void getStudentProfile() {
        JsonObjectRequest requestProfile = new JsonObjectRequest(
                Request.Method.GET, Ict.ICT_APP_SERVER_URL
                + Ict.STUDENT_PROFILE_INFO, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray ar = response
                                    .getJSONArray("student");

                                JSONObject obj = ar.getJSONObject(0);

                                StudentProfile subj = new StudentProfile(obj
                                        .getString("student"), obj
                                        .getString("initials"), obj
                                        .getString("gender"), obj
                                        .getString("dob"));

                                students.add(subj);

                            adapter = new StudentProfileAdapter(
                                    ProfileActivity.this,
                                    R.layout.student_profile_rows, students);
                            listViewProfile.setAdapter(adapter);
                            // refresh list
                            adapter.notifyDataSetChanged();

                        } catch (Exception e) {
                            Toast.makeText(ProfileActivity.this,
                                    e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof AuthFailureError) {
                    Toast.makeText(ProfileActivity.this, "Authentication Failed.", Toast.LENGTH_LONG).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(ProfileActivity.this, "Network Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(ProfileActivity.this, "Connection time out. \nPlease try again.", Toast.LENGTH_LONG).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(ProfileActivity.this, "Internet Connection Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(ProfileActivity.this, "Server Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(ProfileActivity.this, "Parsing Error.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ProfileActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        RequestQueue requestQueue = Volley
                .newRequestQueue(ProfileActivity.this);
        requestQueue.add(requestProfile);

    }
}
