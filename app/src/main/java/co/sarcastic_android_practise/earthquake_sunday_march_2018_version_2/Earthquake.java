package co.sarcastic_android_practise.earthquake_sunday_march_2018_version_2;


public class Earthquake {

    private String magnitude;
    private String time;
    private String url;
    private String place;

    Earthquake(String magnitude, String place, String time, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.url = url;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getUrl() {
        return url;
    }
}
