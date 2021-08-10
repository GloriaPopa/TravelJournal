package com.example.traveljournal.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;

public class TripViewHolder extends RecyclerView.ViewHolder {

    private final ImageView imageViewPicture;

    private final TextView textViewName;

    private final TextView textViewDestination;

    private final TextView textViewPrice;

    private final TextView textViewRating;

    private final RatingBar ratingBar;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPicture = itemView.findViewById(R.id.imageViewPicture);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewDestination = itemView.findViewById(R.id.textViewDestination);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        textViewRating = itemView.findViewById(R.id.textViewRating);
        ratingBar = itemView.findViewById(R.id.ratingBar);
    }

    public ImageView getImageViewPicture() {
        return imageViewPicture;
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public TextView getTextViewDestination() {
        return textViewDestination;
    }

    public TextView getTextViewPrice() {
        return textViewPrice;
    }

    public TextView getTextViewRating() {
        return textViewRating;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }
}
