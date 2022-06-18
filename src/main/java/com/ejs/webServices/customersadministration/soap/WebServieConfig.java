package com.ejs.webServices.customersadministration.soap;

import java.util.List;
import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServieConfig extends WsConfigurerAdapter {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
		dispatcherServlet.setApplicationContext(context);
		dispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(dispatcherServlet, "/ws/*");
	}
	
	@Bean
	public XsdSchema customerSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/xsd/customer-information.xsd"));
	}
	
	@Bean(name = "customers")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CustomerPort");
		definition.setLocationUri("/ws");
		definition.setTargetNamespace("http://ejs.com.br");
		definition.setSchema(schema);
		return definition;
	}
	
	
//	security
//	@Bean
//	public XwsSecurityInterceptor securityInterceptor() {
//		XwsSecurityInterceptor interceptor = new XwsSecurityInterceptor();
//		interceptor.setCallbackHandler(callBackHandler());
//		interceptor.setPolicyConfiguration(new ClassPathResource("Security-Policy.xml"));
//		return interceptor;
//	}
	
	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
		securityInterceptor.setValidationActions("UsernameToken");
		securityInterceptor.setValidationCallbackHandler(callBackHandler());
		return securityInterceptor;
	}

	@Bean
	public SimplePasswordValidationCallbackHandler callBackHandler() {
		SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
		Properties users = new Properties();
		users.setProperty("ejs", "123");
		handler.setUsers(users);
		return handler;
	}
	
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}
	
}
