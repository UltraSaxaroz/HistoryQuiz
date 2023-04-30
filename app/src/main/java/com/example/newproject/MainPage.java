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

public class MainPage extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://history-quiz-5eb17-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        final Button btn = findViewById(R.id.profileBtn);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       startActivity(new Intent(MainPage.this, ProfilePage.class));
                                   }
                               })

/*
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
    */

;}
}