package com.example.traveljournal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;
import com.example.traveljournal.store_data.Trip;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private List<Trip> trips;

    private ItemClickListener clickListener;

    private Context context;

    public TripAdapter(List<Trip> trips, ItemClickListener clickListener, Context context) {
        this.trips = trips;
        this.clickListener = clickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trip_item,
                parent,
                false
        );
        return new TripViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip currentTrip = trips.get(position);

        holder.getImageViewPicture().setImageResource(getImageResId(currentTrip.getDestination()));
        holder.getTextViewName().setText(currentTrip.getName());
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        holder.getTextViewPrice().setText(currentTrip.getPrice());
        holder.getTextViewRating().setText(currentTrip.getRating());
        holder.getRatingBar().setRating(Float.parseFloat(currentTrip.getRating()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(trips.get(position));
            }

        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickListener.onLongItemClick(trips.get(position));
                return true;
            }
        });
    }

    private int getImageResId(String name) {
        return context.getResources().getIdentifier(
                name.toLowerCase(),
                "drawable",
                context.getPackageName()
        );
    }

    @Override
    public int getItemCount() {
        if (trips == null) {
            return 0;
        }
        return trips.size();
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
        notifyDataSetChanged();
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public interface ItemClickListener {

        public void onItemClick(Trip trip);

        public void onLongItemClick(Trip trip);
    }
}
