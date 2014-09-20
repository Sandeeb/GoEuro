package com.goeuro.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Location implements CsvWritable {
  @JsonProperty("_id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private String type;

  @JsonProperty("geo_position")
  private GeoPosition geoPosition;

  public static String csvHeader() {
    return "_id,name,type," + GeoPosition.csvHeader();
  }

  public String toCsv() {
    return id + "," + name + "," + geoPosition.toCsv();
  }

}
