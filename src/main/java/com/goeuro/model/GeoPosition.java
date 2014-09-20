package com.goeuro.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class GeoPosition implements CsvWritable {

  @JsonProperty("latitude")
  private String latitude;

  @JsonProperty("longitude")
  private String longitude;

  public static String csvHeader() {
    return "latitude,longitude";
  }

  public String toCsv() {
    return latitude + "," + longitude;
  }
}
