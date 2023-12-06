package com.example.finalassign;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private TextView cityNameTextView;
    private TextView temperatureTextView;
    private TextView weatherDescriptionTextView;
    private ImageView weatherIconImageView;

    private OpenWeatherMapService openWeatherMapService;
    private String apiKey = "9c15fc501759598a70d6d5e1547778dd";
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cityNameTextView = view.findViewById(R.id.city_name_text_view);
        temperatureTextView = view.findViewById(R.id.temperature_text_view);
        weatherDescriptionTextView = view.findViewById(R.id.weather_description_text_view);
        weatherIconImageView = view.findViewById(R.id.weather_icon_image_view);

        openWeatherMapService = ApiClient.getInstance().create(OpenWeatherMapService.class);

        loadWeatherData("Seoul");

        return view;
    }

    private void loadWeatherData(String location) {
        openWeatherMapService.getCurrentWeatherData(location, apiKey).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    WeatherData weatherData = response.body();
                    updateUI(weatherData);
                } else {
                    showErrorToast();
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                showErrorToast();
            }
        });
    }

    private void updateUI(WeatherData weatherData) {
        cityNameTextView.setText(weatherData.getCityName());
        temperatureTextView.setText(weatherData.getTemperature() + "°C");
        weatherDescriptionTextView.setText(weatherData.getWeatherDescription());
    }



    private void showErrorToast() {
        Toast.makeText(requireContext(), "Failed to load weather data", Toast.LENGTH_SHORT).show();
    }
}