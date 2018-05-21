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

    public void setCity(String city) {
        this.city = city;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public String getCloudStatus() {
        return cloudStatus;
    }

    public void setCloudStatus(String cloudStatus) {
        this.cloudStatus = cloudStatus;
    }

    public String getRainStatus() {
        return rainStatus;
    }

    public void setRainStatus(String rainStatus) {
        this.rainStatus = rainStatus;
    }
}
