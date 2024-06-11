package TouristPathfinder2024.web.dto;

import jakarta.validation.constraints.*;

import java.util.List;
import java.util.logging.Level;

public class UserRegisterDto {
    @NotBlank
    @Size(min = 2)
    private String username;
    @NotEmpty
    @Size(min = 5)
    private String fullName;
    @Email
    private String email;
    @Min(0)
    @Max(90)
    private Integer age;
    @Size(min = 5)
    private String password;
    private String confirmPassword;

    private Level level;

    public UserRegisterDto() {
    }

    public Level getLevel() {
        return level;
    }

    public UserRegisterDto setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
