package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final Properties properties = System.getProperties();

    static {
        try {
            properties.load(new FileInputStream(new File(System.getProperty("user.dir")
                + "/src/test/resources/constants.properties")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getProperty(Props prop) {
        return properties.getProperty(prop.name());
    }

    public enum Props {
        BASE_URL,
        API_KEY,
        CITY,
        WRONG_CITY,
        ERROR_TYPE_REQUEST_FAILED,
        REQUEST_FAILED_INFO,
        WRONG_API_KEY,
        HTTPS_URL,
        WRONG_URL_INFO,
        ERROR_TYPE_WRONG_URL,
        WRONG_API_KEY_INFO,
        ERROR_TYPE_WRONG_API_KEY,
        INVALID_API_FUNCTION_INFO,
        ERROR_TYPE_INVALID_API_FUNCTION,
        INVALID_URL
    }
}
