package com.mks;

public class Toll {
    public String stationId;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String customerId;
    public String timestamp;

    public Toll(String StationId, String CustomerId, String Timestamp) {
        this.stationId = StationId;
        this.customerId = CustomerId;
        this.timestamp = Timestamp;
    }
}