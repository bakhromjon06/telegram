package uz.pdp;

import java.io.FileReader;

import static uz.pdp.db.init.Init.init;
import static uz.pdp.services.auth.AuthService.mainMenu;

public class App {
    public static void main(String[] args) {
        init();
        mainMenu();
    }
}
