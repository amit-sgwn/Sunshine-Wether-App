package app.com.example.amit.sunshine;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Amit on 2/19/2017.
 */

public class FetchWeatherTask extends AsyncTask<Void,Void,Void> {

    private final  String LOG_TAG = FetchWeatherTask.class.getSimpleName();

    @Override
    protected Void doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader=null;

        String forecastJsonStr = null;

        try{
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");
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
