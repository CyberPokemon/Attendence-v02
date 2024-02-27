package com.example.attendenceappv02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class enterSignupDetails extends AppCompatActivity {

    TextInputEditText CRI, Name, type, joinYear, stream, section;
    String CRI1, Name1, type1, joinYear1, stream1, section1, email1;
    Button submit2;
    DatabaseReference databaseReference;
    FirebaseDatabase db;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_signup_details);

        CRI = findViewById(R.id.collegeRegistration);
        Name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        joinYear = findViewById(R.id.joinyear);
        stream = findViewById(R.id.stream);
        section = findViewById(R.id.section);

        progressBar = findViewById(R.id.progressBar);
        submit2 = findViewById(R.id.btn_submit2);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                CRI1 = String.valueOf(CRI.getText());
                Name1 = String.valueOf(Name.getText());
                type1 = String.valueOf(type.getText());
                joinYear1 = String.valueOf(joinYear.getText());
                stream1 = String.valueOf(stream.getText());
                section1 = String.valueOf(section.getText());
                email1 = getIntent().getStringExtra("email");


                if (CRI1.isEmpty() == false && Name1.isEmpty() == false && type1.isEmpty() == false && joinYear1.isEmpty() == false && stream1.isEmpty() == false && section1.isEmpty() == false) {
                    System.out.println("PASS1");
                    User user = new User(CRI1, Name1, type1, joinYear1, stream1, section1, email1);
                    System.out.println("PASS2");

                    db = FirebaseDatabase.getInstance();
                    databaseReference = db.getReference("Users");
                    System.out.println("PASS3");
                    databaseReference.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            System.out.println("PASS4");
                            CRI.setText("");
                            Name.setText("");
                            type.setText("");
                            joinYear.setText("");
                            stream.setText("");
                            section.setText("");
                            progressBar.setVisibility(View.GONE);
                            System.out.println("PASS5");
                        }
                    });


                } else {
                    Toast.makeText(enterSignupDetails.this, "Fill All the details", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

//                User user = new User(CRI1,Name1,type1,joinYear1,stream1,section1,email1);
//
//                databaseReference.push().setValue(user)
//                        .addOnSuccessListener(unused -> {
//                            Toast.makeText(enterSignupDetails.this, "User data saved successfully!", Toast.LENGTH_SHORT).show();
//                            // Clear input fields after successful save
//                            CRI.setText("");
//                            Name.setText("");
//
//                        })
//                        .addOnFailureListener(error -> {
//                            Toast.makeText(enterSignupDetails.this, "Error saving user data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                        });

            }
        });


    }
}