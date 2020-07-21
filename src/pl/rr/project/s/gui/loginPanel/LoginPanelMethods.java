package pl.rr.project.s.gui.loginPanel;

import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.Utils;

import java.util.Random;

public class LoginPanelMethods extends Utils {
    Random rand = new Random();
    int random = rand.nextInt(2);

    public boolean checkLogin(String username){
        UserEnvironmental.USERNAME=username;
        for (int i = 0; i<UserEnvironmental.userList.size(); i++){
            String user = UserEnvironmental.userList.get(i);
            if (username.equals(user)){
                UserEnvironmental.IMAGE_CHOSEN=random;
                System.out.println(random);
                return true;
            }
        }
        return false;
    }
}
