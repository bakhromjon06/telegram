package uz.pdp.models.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.models.Entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Message extends Entity {
    private String from;
    private String to;
    private String text;
//    private LocalTime time;
}
