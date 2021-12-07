package uz.pdp.services.profile;

import uz.pdp.dao.message.MessageDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.models.message.Message;
import uz.pdp.models.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static uz.pdp.utils.color.Color.GREEN;
import static uz.pdp.utils.color.Color.RED;
import static uz.pdp.utils.input.Input.getStr;
import static uz.pdp.utils.input.Input.getStrLine;
import static uz.pdp.utils.print.Print.println;

public class ProfileService {
    public static void profile(User user) {
        boolean isMessage = false;
        println(String.format("""
                 🔙 -> 0            👤  %s""", user.getFirstName()));
        for (Message message : MessageDao.getMessages()) {
            if (message.getFrom().equals(UserDao.getSessionUser().getId()) && message.getTo().equals(user.getId())) {
                String probel = "                 ";
                println(GREEN, String.format("""
                         %s %s""", probel, message.getText()));
                isMessage = true;
            } else if (message.getFrom().equals(user.getId()) && message.getTo().equals(UserDao.getSessionUser().getId())) {
                println(String.format("""                           
                         %s""", message.getText()));
                isMessage = true;
            }
        }
        if (!isMessage){
            println(RED, "Do you have not any message");
        }
        String choice = getStr("""
                Message... -> 1""");
        if (choice.equals("0")) {
            return;
        } else if (choice.equals("1")) {
            writeMessage(user.getId());
        }
        profile(user);
    }

    private static void writeMessage(String userId) {
        String text = getStrLine("\nMessage...");
//        LocalTime time = LocalTime.now();
        String from = UserDao.getSessionUser().getId();
        String to = userId;
        Message message = new Message(from, to, text);
        MessageDao.addMessage(message);
    }
}
