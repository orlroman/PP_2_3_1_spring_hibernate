package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]+$", message = "Name must contain only letters")
    @Size(max = 128, message = "maximum length 128")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ]+$", message = "Surname must contain only letters")
    @Size(max = 128, message = "maximum length 128")
    @Column(name = "surname")
    private String surname;
    
    @NotNull(message = "Age should not be empty")
    @Digits(integer = 2, fraction = 0, message = "Age must be a number with up to 3 digits")
    @PositiveOrZero(message = "Age must be positive or zero")
    @Column(name = "age")
    private Integer age;
    
    public User() {
    }
    
    public User(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
