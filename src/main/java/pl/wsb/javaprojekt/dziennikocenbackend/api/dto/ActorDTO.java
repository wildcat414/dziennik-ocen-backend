package pl.wsb.javaprojekt.dziennikocenbackend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

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
}
