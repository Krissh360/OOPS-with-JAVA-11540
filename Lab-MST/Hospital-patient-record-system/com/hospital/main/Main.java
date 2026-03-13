package com.hospital.main;

import com.hospital.service.HospitalService;

public class Main
{
    public static void main(String[] args)
    {
        HospitalService hs = new HospitalService();

        try
        {
            hs.addPatient();

            System.out.println("\nPatient Records:");
            hs.displayPatients();
            hs.searchPatient();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}