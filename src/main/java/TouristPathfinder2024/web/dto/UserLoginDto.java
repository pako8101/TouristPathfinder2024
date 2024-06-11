package TouristPathfinder2024.web.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDto{
    @NotBlank
    String username;
    @NotBlank
    String password;

    public UserLoginDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
