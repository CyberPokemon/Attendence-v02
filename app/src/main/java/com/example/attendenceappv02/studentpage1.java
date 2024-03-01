package com.example.attendenceappv02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class studentpage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpage1);

        FragmentManager fragmentManager;
        fragmentManager=getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        final Intent[] intent = {new Intent(getApplicationContext(), attendenceHistory.class)};

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragmentToShow;

                switch (item.getItemId())
                {
                    case R.id.history:
                         fragmentToShow= new attendenceHistory();
                        break;
                    case R.id.scan:
                        fragmentToShow= new scanPage();
                        break;
                        case R.id.profile:
                            fragmentToShow= new ownProfile();
                        break;

                    default:
                        return false;


                }
                fragmentTransaction.replace(R.id.frame_layout, fragmentToShow);
                fragmentTransaction.commit();
                return true;
            }
        });

    }
}