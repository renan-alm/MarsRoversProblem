package com.rovers.resource;


import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Config ourInstance = new Config();
    private static Properties properties;

    public static Config getInstance() {
        synchronized (Config.class) {
            return ourInstance;
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    private Config() {
        properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            System.out.println("Loading config failed.   " + e);
        }
        System.out.println("Finished initializing config from config.properties");
    }
}