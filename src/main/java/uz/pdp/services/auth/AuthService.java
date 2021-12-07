package uz.pdp.services.auth;

import uz.pdp.check.main.MainCheck;
import uz.pdp.dao.country.CountryDao;
import uz.pdp.dao.message.MessageDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.enums.message.Message;
import uz.pdp.models.user.User;
import uz.pdp.services.country.CountryService;

import java.util.ArrayList;

import static uz.pdp.check.user.CheckUser.checkUser;
import static uz.pdp.services.user.UserService.account;
import static uz.pdp.utils.color.Color.GREEN;
import static uz.pdp.utils.color.Color.YELLOW;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class AuthService {
    public static void mainMenu() {
        String choice = getStr("""
                🔴 Login -> 1
                🔴 Registrate -> 2
                🔴 Quit -> 0
                ? : """);
        if (choice.equals("1")) {
            login();
        } else if (choice.equals("2")) {
            registrate();
        } else if (choice.equals("0")) {
            return;
        } else {
            warning(Message.WRONG_CHOICE.getMessage());
        }
        mainMenu();
    }

    // main
    private static void login() {
        String username = getStr("Username: ");
        String password = getStr("Password: ");
        if (!checkUser(username, password) && tryAgain()) {
            login();
        } else if (!checkUser(username, password) && !tryAgain()) {
            return;
        } else {
            account();
        }
    }


    // helper for login()
    public static boolean tryAgain() {
        String choice = getStr("""
                🔄 Try again -> 1
                ↩ Exit -> 0
                ? : """);
        if (choice.equals("1")) {
            return true;
        } else if (choice.equals("0")) {
            return false;
        } else {
            warning(Message.WRONG_CHOICE.getMessage());
        }
        return tryAgain();
    }

    // main
    private static void registrate() {
        println("""
                                Sign  in to Telegram
                Please confirm your country and enter your phone number.""");
        println("County");
        CountryService.showCountry();
        User user = User.builder().build();
        requestCountry(user);
        println("Please confirm your country code and enter your phone number.");
        String phoneNumber = getStr("+");
        // TODO: 11/28/2021 Check phone number
        user.setPhoneNumber("+" + phoneNumber);
        if (next()) {
            registrateByUsername(user);
        } else {
            return;
        }
    }

    // helper for registrate()
    private static void registrateByUsername(User user) {
        String firstName = getStr("First Name: ");
        String lastName = getStr("Last Name: ");
        String username = getStr("Username: ");
        // TODO: 11/28/2021 Check username
        String password = getStr("Password: ");
        // TODO: 11/28/2021 Check password
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        UserDao.createUser(user);
        println(GREEN, Message.SUCCESSFULLY.getMessage());
    }

    private static boolean next() {
        String choice = getStr("""
                ↪ Next -> 1
                ↩ Cancel -> 0
                ? : """);
        if (choice.equals("1")) {
            return true;
        } else if (choice.equals("0")) {
            return false;
        } else {
            warning(Message.WRONG_CHOICE.name());
            return next();
        }
    }

    private static void requestCountry(User user) {
        String countryChoice = getStr("? : ");
        if (MainCheck.countryCheck(countryChoice)) {
            String country = CountryDao.getCountries().get(Integer.parseInt(countryChoice) - 1);
            user.setCountry(country);
        } else {
            warning(Message.WRONG_CHOICE.getMessage());
            requestCountry(user);
        }
    }
}
