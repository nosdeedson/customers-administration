//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.10.01 às 02:24:00 PM BRT 
//


package br.com.ejs;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.ejs package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.ejs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCustomerDetailRequest }
     * 
     */
    public GetCustomerDetailRequest createGetCustomerDetailRequest() {
        return new GetCustomerDetailRequest();
    }

    /**
     * Create an instance of {@link GetCustomerDetailResponse }
     * 
     */
    public GetCustomerDetailResponse createGetCustomerDetailResponse() {
        return new GetCustomerDetailResponse();
    }

    /**
     * Create an instance of {@link CustomerDetail }
     * 
     */
    public CustomerDetail createCustomerDetail() {
        return new CustomerDetail();
    }

    /**
     * Create an instance of {@link GetAllCustomerDetailRequest }
     * 
     */
    public GetAllCustomerDetailRequest createGetAllCustomerDetailRequest() {
        return new GetAllCustomerDetailRequest();
    }

    /**
     * Create an instance of {@link GetAllCustomerDetailResponse }
     * 
     */
    public GetAllCustomerDetailResponse createGetAllCustomerDetailResponse() {
        return new GetAllCustomerDetailResponse();
    }

    /**
     * Create an instance of {@link DeleteCustomerDetailRequest }
     * 
     */
    public DeleteCustomerDetailRequest createDeleteCustomerDetailRequest() {
        return new DeleteCustomerDetailRequest();
    }

    /**
     * Create an instance of {@link SaveCustomerDetailRequest }
     * 
     */
    public SaveCustomerDetailRequest createSaveCustomerDetailRequest() {
        return new SaveCustomerDetailRequest();
    }

    /**
     * Create an instance of {@link SaveCustomerDetailResponse }
     * 
     */
    public SaveCustomerDetailResponse createSaveCustomerDetailResponse() {
        return new SaveCustomerDetailResponse();
    }

    /**
     * Create an instance of {@link DeleteCustomerDetailResponse }
     * 
     */
    public DeleteCustomerDetailResponse createDeleteCustomerDetailResponse() {
        return new DeleteCustomerDetailResponse();
    }

}
