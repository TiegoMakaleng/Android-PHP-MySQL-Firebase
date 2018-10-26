package com.ict.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import com.ict.app.adapter.AvailabilityStatusAdapter;
import com.ict.app.constant.Ict;
import com.ict.app.pojo.LecturerAvailability;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityStatusActivity extends AppCompatActivity {


    private ListView listViewAvailability;
    private List<LecturerAvailability> subjects;
    private AvailabilityStatusAdapter adapter;
    private String subjectCode = null;

    private ProgressBar progressBarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability_status);

        setTitle(Ict.LECTURER_STATUS_TITLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBarInfo = (ProgressBar) findViewById(R.id.progressBarInfo);
        progressBarInfo.setVisibility(View.INVISIBLE);

        listViewAvailability = (ListView) findViewById(android.R.id.list);
        subjects = new ArrayList<>();

        subjectCode = getIntent().getStringExtra(Ict.STUDENT_SUBJ_CODE);

        // check if internet is available
        if(isOnline()) {
            // display student subject registration details
            getAvailabilityDetails();

        } else {
            // There is no internet
            Toast.makeText(AvailabilityStatusActivity.this, "There is no internet connection.", Toast.LENGTH_LONG).show();

        }
    }

    // Check for Internet Connection
    protected boolean isOnline() {
        ConnectivityManager connectManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    //Lecturer availability details
    public void getAvailabilityDetails() {

        progressBarInfo.setVisibility(View.VISIBLE);

        JsonObjectRequest requestRegistration = new JsonObjectRequest(Request.Method.GET, Ict.ICT_APP_SERVER_URL + Ict.REGISTRATION_SUBJ_INFO + subjectCode,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray ar = response.getJSONArray("availability");

                            for (int i = 0; i < ar.length(); i++) {

                                JSONObject obj = ar.getJSONObject(i);

                                LecturerAvailability subj = new LecturerAvailability(obj.getString("subject_code"), obj.getString("subject_name"),obj.getString("reg_date"),
                                        obj.getString("lecturer"), obj.getString("availability"), obj.getString("date_available"),
                                        obj.getString("time_available"));

                                subjects.add(subj);
                            }

                            progressBarInfo.setVisibility(View.INVISIBLE);

                            adapter = new AvailabilityStatusAdapter(AvailabilityStatusActivity.this, R.layout.lecturer_rows, subjects);
                            listViewAvailability.setAdapter(adapter);
                            // refresh list
                            adapter.notifyDataSetChanged();
                            registerForContextMenu(listViewAvailability);

                        } catch (Exception e) {
                            Toast.makeText(AvailabilityStatusActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof AuthFailureError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Authentication Failed.", Toast.LENGTH_LONG).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Network Error.", Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Connection time out. \nPlease try again.", Toast.LENGTH_LONG).show();
                        } else if (error instanceof NoConnectionError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Internet Connection Error.", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Server Error.", Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(AvailabilityStatusActivity.this, "Parsing Error.", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(AvailabilityStatusActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(AvailabilityStatusActivity.this);
        requestQueue.add(requestRegistration);

    }

}
