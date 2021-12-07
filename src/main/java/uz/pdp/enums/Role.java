package uz.pdp.enums;

import lombok.Getter;

@Getter
public enum Role {
    SYSTEM_ADMIN,
    ADMIN_FOR_GROUP,
    ADMIN_FOR_CHANNAL,
    OWNER_FOR_GROUP,
    USER,
    ANONYMOUS_FOR_IN;
}
