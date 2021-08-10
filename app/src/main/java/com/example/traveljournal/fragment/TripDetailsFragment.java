package com.example.traveljournal.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveljournal.R;
import com.example.traveljournal.retrofit.Example;
import com.example.traveljournal.retrofit.Main;
import com.example.traveljournal.retrofit.WeatherApi;
import com.example.traveljournal.utils.TripAbout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TripDetailsFragment extends Fragment {

    TextView tv;

    String apikey = "fcd2c236893559071f53147e2c72132f";

    private static final String M_NAME = "mName";

    private static final String M_DESTINATION = "mDestination";

    private static final String M_PRICE = "mPrice";

    private static final String M_RATING = "mRating";

    private String mName;

    private String mDestination;

    private String mPrice;

    private String mRating;

    public TripDetailsFragment() {
        // Required empty public constructor
    }

    public static TripDetailsFragment newInstance(String mName,
                                                  String mDestination,
                                                  String mPrice,
                                                  String mRating
    ) {
        TripDetailsFragment fragment = new TripDetailsFragment();
        Bundle args = new Bundle();
        args.putString(M_NAME, mName);
        args.putString(M_DESTINATION, mDestination);
        args.putString(M_PRICE, mPrice);
        args.putString(M_RATING, mRating);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(M_NAME);
            mDestination = getArguments().getString(M_DESTINATION);
            mPrice = getArguments().getString(M_PRICE);
            mRating = getArguments().getString(M_RATING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_trip_details, container, false);

        setTripDetails(view);

        tv = view.findViewById(R.id.tv);
        Button button = view.findViewById(R.id.getWeather);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeather(view);
            }
        });

        return view;
    }

    private void setTripDetails(View view) {
        TextView tripName = view.findViewById(R.id.tripName);
        tripName.setText(mName);

        TextView destination = view.findViewById(R.id.destinationValue);
        destination.setText(mDestination);

        TextView price = view.findViewById(R.id.priceValue);
        price.setText(mPrice);

        TextView rating = view.findViewById(R.id.rating);
        rating.setText(mRating);

        ImageView image = view.findViewById(R.id.tripPicture);
        image.setImageResource(getImageResId(mDestination));

        TextView about = view.findViewById(R.id.tripAbout);
        about.setText(TripAbout.getTripAbout(mDestination));
    }


    public void getWeather(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi myApi = retrofit.create(WeatherApi.class);
        Call<Example> exampleCall = myApi.getWeather(mDestination.trim(), apikey);
        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call,
                                   @NonNull Response<Example> response
            ) {
                if (response.code() == 404) {
                    Toast
                            .makeText(getContext(), "Please Enter a valid City", Toast.LENGTH_LONG)
                            .show();
                } else if (!(response.isSuccessful())) {
                    Toast.makeText(getContext(), response.code() + " ", Toast.LENGTH_LONG).show();
                    return;
                }
                Example myData = response.body();
                Main main = Objects.requireNonNull(myData).getMain();
                Double temp = main.getTemp();
                Integer temperature = (int) (temp - 273.15);
                tv.setText(String.format("%s\u00B0C", temperature));
            }

            @Override
            public void onFailure(@NonNull Call<Example> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private int getImageResId(String name) {
        return this.getResources().getIdentifier(
                name.toLowerCase(),
                "drawable",
                getActivity().getPackageName()
        );
    }
}