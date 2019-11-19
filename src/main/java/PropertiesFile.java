package src.main.java;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        readPropertiesFile();
        writePropertiesFile();
        readPropertiesFile();
    }

    public static void readPropertiesFile() throws IOException {
        String projectLocation = System.getProperty("user.dir");
        InputStream input = new FileInputStream(projectLocation + "\\src\\config\\config.properties");
        prop.load(input);
        System.out.println(prop.getProperty("browser"));
        FirstSeleniumTest.browser = prop.getProperty("browser");
        System.out.println(FirstSeleniumTest.browser);
    }

    public static void writePropertiesFile() throws IOException {
        String projectLocation = System.getProperty("user.dir");
        OutputStream output = new FileOutputStream(projectLocation + "\\src\\config\\config.properties");
        prop.setProperty("browser", "Chrome");
        prop.store(output, null);
    }

}
