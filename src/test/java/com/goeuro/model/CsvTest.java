package com.goeuro.model;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CsvTest {

  @Test
  public void shouldCreateCsvFileWithGivenContents() throws Exception {
    deleteIfExists("locations.csv");

    CsvWritable[] list = new CsvWritable[]{ new CsvWritable() {
      @Override
      public String toCsv() {
        return "1,earth";
      }
    }, new CsvWritable() {
      @Override
      public String toCsv() {
        return "2,mars";
      }
    }};
    Csv csv = new Csv("id,value", list);
    csv.download("locations.csv");

    FileReader fileReader = new FileReader("locations.csv");
    BufferedReader inputStreamReader = new BufferedReader (fileReader);
    String header = inputStreamReader.readLine();

    assertThat(header, is("id,value"));
    String row1 = inputStreamReader.readLine();
    String row2 = inputStreamReader.readLine();
    assertThat(row1, is("1,earth"));
    assertThat(row2, is("2,mars"));

    deleteIfExists("locations.csv");
  }

  private void deleteIfExists(String pathname) {
    File locationsFile = new File(pathname);
    if(locationsFile.exists()) locationsFile.delete();
  }
}