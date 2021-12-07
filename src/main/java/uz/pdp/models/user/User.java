package uz.pdp.models.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.enums.Role;
import uz.pdp.models.Entity;
@Setter
@Getter
@Builder
public class User extends Entity {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String code;
    private String country;
    private String phoneNumber;
    private boolean online;
    private Role role = Role.USER;
}
