package com.example.anime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.annotations.NotNull;

public class VerifyActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String email;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        mAuth = FirebaseAuth.getInstance();
        email =getIntent().getStringExtra("EMAIL");
        password = getIntent().getStringExtra("PASSWORD");

    }




    private void singIn() {

        LoadingDialog loadingDialog = new LoadingDialog(VerifyActivity.this);
        loadingDialog.startLoadingDialog();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        Toast.makeText(VerifyActivity.this,"   Successful LogIn  ",Toast.LENGTH_LONG ).show();

                        Intent intent = new Intent(VerifyActivity.this,Home_activity.class);

                        startActivity(intent);



                    }else {
                        user.sendEmailVerification();
                        Toast.makeText(VerifyActivity.this,"   Verify Your Email   ",Toast.LENGTH_LONG ).show();

                    }

                }else {

                    Toast.makeText(VerifyActivity.this,"   Connection Issue   ",Toast.LENGTH_LONG ).show();
                }



            }
        });
;


    }
    private void resend() {

        LoadingDialog loadingDialog = new LoadingDialog(VerifyActivity.this);
        loadingDialog.startLoadingDialog();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(!user.isEmailVerified()){

                        user.sendEmailVerification();


                    }

                }else {

                    Toast.makeText(VerifyActivity.this,"   Connection Issue   ",Toast.LENGTH_LONG ).show();
                }



            }
        });



    }


    public void onOpenHeme(View view) {
        singIn();
    }

    public void onResend(View view) {
        resend();
    }
}