package co.sarcastic_android_practise.earthquake_sunday_march_2018_version_2;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<String> {

    private static String LOCATION_SEPERATOR = "of";

    EarthquakeAdapter(Context context, ArrayList<String> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView = convertView;
        // LayoutInflater inflater = inflater.inflate( getContext() , R.layout.activity_eathquake_adapter , true);
        if (myView == null) {
            myView = LayoutInflater.from(getContext()).inflate(R.layout.activity_eathquake_adapter, parent, true);
        }

        //Here Error can occur ------->
        Earthquake currentEarthquake = null;

        // Find the TextView with view ID location
        TextView locationView = (TextView) myView.findViewById(R.id.address);
        TextView locationView2 = (TextView) myView.findViewById(R.id.address2);
        String OriginalLocation = currentEarthquake.getPlace();
        String[] parts = OriginalLocation.split(LOCATION_SEPERATOR);
        if (OriginalLocation.contains(LOCATION_SEPERATOR)) {
            // Display the location of the current earthquake in that TextView
            locationView2.setText(parts[0]);
            locationView.setText(" " + parts[1]);
        } else {
            // Display the location of the current earthquake in that TextView
            locationView.setText(parts[0]);
        }

        // Find the TextView with view ID magnitude
        TextView magnitudeView = myView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        Double Magnitude = Double.parseDouble(currentEarthquake.getMagnitude());
        magnitudeView.setText("" + Magnitude);

        // Find the TextView with view ID date
        TextView dateView = (TextView) myView.findViewById(R.id.timetext);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(currentEarthquake.getTime());
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // String UrlFormat = currentEarthquake.getUrl();

        // Find the TextView with view ID time
        TextView timeView = (TextView) myView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(currentEarthquake.getTime());
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        GradientDrawable MagnitudeDrawable = (GradientDrawable) magnitudeView.getBackground();
        int MagnitudeColor = getMagnitudeColor(Magnitude);
        MagnitudeDrawable.setColor(MagnitudeColor);

        return myView;
    }

    private int getMagnitudeColor(double MagnitudeColorId) {
        int MagnitudeColorId2 = (int) MagnitudeColorId;
        int MagnitudeColorId1;

        switch (MagnitudeColorId2) {
            case 1:
                MagnitudeColorId1 = R.color.magnitude1;
                break;
            case 2:
                MagnitudeColorId1 = R.color.magnitude2;
                break;
            case 3:
                MagnitudeColorId1 = R.color.magnitude3;
                break;
            case 4:
                MagnitudeColorId1 = R.color.magnitude4;
                break;
            case 5:
                MagnitudeColorId1 = R.color.magnitude5;
                break;
            case 6:
                MagnitudeColorId1 = R.color.magnitude6;
                break;
            case 7:
                MagnitudeColorId1 = R.color.magnitude7;
                break;
            case 8:
                MagnitudeColorId1 = R.color.magnitude8;
                break;
            case 9:
                MagnitudeColorId1 = R.color.magnitude9;
                break;
            case 10:
                MagnitudeColorId1 = R.color.magnitude10plus;
                break;
            default:
                MagnitudeColorId1 = R.color.magnitude1;
        }
        return MagnitudeColorId1;
    }

    public String formatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(date);
    }

    public String formatTime(String time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(time);
    }
}
