package mmn16.exercise2;

public class Forecast {
    private String city;
    private String day;
    private int degrees;
    private String cloudStatus;
    private String rainStatus;

    public Forecast(String city, String day, int degrees, String cloudStatus, String rainStatus) {
        this.city = city;
        this.day = day;
        this.degrees = degrees;
        this.cloudStatus = cloudStatus;
        this.rainStatus = rainStatus;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return day + " in " + city + " will be " + degrees + " degrees, " + cloudStatus + " and " + rainStatus;
    }
}
