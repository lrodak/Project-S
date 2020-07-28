package pl.rr.project.s.gui.loginPanel;

import pl.rr.project.s.BasicMethods;
import pl.rr.project.s.UserEnvironmental;

public class LoginPanelMethods extends BasicMethods {

    public boolean checkLogin(String username){
        UserEnvironmental.USERNAME=username;
        for (int i = 0; i<UserEnvironmental.userList.size(); i++){
            String user = UserEnvironmental.userList.get(i);
            if (username.equals(user)){
                return true;
            }
        }
        return false;
    }
}
