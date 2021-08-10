package com.example.traveljournal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.traveljournal.R;

public class NewTripActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);

        final EditText nameInput = findViewById(R.id.updateName);
        final EditText destinationInput = findViewById(R.id.updateDestination);
        final RatingBar ratingInput = findViewById(R.id.updateRating);
        final TextView priceInput = findViewById(R.id.updatePrice);

        final Button button = findViewById(R.id.button_update);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                replyIntent.putExtra("name", nameInput.getText().toString());
                replyIntent.putExtra("destination", destinationInput.getText().toString());
                replyIntent.putExtra("rating", String.valueOf(ratingInput.getRating()));
                replyIntent.putExtra("price", priceInput.getText().toString());
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}
