package Model;

import java.util.*;
public class User implements IEntity{
    private UUID id;
    private String name;
    public User() {
        this.id = UUID.randomUUID();
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
