package com.example.oop12.structures;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientArray implements Serializable {
    private ArrayList<Patient> patients = new ArrayList<>(100);
    private int nPatients = 0;

    public ArrayList<Patient> getArrayListPatient(){
        return patients;
    }

    public PatientArray(ArrayList<Patient> patients){
        this.patients = patients;
        for (Patient ignored : patients) {
            nPatients++;
        }
    }

    public PatientArray(){

    }

    public Patient findPatientByMedCardNo(int medCardNo){
        for (Patient next : patients) {
            if (next.getMedCardNo() == medCardNo) {
                return next;
            }
        }
        return null;
    }

    public void removePatientByMedCardNo(int medCardNo){
        if(patients.remove(findPatientByMedCardNo(medCardNo))){
            nPatients--;
        }
    }

    public int size() {
        return patients.size();
    }

    public Patient get(int index) {
        return patients.get(index);
    }

    public int nPatients() {
        return nPatients;
    }

    public void add(Patient patient) {
        patients.add(patient);
        nPatients++;
    }


    public void insert(int index, Patient patient) {
        patients.set(index, patient);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Patient patient : patients) {
            if (patient == null) break;
            result.append(patient);
            if(patient!=patients.get(nPatients-1))
                result.append("\n");
        }
        return result.toString();
    }
}
