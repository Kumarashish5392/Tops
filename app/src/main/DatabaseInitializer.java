package com.example.ashishkumarpatel.tops;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by ashishkumarpatel on 26/02/18.
 */

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDataBase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDataBase db) {
        populateWithTestData(db);
    }

    private static UserData addUser(final AppDataBase db, UserData user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDataBase db) {
        UserData user = new UserData();
        user.setName("Ashish");
        user.setMobileNo("9718109998");
        user.setLatitude(25.46544356);
        user.setLatitude(78.4674767);
        user.setAddress("Delhi 110091");
        addUser(db, user);

        List<UserData> userList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;

        PopulateDbAsync(AppDataBase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
