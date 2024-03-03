package com.example.attendenceappv02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class teacherpage1 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherpage1);

        bottomNavigationView= findViewById(R.id.bottomNavView);
        frameLayout=findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId==R.id.navclass)
                {
                    loadFragment(new classTeacherpage(),false);
                }
                else if(itemId==R.id.navprofile)
                {
                    loadFragment(new classTeacherProfile(),false);
                }
//                else {
//                    //nav
////                    loadFragment(new classTeacherpage(),false);
//                }

                loadFragment(new classTeacherpage(),true);

                return true;
            }
        });


    }
    private void loadFragment(Fragment fragment, boolean isAppInitialised){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(isAppInitialised){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }
        else
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}