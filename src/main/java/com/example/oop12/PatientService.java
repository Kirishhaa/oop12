package com.example.oop12;

import com.example.oop12.structures.DiagnosArray;
import com.example.oop12.structures.Patient;
import com.example.oop12.structures.PatientArray;
import com.example.oop12.structures.Range;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService {

    private PatientArray patientArray;
    private DiagnosArray diagnosArray;
    private ArrayOperations arrayOperations;
    private IO io;


    @PostConstruct
    public void init(){
        io = new IO();
        arrayOperations = new ArrayOperations();
        patientArray = io.readFromDefaultFile(IO.DEFAULT_FILE);
        diagnosArray = DiagnosArray.parseDiagnosArray(patientArray);
    }

    public Patient findPatientByMedcard(int medcardno){
        return patientArray.findPatientByMedCardNo(medcardno);
    }

    public ArrayList<Patient> getRangePatients(int start, int end) {
        Range range = new Range(start,end);
        return arrayOperations.filter(patientArray, range).getArrayListPatient();
    }

    public ArrayList<Patient> getNumberPatients(int num) {
        return arrayOperations.filter(patientArray, num).getArrayListPatient();
    }

    public ArrayList<Patient> getPatients(){
        return patientArray.getArrayListPatient();
    }

    public ArrayList<String> getDiagnosArray() {
        return diagnosArray.getDiagnosArray();
    }

    public ArrayList<Integer> getAmountArray() {
        return diagnosArray.getAmountsArray();
    }

    public void savePatients(){
        io.saveToDefaultFile(patientArray, IO.DEFAULT_FILE);
    }

    public void addPatient(Patient patient){
        patientArray.add(patient);
        diagnosArray = DiagnosArray.parseDiagnosArray(patientArray);
    }

    public void deletePatientByMedCardNo(int medcardno) {
        patientArray.removePatientByMedCardNo(medcardno);
        diagnosArray = DiagnosArray.parseDiagnosArray(patientArray);
    }
}
