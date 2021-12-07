package uz.pdp.check.main;

import uz.pdp.dao.country.CountryDao;
import uz.pdp.enums.message.Message;

import static uz.pdp.utils.print.Print.warning;

public class MainCheck {
    public static boolean countryCheck(String choice) {
        int choiceI = -1;
        try {
            choiceI = Integer.parseInt(choice);
        } catch (Exception e) {
            warning(Message.MISMATCH.getMessage());
            return false;
        }
        if (choiceI > CountryDao.getCountrySize() || choiceI == 0) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String str) {
        try {
            int n = Integer.parseInt(str);
        } catch (Exception e) {
            warning(Message.MISMATCH.getMessage());
            return false;
        }
        return true;
    }

}
