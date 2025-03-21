package com.example.learing.students;

import jakarta.persistence.*;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,name = "f_name")
    private String firstName;
    @Column(nullable = false,name = "l_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private  StudentProfile studentProfile;
    public Student(Integer id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
