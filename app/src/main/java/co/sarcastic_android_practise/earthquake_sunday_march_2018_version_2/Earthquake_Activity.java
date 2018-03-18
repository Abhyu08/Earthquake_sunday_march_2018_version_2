package co.sarcastic_android_practise.earthquake_sunday_march_2018_version_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Earthquake_Activity extends AppCompatActivity {

    public final String LOG_TAG = Earthquake_Activity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_);

       ArrayList<Earthquake> myArrayList = QueryUtils.extractEarthquakes();

        ListView lv = (ListView) findViewById(R.id.listview1);

        EarthquakeAdapter myearthAdapter = new EarthquakeAdapter(this, myArrayList);


        lv.setAdapter(myearthAdapter);
    }
}
