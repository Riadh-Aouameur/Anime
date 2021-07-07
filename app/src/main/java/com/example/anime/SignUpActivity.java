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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class SignUpActivity extends AppCompatActivity {

    EditText username_ed;
    EditText email_ed;
    EditText password_ed;
    EditText phone_ed;
    DatabaseReference database;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        username_ed = findViewById(R.id.editText1);
        email_ed = findViewById(R.id.editText2);
        phone_ed = findViewById(R.id.editText3);
        password_ed = findViewById(R.id.editText4);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public void onSignIn(View view) {
        startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
    }


    private void SignUp() {

        final String email = email_ed.getText().toString().trim();
        final String password = password_ed.getText().toString().trim();
        final String phone = phone_ed.getText().toString().trim();
        final String username = username_ed.getText().toString().trim();

        if (username.isEmpty()) {
            username_ed.setError("Username is required");
            username_ed.requestFocus();
            return;

        }
        if (email.isEmpty()) {
            email_ed.setError("Email is required");
            email_ed.requestFocus();
            return;

        }
        if (phone.isEmpty()) {
            phone_ed.setError("Phone is required");
            phone_ed.requestFocus();
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

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);


        LoadingDialog loadingDialog = new LoadingDialog(SignUpActivity.this);
        loadingDialog.startLoadingDialog();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            database.push().setValue(user);


                            Toast.makeText(SignUpActivity.this, "   Successful   ", Toast.LENGTH_LONG).show();
                            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                            firebaseUser.sendEmailVerification();

                            Intent intent = new Intent(SignUpActivity.this,VerifyActivity.class);
                            intent.putExtra("EMAIL",email);
                            intent.putExtra("PASSWORD",password);
                            startActivity(intent);



                        } else {
                            Toast.makeText(SignUpActivity.this, "   Connection Issue   ", Toast.LENGTH_LONG).show();

                        }
                        loadingDialog.dismissDialog();
                    }
                });

    }

    public void onRegister(View view) {
        SignUp();
    }
}