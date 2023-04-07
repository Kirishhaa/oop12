package com.example.oop12;

import com.example.oop12.structures.Patient;
import com.example.oop12.structures.PatientArray;

import java.io.*;

public class IO {

    public static String DEFAULT_FILE = "defaultFile.txt";

    public void saveToDefaultFile(PatientArray patientArray, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(patientArray);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
    }

    public PatientArray readFromDefaultFile(String fileName) {
        PatientArray patientArray = new PatientArray();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line=bf.readLine())!=null && !line.equals("")){
                patientArray.add(Patient.parsePatient(line));
            }
        } catch (IOException e) {
            patientArray = new PatientArray();
        }
        return patientArray;
    }
}