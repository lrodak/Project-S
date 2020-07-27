package pl.rr.project.s.language;

import pl.rr.project.s.Utils;
import pl.rr.project.s.language.languages.ENG;
import pl.rr.project.s.language.languages.PL;

public class ChangeLanguage extends Utils {
    public static void changeLanguage(String lang)
    {
        switch (lang){
            case "ENG":
                //LOGIN PANEL
                CurrentLanguage.USERNAME = ENG.USERNAME;
                CurrentLanguage.PASSWORD = ENG.PASSWORD;
                CurrentLanguage.REMEMBER_PASSWORD = ENG.REMEMBER_PASSWORD;
                CurrentLanguage.LOGIN = ENG.LOGIN;
                CurrentLanguage.CANCEL = ENG.CANCEL;
                CurrentLanguage.CREATE_ACCOUNT = ENG.CREATE_ACCOUNT;
                break;

            case "PL":
                //LOGIN PANEL
                CurrentLanguage.USERNAME = PL.USERNAME;
                CurrentLanguage.PASSWORD = PL.PASSWORD;
                CurrentLanguage.REMEMBER_PASSWORD = PL.REMEMBER_PASSWORD;
                CurrentLanguage.LOGIN = PL.LOGIN;
                CurrentLanguage.CANCEL = PL.CANCEL;
                CurrentLanguage.CREATE_ACCOUNT = PL.CREATE_ACCOUNT;
                break;
        }
    }
}
