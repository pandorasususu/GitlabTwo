package com.ssafy.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleInfo {
    int id;
    String name;
    String address;
    double latitude;
    double longitude;
    String time;
}
