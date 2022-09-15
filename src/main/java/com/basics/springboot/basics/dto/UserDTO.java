package com.basics.springboot.basics.dto;

import java.time.LocalDate;

public class UserDTO {
    private String name;
    private LocalDate birthDate;

    public UserDTO(String name, LocalDate birthDate) {

        this.name = name;
        this.birthDate = birthDate;
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
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
