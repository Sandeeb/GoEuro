package com.goeuro.model;

import java.io.FileWriter;
import java.io.IOException;

public class Csv {
  private String header;
  private CsvWritable[] csvRows;

  public Csv(String header, CsvWritable[] result) {
    this.header = header;
    csvRows = result;
  }

  public void download(String path) throws IOException {
    FileWriter writer = new FileWriter(path);
    writer.append(header).append("\n");
    for (CsvWritable csvRow : csvRows) {
      writer.append(csvRow.toCsv()).append("\n");
    }
    writer.flush();
    writer.close();
  }
}
