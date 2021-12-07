package uz.pdp.dao.country;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryDao {
    private static ArrayList<String> countries = new ArrayList<>();

    public static void addCountries(ArrayList<String> countries1) {
        for (String s : countries1) {
            countries.add(s);
        }
    }

    public static ArrayList<String> getCountries() {
        return countries;
    }

    public static int getCountrySize() {
        return countries.size();
    }
}
