package rest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropHelper {

    public static Properties properties;


    //static block will be initialized before all
    static {

        properties = new Properties();
        if (properties.isEmpty()) {
            try {
                properties.load(new FileReader("src\\test\\resources\\app.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
