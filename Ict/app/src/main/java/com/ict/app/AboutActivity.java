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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ict.app.adapter.AboutInfoAdapter;
import com.ict.app.constant.Ict;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private ListView listInfo;
    private List<String> info;
    private AboutInfoAdapter adapter;

    private DatabaseReference databaseReference;

    private ProgressBar progressBarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle(Ict.ABOUT_TITLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listInfo = (ListView) findViewById(android.R.id.list);
        info = new ArrayList<>();

        progressBarInfo = (ProgressBar) findViewById(R.id.progressBarInfo);
        progressBarInfo.setVisibility(View.INVISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        if (isOnline()) {
            // display about information
            getAboutInfo();
        }
        else {
            Toast.makeText(AboutActivity.this, "There is no internet connection.", Toast.LENGTH_LONG).show();
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

    public void getAboutInfo() {

        progressBarInfo.setVisibility(View.VISIBLE);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                info.clear();
               for (DataSnapshot aboutDataSnapshot : dataSnapshot.getChildren()) {
                 String about = aboutDataSnapshot.getValue(String.class);
                 info.add(about);
               }

               progressBarInfo.setVisibility(View.INVISIBLE);

               adapter = new AboutInfoAdapter(AboutActivity.this, R.layout.about_rows, info);
               listInfo.setAdapter(adapter);adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
