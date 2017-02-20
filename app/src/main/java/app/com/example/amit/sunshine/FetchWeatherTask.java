package app.com.example.amit.sunshine;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Amit on 2/19/2017.
 */

public class FetchWeatherTask extends AsyncTask<String,Void,String[]> {

    private final  String LOG_TAG = FetchWeatherTask.class.getSimpleName();

    private String getReadableDateString(long time){
        Date date = new Date(time*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM D");
        return simpleDateFormat.format(date).toString();
    }

    @Override
    protected String[] doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader=null;

        String forecastJsonStr = null;
        String format ="json";
        String units="metric";
        int numDays=7;

        try{

            final String FORECAST_BASE_URL="http://api.openweathermap.org/data/2.5/forecast/daily?";

            final String QUERY_PARAM = "q";
            final String FORMAT_PARAM = "mode";
            final String UNITS_PARAM = "units";
            final String DAYS_PARAM = "cnt";

            Uri buildUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM,params[0])
                    .appendQueryParameter(FORMAT_PARAM,format)
                    .appendQueryParameter(UNITS_PARAM,units)
                    .appendQueryParameter(DAYS_PARAM,Integer.toString(numDays))
                    .build();
            URL url = new URL(buildUri.toString());

            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            if(inputStream==null){
                forecastJsonStr=null;
            }

            bufferedReader  = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\n");
            }
            if(stringBuffer.length()==0)
                return null;
            forecastJsonStr = stringBuffer.toString();
        }
        catch (IOException e){
            Log.e(LOG_TAG,"Error",e);
            return null;
        }
        finally {
            if(urlConnection!=null)
                urlConnection.disconnect();
            if(bufferedReader !=null){
                try{
                    bufferedReader.close();
                }catch (final IOException e){
                    Log.e(LOG_TAG,"Error closing stream",e);
                }
            }
        }
        return null;
    }
}
