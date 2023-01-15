package pl.wsb.javaprojekt.dziennikocenbackend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.wsb.javaprojekt.dziennikocenbackend.enums.UserRoleType;

public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private UserRoleType role;

    @JsonProperty
    private String accessToken;

    @JsonProperty
    private String login;

    @JsonProperty
    private String passwordHash;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRoleType getRole() {
        return role;
    }

    public void setRole(UserRoleType role) {
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
