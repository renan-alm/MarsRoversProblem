package com.rovers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class MarsRoversMain {
    private static final Logger cLogger = LoggerFactory.getLogger(MarsRoversMain.class);
    /**
     * Has to be static because it starts threads, and hence needs to be stopped manually on crash.
     */

    static {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        System.setProperty("log4j.shutdownHookEnabled", "false");
    }

    public static void main(String[] args) {
        // NEW Requirements:
        // 5. Objects out of Status or History - Check
        // 6. Implement a REST API   --- Spring / Spring boot
        // 7. Can you use Stream?
        // 8. Set status again


        Config config = Config.getInstance();

        cLogger.info("*****************************************");
        cLogger.info("********** Application Started **********");
        cLogger.info("*****************************************");

        RestServer server = new RestServer();
        server.initializeServer(config).start();
        cLogger.info("Server ready on endpoint {}", config.getProperty("endpoint.address"));


    }
}
