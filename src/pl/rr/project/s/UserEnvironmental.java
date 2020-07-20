package pl.rr.project.s;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class UserEnvironmental {
    public static String USERNAME;
    public static String GENDER;
    public static Image ADMIN_IMAGE = new Image("/images/admin.png");
    public static List<String> userList = new ArrayList<>();

    //register-login
    public static Boolean REMEMBER_PASSWORD = Settings.RememberPassword;
    public static Boolean REGISTRATION_COMPLETE = false;

    //add one static admin user
    static {
        userList.add("admin");
    }
}
