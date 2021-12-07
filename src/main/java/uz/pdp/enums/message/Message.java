package uz.pdp.enums.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Message {
    WRONG_CHOICE("Wrong choice"),
    MISMATCH("Please enter number"),
    SUCCESSFULLY("Successfully created");

    private String message;
}
