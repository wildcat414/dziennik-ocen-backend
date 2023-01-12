package pl.wsb.javaprojekt.dziennikocenbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 19)
    private Date modified;

    @Column(name = "subjectId")
    private Integer subjectId;

    @Column(name = "teacherid")
    private Integer teacherId;

    @Column(name = "studentId")
    private Integer studentId;

    @Column(name = "value")
    private Float value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
