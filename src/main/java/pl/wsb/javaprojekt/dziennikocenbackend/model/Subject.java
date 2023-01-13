package pl.wsb.javaprojekt.dziennikocenbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 19)
    private Date modified;

    @Column(name = "name")
    private String name;

//    @Column(name = "author_id")
//    private Integer authorId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(Integer authorId) {
//        this.authorId = authorId;
//    }

    public User getUser() {
        return user;
    }

    public void assignUser(User user) {
        this.user = user;
    }
}
