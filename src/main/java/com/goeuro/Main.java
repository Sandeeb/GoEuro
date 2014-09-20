package com.goeuro;

import com.goeuro.model.Csv;
import com.goeuro.model.Location;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String searchString = args[0];
    LocationService locationService = new LocationService();
    Location[] locations = locationService.search(searchString);
    Csv csv = new Csv(Location.csvHeader(), locations);
    csv.download("locations.csv");
  }

}
