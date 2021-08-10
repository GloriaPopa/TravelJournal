package com.example.traveljournal.store_data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TripRepository {

    private final TripDao tripDao;

    private final LiveData<List<Trip>> allTrips;

    TripRepository(Application application) {
        TripRoomDatabase db = TripRoomDatabase.getDatabase(application);
        tripDao = db.tripDao();
        allTrips = tripDao.getAllTrips();
    }

    LiveData<List<Trip>> getAllTrips() {
        return allTrips;
    }

    void insert(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            tripDao.insert(trip);
        });
    }
}
