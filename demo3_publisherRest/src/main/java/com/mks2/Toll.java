package com.mks2;

import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;

@Setter
@ToString
class Toll {
    public String stationId;
    public String customerId;
    public String timestamp;

    public Toll() {
    }

    public Toll(String StationId, String CustomerId, String Timestamp) {
        this.stationId = StationId;
        this.customerId = CustomerId;
        this.timestamp = Timestamp;
    }

    public String toString() {
        return new StringJoiner(", ", Toll.class.getSimpleName() + "[", "]")
                .add("stationId='" + this.stationId + "'")
                .add("customerID='" + this.customerId + "'")
                .add("timestam='" + this.timestamp + "'")
                .toString();
    }
}