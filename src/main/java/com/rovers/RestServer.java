package com.rovers;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rovers.resource.MarsRoversResourceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class RestServer {


    private static final Logger logger = LogManager.getLogger(RestServer.class);

    private JAXRSServerFactoryBean factoryBean;

    public RestServer initializeServer(final Config config) {
        logger.info("Initializing server");
        factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceProviders(
                Arrays.asList(
                        new SingletonResourceProvider(new MarsRoversResourceImpl())
                )
        );

        factoryBean.setProviders(
                Arrays.asList(
                        //new GetPerfectNumberListValidationFilter(),
                        //new CheckPerfectNumberValidationFilter(),
                        new JacksonJsonProvider()
                )
        );

        factoryBean.setAddress(config.getProperty("endpoint.address"));

        logger.info("Server initialization completed");

        return this;
    }

    public Server start() {
        Server server = factoryBean.create();
        return server;
    }

}