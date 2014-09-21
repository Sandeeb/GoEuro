package com.goeuro;

import com.goeuro.model.Csv;
import com.goeuro.model.Location;

import java.io.IOException;

public class Main {

  public static final String ERROR_MESSAGE = "Could not download csv for search string %s";
  public static final String CSV_DOWNLOADED_MESSAGE = "Csv downloaded at %s";
  public static final String LOCATIONS_CSV_FILE_NAME = "locations.csv";

  public static void main(String[] args) throws IOException {
    String searchString = args[0];
    LocationService locationService = new LocationService();
    Location[] locations = locationService.search(searchString);
    if(locations.length == 0){
      System.out.println(String.format(ERROR_MESSAGE, searchString));
      return;
    }
    Csv csv = new Csv(Location.csvHeader(), locations);
    csv.download(LOCATIONS_CSV_FILE_NAME);
    System.out.println(String.format(CSV_DOWNLOADED_MESSAGE, LOCATIONS_CSV_FILE_NAME));
  }

}
