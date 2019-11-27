package com.rovers;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import java.util.Arrays;

public class RestServer {

    private JAXRSServerFactoryBean factoryBean;

    public RestServer initializeServer(final Config config) {
        factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setAddress(config.getProperty("endpoint.address"));
        return this;
    }

    public Server start() {
        Server server = factoryBean.create();
        return server;
    }

}