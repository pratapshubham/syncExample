package com.example.user.syncexample;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.syncexample.Entituy.Local;
import com.example.user.syncexample.RoomDB.LocalDatabase;
import com.example.user.syncexample.ViewModel.DetailViewModel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SynActivity extends AppCompatActivity {

    private DetailViewModel detailViewModel;
    LocalDatabase db;

    EditText name,email;
    String str_name,str_email;
    Button btn_Add,btn_update,btn_sync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syn);

        //detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        initView();

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_name = name.getText().toString();
                str_email = email.getText().toString();

                if (Validate())
                {
                    db = Room.databaseBuilder(getApplicationContext(),LocalDatabase.class,"local_db")
                            .allowMainThreadQueries()
                            .build();
                    db.daoDB().insert(new Local(str_email,str_name));
                    /*Local localdata = new Local();
                    detailViewModel.insert(localdata);*/
                }
            }
        });
    }

    private Boolean Validate() {

        if (str_email.isEmpty())
        {
            name.setError("Enter Name");
            return false;
        }else if (str_email.isEmpty())
        {
            email.setError("Enter Email");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(str_email).matches())
        {
            email.setError("Invalid Email");
            return false;
        }

        return true;
    }

    private void initView() {

        name = findViewById(R.id.edt_text_name);
        email = findViewById(R.id.edt_text_email);
        btn_Add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_sync = findViewById(R.id.btn_sync);
    }
}
