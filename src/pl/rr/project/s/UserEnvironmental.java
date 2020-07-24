package pl.rr.project.s;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class UserEnvironmental {
    //login-menu-profile
    public static String USERNAME;
    public static String GENDER;
    public static Image ADMIN_IMAGE = new Image("/images/admin.png");
    public static Image WHITE_SOMETHING = new Image("/images/whitesomething.jpg");
    public static int IMAGE_CHOSEN;

    //initialized scenes
    public static boolean INIT_LOGIN = false;
    public static boolean INIT_MENU = false;

    //register-login
    public static Boolean REMEMBER_PASSWORD = Settings.RememberPassword;
    public static Boolean REGISTRATION_COMPLETE = false;

    //add one static admin user
    public static List<String> userList = new ArrayList<>();
    static {
        userList.add("admin");
    }

    //menu-profile
    //add one static  description
    public static String DESCRIPTION = "I am green";
}
