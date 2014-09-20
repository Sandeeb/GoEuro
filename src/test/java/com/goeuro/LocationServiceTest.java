package com.goeuro;

import com.goeuro.model.Location;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocationServiceTest {

  @Test
  public void searchShouldGetResultForValidLocation() throws Exception {
    LocationService locationService = new LocationService();
    Location[] result = locationService.search("Potsdam");
    assertThat(result.length, is(2));

    assertThat(result[0].getId(), is("377078"));
    assertThat(result[0].getName(), is("Potsdam"));
    assertThat(result[0].getType(), is("location"));
    assertThat(result[0].getGeoPosition().getLatitude(), is("52.39886"));
    assertThat(result[0].getGeoPosition().getLongitude(), is("13.06566"));
  }

  @Test
  public void searchShouldReturnZeroRowsForNonExistentLocation() throws Exception {
    LocationService locationService = new LocationService();

    Location[] result = locationService.search("");
    assertThat(result.length, is(0));

    result = locationService.search("asjkhasfoiw");
    assertThat(result.length, is(0));
  }

  @Test
  public void searchShouldUrlEncodeTheSearchString() throws Exception {
    LocationService locationService = new LocationService();

    Location[] result = locationService.search("sa/an");
    assertThat(result.length, is(0));
  }
}