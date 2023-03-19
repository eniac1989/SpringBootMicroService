package com.alipour.rest.webservices.restfulwebservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Paniz Alipour
 */
public class User {

    private Integer id;

    @Size(min = 2, message = "name should have at least 2 characters")
    private String name;
    @Past
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
