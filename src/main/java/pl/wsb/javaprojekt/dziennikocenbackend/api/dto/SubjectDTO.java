package pl.wsb.javaprojekt.dziennikocenbackend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String authorld;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorld() {
        return authorld;
    }

    public void setAuthorld(String authorld) {
        this.authorld = authorld;
    }

}
