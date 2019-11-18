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

        InputStream input = new FileInputStream("C:\\Users\\Serhii\\IdeaProjects\\test\\src\\config\\config.properties");
        prop.load(input);
        System.out.println(prop.getProperty("browser"));
        FirstSeleniumTest.browser = prop.getProperty("browser");
        System.out.println(FirstSeleniumTest.browser);
    }

    public static void writePropertiesFile() throws IOException {
        OutputStream output = new FileOutputStream("C:\\Users\\Serhii\\IdeaProjects\\test\\src\\config\\config.properties");
        prop.setProperty("browser", "Chrome");
        prop.store(output, null);
    }

}
