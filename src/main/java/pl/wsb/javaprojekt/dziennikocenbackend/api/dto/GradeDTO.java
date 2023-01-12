package pl.wsb.javaprojekt.dziennikocenbackend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradeDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("subjectId")
    private Integer subjectId;

    @JsonProperty("teacherId")
    private Integer teacherId;

    @JsonProperty("studentId")
    private Integer studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }


}
