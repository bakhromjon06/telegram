package uz.pdp.db.init;

import uz.pdp.dao.country.CountryDao;
import uz.pdp.dao.message.MessageDao;
import uz.pdp.dao.user.UserDao;
import uz.pdp.enums.Role;
import uz.pdp.models.user.User;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Init {
    public static void init() {
        User user = User.builder().username("adm1").password("123").firstName("Bahromjon")
                .lastName("Xasanboyev").role(Role.SYSTEM_ADMIN).build();
        UserDao.createUser(user);
        User user1 = User.builder().username("pavelDurov").password("123").firstName("Pavel").lastName("Durov").build();
        User user2 = User.builder().username("elonMusk").password("123").firstName("Elon").lastName("Musk").build();
        User user3 = User.builder().username("markZukerberg").password("123").firstName("Mark").lastName("Zukerberg").build();
        UserDao.createUser(user1);
        UserDao.createUser(user2);
        UserDao.createUser(user3);
        ArrayList<String> countries = new ArrayList<>(Arrays.asList("Afghanistan",
                "Albania",
                "Algeria",
                "Andorra",
                "Angola",
                "Antigua and Barbuda",
                "Argentina",
                "Armenia",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Uganda",
                "Ukraine",
                "United Arab Emirates",
                "The United Kingdom",
                "Uruguay",
                "Uzbekistan"));
        CountryDao.addCountries(countries);
    }

}
