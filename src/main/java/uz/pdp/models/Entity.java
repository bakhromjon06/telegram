package uz.pdp.models;

import lombok.Getter;
import lombok.Setter;

import static uz.pdp.utils.BaseUtil.generateUniqueID;

@Getter
public class Entity {
    private String id = generateUniqueID();
}
