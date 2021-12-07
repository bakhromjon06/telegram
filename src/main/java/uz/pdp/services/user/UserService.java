package uz.pdp.services.user;

import uz.pdp.check.main.MainCheck;
import uz.pdp.check.user.CheckUser;
import uz.pdp.dao.user.UserDao;
import uz.pdp.enums.message.Message;
import uz.pdp.models.user.User;

import java.util.ArrayList;

import static uz.pdp.services.auth.AuthService.tryAgain;
import static uz.pdp.services.profile.ProfileService.profile;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.input.Input.getStrLine;
import static uz.pdp.utils.print.Print.println;
import static uz.pdp.utils.print.Print.warning;

public class UserService {
    public static void account() {
        String choice = getStr("""
                ☰ -> 1                          
                🔍 -> 2
                                           
                User -> 3
                Group -> 4
                Channel -> 5
                Bot -> 6
                Add to contact -> 7
                Quit -> 0
                ? : """);
        if (choice.equals("1")) {
            user();
        } else if (choice.equals("2")) {
            search();
        } else if (choice.equals("3")) {

        } else if (choice.equals("4")) {

        } else if (choice.equals("5")) {

        } else if (choice.equals("6")) {

        } else if (choice.equals("7")) {

        } else if (choice.equals("0")) {
            return;
        } else {
            warning(Message.WRONG_CHOICE.getMessage());
        }
        account();
    }

    private static void user() {
        
    }

    private static void search() {
        ArrayList<Integer> indexes = new ArrayList<>();
        int count = 1;
        int i = 0;
        String username = getStr("search...");
        for (User user : UserDao.getUsers()) {
            if (user.getUsername().contains(username)) {
                String status = (user.isOnline()) ? "online" : "offline";
                println(String.format("""
                        %s. %s  [%s]""", count++, user.getFirstName(), status));
                indexes.add(i);
            }
            i++;
        }
        chooseUser(indexes);
    }

    private static void chooseUser(ArrayList<Integer> indexes) {
        String choice = getStr("? : ");
        if (!MainCheck.isNumber(choice) && tryAgain()) {
            search();
        } else if (!MainCheck.isNumber(choice) && !tryAgain()) {
            return;
        } else {
            int choiceN = Integer.parseInt(choice);
            if (choiceN > indexes.size()) {
                warning(Message.WRONG_CHOICE.getMessage());
                if (tryAgain()) {
                    chooseUser(indexes);
                } else {
                    return;
                }
            }
            profile(UserDao.getUsers().get(indexes.get(choiceN - 1)));
        }
    }

}
