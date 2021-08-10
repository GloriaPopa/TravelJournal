package com.example.traveljournal.store_data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private final TripRepository repository;

    private final LiveData<List<Trip>> allTrips;

    public TripViewModel(Application application) {
        super(application);
        repository = new TripRepository(application);
        allTrips = repository.getAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips() { return allTrips; }

    public void insert(Trip trip) { repository.insert(trip); }

}