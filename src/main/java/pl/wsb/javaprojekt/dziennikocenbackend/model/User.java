package pl.wsb.javaprojekt.dziennikocenbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.wsb.javaprojekt.dziennikocenbackend.enums.UserRoleType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Subject> subjects = new HashSet<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 19)
    private Date modified;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private UserRoleType role;

    private String login;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "access_token")
    private String accessToken;


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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }
}
