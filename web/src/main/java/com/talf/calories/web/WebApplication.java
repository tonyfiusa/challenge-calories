package com.talf.calories.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer implements ServletContextAware {
  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
    FacesServlet servlet = new FacesServlet();
    return
      new ServletRegistrationBean<>(servlet, "*.jsf");
  }

  @Override
  public void setServletContext(ServletContext servletContext) {
    servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
  }

}
