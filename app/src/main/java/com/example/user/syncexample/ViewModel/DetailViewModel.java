package com.example.user.syncexample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.user.syncexample.Entituy.Local;
import com.example.user.syncexample.Repository;

import java.util.ArrayList;
import java.util.List;

public class DetailViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Local>> details;
    public DetailViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        details = repository.getDetails();
    }

    LiveData<List<Local>> getAllDetails()
    {
        return details;
    }

    public void insert(Local local)
    {
        repository.insert(local);
    }
}
