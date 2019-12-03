package nc.Medas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String telephone;
    private String password;
    private String login;
    private String role;
    private String email;
    private double money;

    public User(String username, String password, String roles, String permissions){
        this.login = username;
        this.password = password;
        this.role = roles;
    }

    public User(String firstName,String email, double money, String lastName, Date birthDate, String telephone, String password, String login, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.password = password;
        this.login = login;
        this.role = role;
        this.money = money;
        this.email = email;
    }

    public User(){

    }
    public User(User userOld) {

        User newUser = new User();
        newUser.setLastName(userOld.getLastName());
        newUser.setFirstName(userOld.getFirstName());
        newUser.setBirthDate(userOld.getBirthDate());
        newUser.setId(userOld.getId());
        newUser.setTelephone(userOld.getTelephone());
        newUser.setRole(userOld.getRole());
        newUser.setPassword(userOld.getPassword());
        newUser.setLogin(userOld.getLogin());

    }
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String roles = "USER ADMIN MANAGER";



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(login, user.login) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate, telephone, password, login, role);
    }



}