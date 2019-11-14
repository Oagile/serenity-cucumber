package utilities;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.Properties;

import static utilities.DataItem.USER_PASSWORD;

public class TestDataProperty {
    private static Properties testData;
    static
    {
        /*
            if there's a need for crossbrowser testing this can be enhanced
         */

        String DataFile = System.getProperty("testDataFile", "chrome.test.properties");

        testData = new Properties();
        try
        {
            testData.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(DataFile));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getDataItem(String s) {
        return testData.getProperty(s);
    }


    public static String getPassword() { {
        byte[] decodedBytes = Base64.decodeBase64(USER_PASSWORD);
        return new String(decodedBytes);
    }

    }
}
