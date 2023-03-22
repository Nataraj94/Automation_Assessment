package utills;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public Properties initializeProperties(){

        Properties properties = new Properties();
        String path = System.getProperty("user.dir");

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + "//src//main//resources//configurations//Config.properties"));
            properties.load(fileInputStream);
        }catch (Throwable e){
            e.printStackTrace();
        }


        return properties;
    }
}
