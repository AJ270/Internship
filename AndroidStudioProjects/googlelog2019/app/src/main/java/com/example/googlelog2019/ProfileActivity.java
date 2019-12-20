package com.example.googlelog2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    String email,username;

    TextView showemail,showusername;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        email=getIntent().getStringExtra("email");
        username=getIntent().getStringExtra("username");

        showemail=(TextView)findViewById(R.id.emaildisplay);
        showusername=(TextView)findViewById(R.id.usernamedisplay);

        mAuth=FirebaseAuth.getInstance();

        showemail.setText(email);
        showusername.setText(username);
    }

    public void onStart() {

        super.onStart();

        FirebaseUser user=mAuth.getCurrentUser();

        if(user==null)
        {
            Intent gotoMainActivity=new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(gotoMainActivity);
        }




    }
}
