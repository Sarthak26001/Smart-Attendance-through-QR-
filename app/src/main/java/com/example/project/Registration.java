package com.example.project;

public class Registration {
    private String Firstname;
    private String Lastname;
    private String Eno;
    private String Email;
    private String Password;

    private String Gender;

    public Registration()
    {

    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEno() {
        return Eno;
    }

    public void setEno(String eno) {
        Eno = eno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
