package uz.pdp.check.user;

import uz.pdp.dao.user.UserDao;
import uz.pdp.models.user.User;

import static uz.pdp.utils.print.Print.warning;

public class CheckUser {
    public static boolean checkUser(String username, String password) {
        for (User user : UserDao.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               UserDao.setSessionUser(user);
               return true;
            }
        }
        warning("Bad Credentials");
        return false;
    }
}
