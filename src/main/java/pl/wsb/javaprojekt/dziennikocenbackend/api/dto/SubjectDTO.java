package pl.wsb.javaprojekt.dziennikocenbackend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Integer authorId;

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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

}
