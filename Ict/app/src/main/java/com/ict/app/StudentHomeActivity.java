package com.ict.app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.ContextMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
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
import com.ict.app.adapter.RegistrationAdapter;
import com.ict.app.adapter.StudentProfileAdapter;
import com.ict.app.constant.Ict;
import com.ict.app.pojo.StudentProfile;
import com.ict.app.pojo.StudentSubject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listViewRegistration;
    private List<StudentSubject> subjects;
    private RegistrationAdapter adapter;
    private ProgressBar progressBarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBarInfo = (ProgressBar) findViewById(R.id.progressBarInfo);
        progressBarInfo.setVisibility(View.INVISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listViewRegistration = (ListView) findViewById(android.R.id.list);
        subjects = new ArrayList<>();

        // Check if there is internet connection
        if (isOnline()) {
            // display student subject registration details
            getRegistrationDetails();

        } else {
            Toast.makeText(StudentHomeActivity.this, "There is no internet connection.", Toast.LENGTH_LONG).show();
        }
    }

    // Student Registration details
    public void getRegistrationDetails() {

        progressBarInfo.setVisibility(View.INVISIBLE);

        JsonObjectRequest requestRegistration = new JsonObjectRequest(
                Request.Method.GET, Ict.ICT_APP_SERVER_URL
                + Ict.REGISTRATION_INFO, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray ar = response
                                    .getJSONArray("registration");

                            for (int i = 0; i < ar.length(); i++) {

                                JSONObject obj = ar.getJSONObject(i);

                                StudentSubject subj = new StudentSubject(obj.getInt("id"),
                                        obj.getString("subject_code"),
                                        obj.getString("subject_name"),
                                        obj.getString("course"),
                                        obj.getString("department"),
                                        obj.getString("status"),
                                        obj.getString("image_url"));

                                subjects.add(subj);
                            }

                            progressBarInfo.setVisibility(View.INVISIBLE);

                            adapter = new RegistrationAdapter(
                                    StudentHomeActivity.this,
                                    R.layout.subject_list, subjects);
                            listViewRegistration.setAdapter(adapter);
                            // refresh list
                            adapter.notifyDataSetChanged();
                            registerForContextMenu(listViewRegistration);

                        } catch (Exception e) {
                            Toast.makeText(StudentHomeActivity.this,
                                    e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof AuthFailureError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Authentication Failed.", Toast.LENGTH_LONG).show();
                } else if (error instanceof NetworkError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Network Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Connection time out. \nPlease try again.", Toast.LENGTH_LONG).show();
                } else if (error instanceof NoConnectionError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Internet Connection Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Server Error.", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, "Parsing Error.", Toast.LENGTH_LONG).show();
                }
                else {
					progressBarInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(StudentHomeActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        RequestQueue requestQueue = Volley
                .newRequestQueue(StudentHomeActivity.this);
        requestQueue.add(requestRegistration);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_subject, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        int id = item.getItemId();
        int position = menuInfo.position;

        if (id == R.id.action_view_status) {
            String subjectCode = subjects.get(position).getSubjCode();

            Intent intent = new Intent(StudentHomeActivity.this,
                    AvailabilityStatusActivity.class);
            intent.putExtra(Ict.STUDENT_SUBJ_CODE, subjectCode);

            startActivity(intent);

        } else if (id == R.id.action_profile) {
            Intent intent = new Intent(StudentHomeActivity.this,
                    ProfileActivity.class);
            startActivityForResult(intent, Ict.REQ_CODE);

        } else if (id == R.id.action_change_password) {
            Intent intent = new Intent(StudentHomeActivity.this,
                    ChangePasswordActivity.class);
            startActivityForResult(intent, Ict.REQ_CODE);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Ict.REQ_CODE && resultCode == RESULT_OK && data != null) {
            Toast.makeText(StudentHomeActivity.this, "Home Activity.", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(StudentHomeActivity.this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_student_profile) {
            startActivity(new Intent(StudentHomeActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_change_password) {
          startActivity(new Intent(StudentHomeActivity.this, ChangePasswordActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(StudentHomeActivity.this, MainActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
