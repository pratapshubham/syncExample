package com.example.user.syncexample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.user.syncexample.Dao.DaoDB;
import com.example.user.syncexample.Entituy.Local;
import com.example.user.syncexample.RoomDB.LocalDatabase;

import java.util.List;

import static com.example.user.syncexample.RoomDB.LocalDatabase.INSTANCE;

public class Repository {

    private DaoDB daoDB;

    private LiveData<List<Local>> arrayListLiveData;

    public Repository(Application application)
    {
        LocalDatabase db  = LocalDatabase.getDatabase(application);
        daoDB = db.daoDB();
       // arrayListLiveData = daoDB.getallmail();
    }

    public LiveData<List<Local>> getDetails()
    {
        return arrayListLiveData;
    }

    public void insert (Local local) {
        new insertAsyncTask(daoDB).execute(local);
    }

    private static class insertAsyncTask extends AsyncTask<Local, Void, Void>
    {

        private DaoDB AsyncTaskDao;

        insertAsyncTask(DaoDB dao) {
            AsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Local... locals) {

            AsyncTaskDao.insert(locals[0]);
            return null;
        }
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final DaoDB mDao;

        PopulateDbAsync(LocalDatabase db) {
            mDao = db.daoDB();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
           /* mDao.getallmail();
            Local local = new Local();
            mDao.insert(local);*/
            return null;
        }
    }
}

