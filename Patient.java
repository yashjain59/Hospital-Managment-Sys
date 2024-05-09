/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalms;

/**
 *
 * @author jyash
 */
public class Patient {
    private String Id,Name,Contact;
    
    public Patient(){
        Id="";
        this.Name="";
        this.Contact="";
    }

    public Patient(String Id, String Name, String Contact) {
        this.Id = Id;
        this.Name = Name;
        this.Contact = Contact;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    @Override
    public String toString() {
        return "Patient{" + "Id=" + Id + ", Name=" + Name + ", Contact=" + Contact + '}';
    }
    
    
}
