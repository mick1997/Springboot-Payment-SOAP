package com.snva.soap.payments.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class Config extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }

    @Bean(name = "userDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UserDetailsPort");
        wsdl11Definition.setLocationUri("/service/user-details");
        wsdl11Definition.setTargetNamespace("http://www.snva.com/xml/user");
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

//    @Bean(name = "bootcampWsdl")
//    public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema schema2) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("BootcampPort");
//        wsdl11Definition.setLocationUri("/service/bootcamp");
//        wsdl11Definition.setTargetNamespace("http://snva.com/ex/soap/xml/bootcamp");
//        wsdl11Definition.setSchema(schema2);
//        return wsdl11Definition;
//    }

    @Bean
    public XsdSchema getUsersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("user.xsd"));
    }

//    @Bean
//    public XsdSchema getBotcampSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("bootcamp.xsd"));
//    }
}
