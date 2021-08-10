package com.example.traveljournal.store_data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trip_table")
public class Trip {

    @ColumnInfo(name = "name")
    private final String name;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "destination")
    private final String destination;

    @ColumnInfo(name = "price")
    private final String price;

    @ColumnInfo(name = "rating")
    private final String rating;

    public Trip(String name, @NonNull String destination, String price, String rating) {
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    @NonNull
    public String getDestination() {
        return destination;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

}
