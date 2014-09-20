package com.goeuro;

import com.goeuro.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.springframework.http.HttpStatus.OK;

public class LocationService {

  public static final String LOCATION_API = "http://api.goeuro.com/api/v2/position/suggest/en/%s";
  private JsonRestTemplate restTemplate;

  public LocationService() {
    restTemplate = new JsonRestTemplate();
  }

  public Location[] search(String searchString) throws UnsupportedEncodingException {
    ResponseEntity<Location[]> response;
    try{
      String url = String.format(LOCATION_API, URLEncoder.encode(searchString, "utf-8"));
      response = restTemplate.getForEntity(url, Location[].class);
      if (response.getStatusCode().equals(OK)) {
        return response.getBody();
      }
    }catch (RestClientException ignored){
    }
    return new Location[0];
  }


}
