package com.example.newproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      GradientDrawable gradientInsta = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                new int[] {
                        Color.parseColor("#4fcf70"),
                        Color.parseColor("#fad648"),
                        Color.parseColor("#a767e5"),
                        Color.parseColor("#12bcfe"),
                        Color.parseColor("#44ce7b"),
                        ContextCompat.getColor(MainActivity.this, R.color.gold)
                });
        findViewById(R.id.insta).setBackground(gradientInsta);
*/
        Button btn;
        btn = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, second_activity.class));    }
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