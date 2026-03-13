package com.hospital.service;

import com.hospital.patient.Patient;
import com.hospital.exception.*;
import java.io.*;
import java.util.Scanner;

public class HospitalService
{
    private static final String FILE_NAME = "patients.txt";
    Scanner sc = new Scanner(System.in);

    public void addPatient() throws Exception
    {
        System.out.println("Enter patient id:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter patient name:");
        String name = sc.nextLine();

        System.out.println("Enter patient age:");
        int age = sc.nextInt();
        sc.nextLine();

        if(age < 0 || age > 120)
        {
            throw new InvalidAgeException("Invalid Age");
        }

        System.out.println("Enter patient disease:");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, disease);

        File f = new File("patients.txt");

         if(f.exists())
        {
            Scanner fileScanner = new Scanner(f);

            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String data[] = line.split(",");

                if(Integer.parseInt(data[0]) == id)
                {
                    fileScanner.close();
                    throw new DuplicatePatientException("Patient already exists");
                }
            }

            fileScanner.close();
        }

        FileWriter fw = new FileWriter(FILE_NAME,true);

        fw.write(p.getPatientId()+","+p.getPatientName()+","+p.getAge()+","+p.getDisease()+"\n");

        fw.close();

        if(age > 60 && disease.equals("Heart Problem"))
        {
            System.out.println("Priority Patient: Immediate Attention Required");
        }

        System.out.println("Patient added");

    }

    public void displayPatients()
    {

        try
        {
            File f = new File(FILE_NAME);
            Scanner fileScanner = new Scanner(f);

            while(fileScanner.hasNextLine())
                {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
        }
        catch(Exception e)
        {
            System.out.println("Error reading file");
        }
    }

     public void searchPatient() throws Exception
     {

        System.out.println("Enter patient ID to search:");
        int id = sc.nextInt();

        File f = new File(FILE_NAME);
        Scanner fileScanner = new Scanner(f);

        boolean found = false;

        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String data[] = line.split(",");

            if(Integer.parseInt(data[0]) == id){
                System.out.println("ID: "+data[0]);
                System.out.println("Name: "+data[1]);
                System.out.println("Age: "+data[2]);
                System.out.println("Disease: "+data[3]);
                found = true;
            }
        }

        fileScanner.close();

        if(!found)
        {
            throw new PatientNotFoundException("Patient not found");
        }
    }
}