package uz.pdp.dao.message;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import uz.pdp.models.message.Message;
import uz.pdp.models.user.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MessageDao {
    private static ArrayList<Message> messages = new ArrayList<>();

    public static void addMessage(Message message) {
        messages.add(message);
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }
}
//    private static HashMap<String, ArrayList<Message>> messages = new HashMap<>();

//    public static void put(String id, ArrayList<Message> message) {
//        messages.put(id, message);
//    }
//    public static void addMessage(String id, Message message) {
//        for (String s : messages.keySet()) {
//            if (s.equals(id)) {
//                ArrayList<Message> messages1 = messages.get(id);
//                messages1.add(message);
//                messages.put(id, messages1);
//            }
//        }


//    private static Type messageListType = new TypeToken<List<Message>>(){}.getType();
//
//    public static List<Message> getMessage() {
//        List<Message> messages = new ArrayList<>();
//        BufferedReader bufferedReader = null;
//        try {
//            FileReader fileReader = new FileReader("src/main/resources/message.json");
//            bufferedReader = new BufferedReader(fileReader);
//            String jsonMessage = bufferedReader.lines().collect(Collectors.joining());
//            messages = new Gson().fromJson(jsonMessage, messageListType);
//        } catch (JsonSyntaxException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bufferedReader != null) {
//                try{
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return messages;
//    }
//
//    public static boolean createMessage(Message message) {
//        List<Message> messages = getMessage();
//        messages.add(message);
//        try(Writer writer = new FileWriter("src/main/resources/message.json");
//        BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
//            String jsonMessage = new Gson().toJson(message);
//            bufferedWriter.write(jsonMessage);
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//            }
