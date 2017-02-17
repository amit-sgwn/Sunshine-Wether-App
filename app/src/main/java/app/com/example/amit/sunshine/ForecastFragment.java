package app.com.example.amit.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Amit on 2/17/2017.
 */

public class ForecastFragment extends Fragment {

    ArrayAdapter<String> mArrayAdapter;
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
        return  rootView;
    }

    public ForecastFragment(){

    }
}
