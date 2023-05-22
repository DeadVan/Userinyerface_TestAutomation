package Utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SettingsReader {
    static ISettingsFile environment = new JsonSettingsFile("test_data.json");
    public static String readJson(String value){
        return environment.getValue("/"+value).toString();
    }
    public static int readJsonInt(String value){
        return (int) environment.getValue("/"+value);
    }
}
