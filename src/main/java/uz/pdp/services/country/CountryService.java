package uz.pdp.services.country;

import uz.pdp.dao.country.CountryDao;

import static uz.pdp.utils.print.Print.println;

public class CountryService {
    public static void showCountry() {
        int count = 1;
        for (String country : CountryDao.getCountries()) {
            println(String.format("%s. %s", count++, country));
        }
    }
}
