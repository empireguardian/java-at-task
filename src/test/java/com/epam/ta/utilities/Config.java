package com.epam.ta.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String CONFIG_FILE =
            "testdata/config.properties";

    private static final Properties PROPERTIES =
            new Properties();

    static {
        try (InputStream inputStream =
                     Config.class
                             .getClassLoader()
                             .getResourceAsStream(CONFIG_FILE)) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "Configuration file was not found: "
                                + CONFIG_FILE
                );
            }

            PROPERTIES.load(inputStream);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load configuration file: "
                            + CONFIG_FILE,
                    e
            );
        }
    }

    private Config() {
    }

    public static String get(String key) {
        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration property is missing: " + key
            );
        }

        return value;
    }

    public static int getInt(String key) {
        try {
            return Integer.parseInt(get(key));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Configuration property must be a number: " + key,
                    e
            );
        }
    }
}
