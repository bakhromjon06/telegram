package uz.pdp.dao.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.user.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {
    //    private static ArrayList<User> users = new ArrayList<>();
//    private static User sessionUser = null;
//
//    public static  void adduser(User user) {
//        users.add(user);
//    }
//
//    public static ArrayList<User> getUsers() {
//        return users;
//    }
//    public static void setSessionUser(User user) {
//        sessionUser = user;
//    }
//    private static UserDao instance;
    private static Type userListType = new TypeToken<List<User>>() {
    }.getType();
    private static User sessionUser = null;
//
//    private UserDao() {
//    }
//
//    public static UserDao getInstance() {
//        if (instance == null) {
//            return new UserDao();
//        }
//        return instance;
//    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (FileReader fileReader = new FileReader("src/main/resources/users.json");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String jsonUsers = bufferedReader.lines().collect(Collectors.joining());
            Gson gson = new Gson();
            users = gson.fromJson(jsonUsers, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static boolean createUser(User user) {
        List<User> users = getUsers();
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        users.add(user);
        try (Writer writer = new FileWriter("src/main/resources/users.json");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            String jsonUsers = new Gson().toJson(users);
            bufferedWriter.write(jsonUsers);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void setSessionUser(User user) {
        sessionUser = user;
    }
    public static User getSessionUser() {
        return sessionUser;
    }
}
