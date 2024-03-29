package com.example.newproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class second_activity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://history-quiz-5eb17-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_second);

        Button btn;
        btn = findViewById(R.id.go_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(second_activity.this, MainActivity.class));
            }
        });

        TextView textView = (TextView) findViewById(R.id.insta);
//        TextView textViewb = (TextView) findViewById(R.id.instab);
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

//        textViewb.getPaint().setShader(textShader2);
        textViewc.getPaint().setShader(textShader);
        textView.getPaint().setShader(textShader);

    final EditText email = findViewById(R.id.mail);
    final EditText fullname = findViewById(R.id.name);
    final EditText password = findViewById(R.id.password);
    final EditText repeatpass = findViewById(R.id.repeatpassword);
    final Button registerBtn = findViewById(R.id.auth);



        registerBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // get data
            final String fullnameTxt = fullname.getText().toString();
            final String emailTxt = email.getText().toString();
            final String passwordTxt = password.getText().toString();
            final String repeatpassTxt = repeatpass.getText().toString();
            String emailInput = email.getEditableText().toString().trim();


            //check if user fill all the fields before sending data to firebase
            if (fullnameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty()) {
                Toast.makeText(second_activity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }

            else if (emailInput.isEmpty()) {
                email.setError("Field can't be empty");
            }
//            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
//                email.setError("Please enter a valid email");
//            }else{
//                email.setError(null);
//            }


            // check if passwords are matching with each other
            if (!passwordTxt.equals(repeatpassTxt)) {
                Toast.makeText(second_activity.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
            } else {

                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {



                        // check if mail is not registered before
                        if (snapshot.hasChild(emailTxt)) {
                            Toast.makeText(second_activity.this, "Username is already registered", Toast.LENGTH_SHORT).show();
                        } else {
                            // sending data to firebase
                            // we are using email as unique identity of every user
                            databaseReference.child("users").child(emailTxt).child("fullname").setValue(fullnameTxt);
                            databaseReference.child("users").child(emailTxt).child("email").setValue(emailTxt);
                            databaseReference.child("users").child(emailTxt).child("password").setValue(passwordTxt);

                            Toast.makeText(second_activity.this, "User registered succesfully", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }
    });


}
}