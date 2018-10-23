package com.orange.onapbss;

import com.orange.onapbss.services.AddressValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

  @Autowired
  private AddressValidationService addressValidationService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void initDBAddress(){
    addressValidationService.reset();
  }

  @Bean
  public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
    return new OpenEntityManagerInViewFilter();
  }


}
