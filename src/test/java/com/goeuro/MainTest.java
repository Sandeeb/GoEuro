package com.goeuro;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainTest {

  @Test
  public void testMain() throws Exception {
    deleteIfExists("locations.csv");

    String[] args = new String[1];
    args[0] = "Potsdam";

    Main.main(args);

    FileReader fileReader = new FileReader("locations.csv");
    BufferedReader inputStreamReader = new BufferedReader (fileReader);
    String header = inputStreamReader.readLine();

    assertThat(header, is("_id,name,type,latitude,longitude"));
    String row1 = inputStreamReader.readLine();
    String row2 = inputStreamReader.readLine();
    assertThat(row1, is("377078,Potsdam,52.39886,13.06566"));
    assertThat(row2, is("410978,Potsdam,44.66978,-74.98131"));

    deleteIfExists("locations.csv");
  }

  private void deleteIfExists(String pathname) {
    File locationsFile = new File(pathname);
    if(locationsFile.exists()) locationsFile.delete();
  }
}