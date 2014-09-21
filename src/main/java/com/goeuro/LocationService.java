package com.goeuro;

import com.goeuro.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import static org.springframework.http.HttpStatus.OK;

public class LocationService {

  private static final String LOCATION_API = "http://api.goeuro.com/api/v2/position/suggest/en/{searchString}";
  private JsonRestTemplate restTemplate;

  public LocationService() {
    restTemplate = new JsonRestTemplate();
  }

  public Location[] search(String searchString) {

    try{
      ResponseEntity<Location[]> response = restTemplate.getForEntity(LOCATION_API, Location[].class, searchString);
      if (response.getStatusCode().equals(OK)) {
        return response.getBody();
      }
    }catch (RestClientException ignored){
    }
    return new Location[0];
  }


}
