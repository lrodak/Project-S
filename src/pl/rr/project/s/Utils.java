package pl.rr.project.s;

import javafx.scene.image.ImageView;

import java.io.*;


//universal methods for multi-purpose
public class Utils {

    public void setAvatar(ImageView avatar) {
        if (UserEnvironmental.IMAGE_CHOSEN==0){
            avatar.setImage(UserEnvironmental.ADMIN_IMAGE);
        }
        else if(UserEnvironmental.IMAGE_CHOSEN==1) {
            avatar.setImage(UserEnvironmental.DOGO_IMAGE);
        }
        else avatar.setImage(UserEnvironmental.WHITE_SOMETHING);
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
