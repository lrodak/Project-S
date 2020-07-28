package pl.rr.project.s;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationSettings {
    public static String setSettings(String property) {
        ResourceBundle messages = ResourceBundle.getBundle("application");
        return messages.getString(property);
//        ResourceBundle messages = ResourceBundle.getBundle("application", Locale.FRANCE);
//        ResourceBundle messages = ResourceBundle.getBundle("application", new Locale("pl"));
//        System.out.println(messages.getString("xx"));
    }

    public static String getMessage(String key) {
        if (UserEnvironmental.locale == null) {
            UserEnvironmental.locale = Locale.ENGLISH;
        }

        ResourceBundle messages = ResourceBundle.getBundle("languages/messages", UserEnvironmental.locale);
        return messages.getString(key);
    }
}
