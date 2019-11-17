package nc.Medas.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "medas")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String telephone;
    private byte role;
    private String login;
    private String password;


    @Id
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "role")
    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
