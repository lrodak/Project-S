package pl.rr.project.s;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserEnvironmental {
    //login-menu-profile
    public static String USERNAME;
    public static String GENDER;
    public static Image SELECTED_IMAGE;
    public static Boolean FIRST_RANDOM_AVATAR = true;

    //initialized scenes to center on screen only on init
    public static boolean INIT_LOGIN = false;
    public static boolean INIT_MENU = false;

    //register-login
    public static String REMEMBER_PASSWORD = ApplicationSettings.setSettings("RememberPassword");
    public static Boolean REGISTRATION_COMPLETE = false;

    //add one static admin user
    public static List<String> userList = new ArrayList<>();

    static {
        userList.add("admin");
    }


    //menu-profile
    public static String DESCRIPTION = "I am green";

    //IMAGES
    public static Image ADMIN_IMAGE = new Image("/images/admin.png");
    public static Image DOGO_IMAGE = new Image("/images/avatarDogo.png");
    public static Image WHITE_SOMETHING = new Image("/images/whitesomething.jpg");
    public static Image DINOSAUR_IMAGE = new Image("/images/dinosaur.jpg");

    //temporary
    public static Image PANDA_IMAGE = new Image("/images/dinosaur.jpg");
//    public static Image PANDA_IMAGE = new Image("/images/panda-avatar.jpg");

    public static final Image[] IMAGE_LIST = {ADMIN_IMAGE, DOGO_IMAGE, WHITE_SOMETHING, DINOSAUR_IMAGE, PANDA_IMAGE};

    public static Locale locale;
}
