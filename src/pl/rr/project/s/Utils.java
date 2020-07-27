package pl.rr.project.s;

import javafx.scene.image.ImageView;

import java.io.*;
import java.util.Random;


//universal methods for multi-purpose
public class Utils {

    public void setAvatar(ImageView avatar, double x, double y) {
        if (UserEnvironmental.FIRST_RANDOM_AVATAR) {
            Random rand = new Random();
            int random = rand.nextInt(3);

            switch (random){
                case 0:
                    UserEnvironmental.SELECTED_IMAGE =UserEnvironmental.ADMIN_IMAGE;
                    break;
                case 1:
                    UserEnvironmental.SELECTED_IMAGE =UserEnvironmental.WHITE_SOMETHING;
                    break;
                case 2:
                    UserEnvironmental.SELECTED_IMAGE =UserEnvironmental.DOGO_IMAGE;
                    break;
            }
            UserEnvironmental.FIRST_RANDOM_AVATAR=false;
        }
        avatar.setImage(UserEnvironmental.SELECTED_IMAGE);
        avatar.setFitWidth(x);
        avatar.setFitHeight(y);
    }

    public void savePassword() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Passy.data"));
            outputStream.writeObject(Main.autoLoginObject);
        } catch (IOException ex) {
            System.out.println("Saving error");
            ex.printStackTrace();
        }
    }

    public void readPassword() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Passy.data"));
            Object autoLoginObject = inputStream.readObject();
        } catch (Exception ex) {
            System.out.println("Reading error");
            ex.printStackTrace();
        }
    }

}
