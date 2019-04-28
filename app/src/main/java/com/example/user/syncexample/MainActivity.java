package com.example.user.syncexample;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.syncexample.ViewModel.DetailViewModel;

public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;



    EditText username,password;
    Button btn_login;
    String usr_name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usr_name = username.getText().toString();
                pass = password.getText().toString();

                if (usr_name.isEmpty() || pass.isEmpty())
                {
                    username.setError("Enter Username");
                    password.setError("Enter Password");
                    username.requestFocus();
                    password.requestFocus();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this,SynActivity.class));
                    finish();
                }
            }
        });
    }

    private void initView() {
        username = findViewById(R.id.edt_text_username);
        password = findViewById(R.id.edt_text_password);
        btn_login = findViewById(R.id.btn_login);
    }
}
