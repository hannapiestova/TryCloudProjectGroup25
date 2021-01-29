package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //this class will be responsible for logging properties file and
    //will provide access to values based on key names(key=value)

    //use this class to load custom properties file
    private static Properties configFile;
    //whenever we use class static block is going to be executed once
    static {
        try {
            //IO-->input output
            FileInputStream file = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("File was not loaded");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return configFile.getProperty(key);
    }
}

