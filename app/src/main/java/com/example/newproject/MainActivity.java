package com.example.newproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://history-quiz-5eb17-default-rtdb.firebaseio.com/");
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        final EditText mail = findViewById(R.id.mail);
        final EditText password = findViewById(R.id.password);
        final Button auth = findViewById(R.id.auth);

        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mailTxt = mail.getText().toString();
                final String passwordTxt = password.getText().toString();
                System.out.println(mailTxt + " " + passwordTxt);

                Toast.makeText(MainActivity.this, "AFDGHADFH", Toast.LENGTH_SHORT).show();


                if(mailTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your mail or password", Toast.LENGTH_SHORT).show();
                }
                else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if mobile/phone is exist in firebase database
                            if(snapshot.hasChild(mailTxt)){

                                final String getPassword = snapshot.child(mailTxt).child("password").getValue(String.class);

                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(MainActivity.this, "Succesfully logged in", Toast.LENGTH_SHORT).show();

                                    // open mainactivity on success
                                    startActivity(new Intent(MainActivity.this, MainPage.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(String.valueOf(R.id.password), "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(String.valueOf(R.id.password), "Failed to read value.", error.toException());
            }
        });


        final Button btn;
        btn = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, second_activity.class));
            }
        });

        TextView textView = (TextView) findViewById(R.id.insta);
        TextView textViewb = (TextView) findViewById(R.id.instab);
        TextView textViewc = (TextView) findViewById(R.id.rgbline);
        //textView.setText("Log in".toUpperCase());

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("AAAAAAAAAAAAAAAAAAAAAAA");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#4fcf70"),
                        Color.parseColor("#fad648"),
                        Color.parseColor("#a767e5"),
                        Color.parseColor("#12bcfe"),
                        Color.parseColor("#44ce7b"),
                }, null, Shader.TileMode.CLAMP);

        TextPaint paint2 = textView.getPaint();
        float width2 = paint2.measureText("AAAAAAA");
        Shader textShader2 = new LinearGradient(0, 0, width2, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#4fcf70"),
                        Color.parseColor("#fad648"),
                        Color.parseColor("#a767e5"),
                        Color.parseColor("#12bcfe"),
                        Color.parseColor("#44ce7b"),
                }, null, Shader.TileMode.CLAMP);

        textViewb.getPaint().setShader(textShader2);
        textViewc.getPaint().setShader(textShader);
        textView.getPaint().setShader(textShader);


    }
}

// 115deg,#4fcf70,#fad648,#a767e5,#12bcfe,#44ce7b