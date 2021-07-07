package com.example.anime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.NotNull;

public class Forgot_password_activity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    EditText email_ed;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        mAuth = FirebaseAuth.getInstance();
        email_ed = findViewById(R.id.editText);
    }

    private void resetPassword() {

        final String email = email_ed.getText().toString().trim();


        if (email.isEmpty()) {
            email_ed.setError("Email is required");
            email_ed.requestFocus();
            return;

        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_ed.setError("please provide valid email_ed");
            email_ed.requestFocus();
            return;
        }

        LoadingDialog loadingDialog = new LoadingDialog(Forgot_password_activity.this);
        loadingDialog.startLoadingDialog();

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {


                if (task.isSuccessful()) {
                    Toast.makeText(Forgot_password_activity.this, "  Verify Your Email  ", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(Forgot_password_activity.this, "   Try Again !   ", Toast.LENGTH_LONG).show();

                }
                loadingDialog.dismissDialog();

            }
        });


    }

    public void onResetPassword(View view) {
        resetPassword();

    }

    public void onSignUp(View view) {
        startActivity(new Intent(Forgot_password_activity.this, SignUpActivity.class));
    }

    public void onSignIn(View view) {
        startActivity(new Intent(Forgot_password_activity.this, SignInActivity.class));
    }
}