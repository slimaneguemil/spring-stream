package com.example.demo;

public class Toll {


    public String stationId;
    public String customerId;
    public String timestamp;
    public Toll(byte[] payload){}

    public Toll(String StationId, String CustomerId, String Timestamp) {
        this.stationId = StationId;
        this.customerId = CustomerId;
        this.timestamp = Timestamp;
    }

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

    @Override
    public String toString(){
        return ("staionid="+ this.stationId);
    }

}
