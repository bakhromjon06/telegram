package uz.pdp.utils;

import java.util.UUID;

public class BaseUtil {
    public static String generateUniqueID() {
        return String.valueOf(UUID.randomUUID()).replace("-", "");
    }
}
