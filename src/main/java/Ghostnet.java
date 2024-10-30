public class Ghostnet {
    private int id;
    private double latitude;
    private double longitude;
    private float estimatedSize;
    private String status;

    private ReportingPerson reportingPerson;
    private RetrievingPerson retrievingPerson;

    // Constructor
    public Ghostnet(double latitude, double longitude, float estimatedSize, String status) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedSize = estimatedSize;
        this.status = status;
    }

    // Getter / Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getEstimatedSize() {
        return estimatedSize;
    }
    public void setEstimatedSize(float estimatedSize) {
        this.estimatedSize = estimatedSize;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public ReportingPerson getReportingPerson() {
        return reportingPerson;
    }
    public void setReportingPerson(ReportingPerson reportingPerson) {
        this.reportingPerson = reportingPerson;
    }

    public RetrievingPerson getRetrievingPerson() {
        return retrievingPerson;
    }
    public void setRetrievingPerson(RetrievingPerson retrievingPerson) {
        this.retrievingPerson = retrievingPerson;
    }
}
