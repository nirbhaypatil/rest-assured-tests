package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class has methods to read all properties
 * available in config.properties file.
 */
public class Config {

    public static String getBasePath(){
        String base = System.getProperty("user.dir");
        String filePath = base + "\\src\\main\\resources\\Config.properties";

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filePath);
        }catch(FileNotFoundException no){
            no.printStackTrace();
        }

        String value = null;
        Properties prop = new Properties();
        try {
            prop.load(fis);
            value = prop.getProperty("basepath");
            System.out.println(value);
        }catch (IOException io){
            io.printStackTrace();
        }
        return value;
    }

    public static String getUri(String env){
        String base = System.getProperty("user.dir");
        String filePath = base + "\\src\\main\\resources\\Config.properties";

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filePath);
        }catch(FileNotFoundException no){
            no.printStackTrace();
        }

        Properties prop = new Properties();
        String value = null;
        try{
            prop.load(fis);
            value = prop.getProperty(env+".uri");
            System.out.println(value);
        }catch(IOException io){
            io.printStackTrace();
        }
        return value;
    }

}
