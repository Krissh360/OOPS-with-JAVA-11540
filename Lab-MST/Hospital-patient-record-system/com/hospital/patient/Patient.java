package com.hospital.patient;

public class Patient
{
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

     public int getPatientId()
    {
        return id;
    }

    public void setPatientId(int id)
    {
        this.id = id;
    }

    public String getPatientName()
    {
        return name;
    }

    public void setPatientName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getDisease()
    {
        return disease;
    }

    public void setDisease(String disease)
    {
        this.disease = disease;
    }

    public void displayPatient()
    {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + age);
        System.out.println("Patient Disease: " + disease);
    }

}