package si.um.feri.jee.vao;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {

    public Patient() {
        this("", "","","","");
    }

    public Patient(String name, String surname, String email, String doctor, String details) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.doctor = doctor;
        this.details = details;
        birthDate = LocalDate.now();
    }

    private String email;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String doctor;
    private String details;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString(){
        return name + " " + surname + " " + email;
    }
}