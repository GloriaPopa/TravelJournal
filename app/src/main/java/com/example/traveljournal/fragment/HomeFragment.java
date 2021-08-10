package com.example.traveljournal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;
import com.example.traveljournal.activity.NewTripActivity;
import com.example.traveljournal.activity.UpdateTripActivity;
import com.example.traveljournal.adapter.TripAdapter;
import com.example.traveljournal.store_data.Trip;
import com.example.traveljournal.store_data.TripViewModel;
import com.example.traveljournal.utils.SpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment implements TripAdapter.ItemClickListener {

    public static final int NEW_TRIP_ACTIVITY_REQUEST_CODE = 1;

    public static final int UPDATE_TRIP_ACTIVITY_REQUEST_CODE = 2;

    private List<Trip> trips;

    private TripAdapter tripAdapter;

    private TripViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initRecyclerView(view);

        viewModel = new ViewModelProvider(this).get(TripViewModel.class);
        viewModel.getAllTrips().observe(getViewLifecycleOwner(), new Observer<List<Trip>>() {
            @Override
            public void onChanged(final List<Trip> trips) {
                tripAdapter.setTrips(trips);
            }
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewTripActivity.class);
                startActivityForResult(intent, NEW_TRIP_ACTIVITY_REQUEST_CODE);
            }
        });

        return view;
    }

    @Override
    public void onItemClick(Trip trip) {
        Fragment fragment = TripDetailsFragment.newInstance(
                trip.getName(),
                trip.getDestination(),
                trip.getPrice(),
                trip.getRating()
        );
        FragmentTransaction transaction =
                getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, "trip_details_fragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onLongItemClick(Trip trip) {
        Intent intent = new Intent(getActivity(), UpdateTripActivity.class);
        startActivityForResult(intent, UPDATE_TRIP_ACTIVITY_REQUEST_CODE);
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTrips);
        tripAdapter = new TripAdapter(trips, this, getContext());
        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(48);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setAdapter(tripAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == NEW_TRIP_ACTIVITY_REQUEST_CODE ||
             requestCode == UPDATE_TRIP_ACTIVITY_REQUEST_CODE)
            && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String destination = data.getStringExtra("destination");
            String rating = data.getStringExtra("rating");
            String price = data.getStringExtra("price");

            Trip trip = new Trip(name, destination, price, rating);
            viewModel.insert(trip);
            return;
        }

        Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_LONG).show();
    }
}