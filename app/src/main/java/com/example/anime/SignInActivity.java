package com.example.anime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.NotNull;

public class SignInActivity extends AppCompatActivity {
    EditText email_ed;
    EditText password_ed;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        email_ed = findViewById(R.id.editText1);
        password_ed = findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();


    }


    private void singIn() {


        final String email = email_ed.getText().toString().trim();
        final String password = password_ed.getText().toString().trim();


        if (email.isEmpty()) {
            email_ed.setError("Email is required");
            email_ed.requestFocus();
            return;

        }

        if (password.isEmpty()) {
            password_ed.setError("Password is required");
            password_ed.requestFocus();
            return;

        }
        if (password.length() < 6) {
            password_ed.setError("Password is required more then 6 characters");
            password_ed.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_ed.setError("please provide valid email_ed");
            email_ed.requestFocus();
            return;
        }


        LoadingDialog loadingDialog = new LoadingDialog(SignInActivity.this);
        loadingDialog.startLoadingDialog();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


                        Toast.makeText(SignInActivity.this, "   Successful LogIn  ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignInActivity.this, Home_activity.class);
                        startActivity(intent);




                } else {

                    Toast.makeText(SignInActivity.this, "   Connection Issue   ", Toast.LENGTH_LONG).show();
                }

                loadingDialog.dismissDialog();


            }
        });


    }


    public void onSignUp(View view) {

        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }

    public void onGetStarted(View view) {
        singIn();
    }


    public void onForgotPassword(View view) {
        startActivity(new Intent(SignInActivity.this, Forgot_password_activity.class));
    }
}