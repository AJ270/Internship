package com.example.googlelog2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText email_t,password_t;
    Button signup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email_t=(EditText)findViewById(R.id.singup_email_editext);
        password_t=(EditText)findViewById(R.id.signup_password_editext);
        signup=(Button)findViewById(R.id.signup_button);

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_t.getText().toString();
                String password=password_t.getText().toString();

                if(email.isEmpty())
                {
                    email_t.setError("Please enter the email");
                    email_t.requestFocus();
                }
                else if(password.isEmpty())
                {
                    password_t.setError("Please enter the password");
                    password_t.requestFocus();
                }

                else if(!(email.isEmpty()&& password.isEmpty()))
                {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(SignupActivity.this,"Error in creating account",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(SignupActivity.this,"Account created",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });



    }
}
