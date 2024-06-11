package TouristPathfinder2024.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.logging.Level;

public class UserProfileDto {

    private String username;
    private String fullName;
    private int age;

    private Level level;

    public UserProfileDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserProfileDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserProfileDto setAge(int age) {
        this.age = age;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public UserProfileDto setLevel(Level level) {
        this.level = level;
        return this;
    }
}
