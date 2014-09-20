package com.goeuro;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class JsonRestTemplate extends RestTemplate {

  public JsonRestTemplate() {
    addJsonConverter();
  }

  private void addJsonConverter() {
    List<HttpMessageConverter<?>> mappingJacksonHttpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
    mappingJacksonHttpMessageConverters.add(new MappingJacksonHttpMessageConverter());
    setMessageConverters(mappingJacksonHttpMessageConverters);
  }
}
