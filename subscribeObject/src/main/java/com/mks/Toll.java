package com.mks;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Toll{
    public String stationId;
    public int customeId;
    public String timestamp;

    public Toll(String _stationId, int _customerId, String _timestamp){
        this.stationId = _stationId;
        this.customeId = _customerId;
        this.timestamp = _timestamp;
    }
}

