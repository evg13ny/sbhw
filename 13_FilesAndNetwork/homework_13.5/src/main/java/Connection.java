public class Connection {
    private String station;
    private String line;

    public Connection(String station, String line) {
        this.station = station;
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public String getLine() {
        return line;
    }
}
