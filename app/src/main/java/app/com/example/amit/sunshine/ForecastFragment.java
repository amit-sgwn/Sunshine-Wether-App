package app.com.example.amit.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amit on 2/17/2017.
 */

public class ForecastFragment extends Fragment {

    ArrayAdapter<String> mArrayAdapter;

    @Override
    public void onStart() {
        super.onStart();
        updateWeather();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_refresh){
            updateWeather();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateWeather() {
        FetchWeatherTask weatherTask = new FetchWeatherTask();
        weatherTask.execute();
    //    String location = p
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        String[] forecastArray = {
                " Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63",
                " Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63",
                " Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63"," Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63",
                " Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63",
                " Today - Sunny - 88/63",
                " Tomorrow - Foggy - 80/63",
                " Wednesday - Astroids - 70/43",
                " Thrus - Clody - 48/65",
                " Friday - Hevy Rain -87/50",
                " Sat - Sunny -88/63",
                " Sun -Sunny -88/63"
        };
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));
        mArrayAdapter =new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekForecast);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forcast);
        listView.setAdapter(mArrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String forcast = mArrayAdapter.getItem(position);
               // Toast.makeText(getActivity(),forcast,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),DetailActivity.class).putExtra(Intent.EXTRA_TEXT,forcast);
                startActivity(intent);

            }
        });
        return  rootView;
    }

    public ForecastFragment(){

    }
}
