package com.example.user.syncexample.Entituy;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mydata")
public class Local {

    public Local(@NonNull String email, String name)
    {
        this.email = email;
        this.name = name;
    }

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "name")
    String name;

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
