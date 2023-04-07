package com.example.oop12.structures;

import lombok.Getter;

import java.util.ArrayList;

public class DiagnosArray {
    @Getter
    private ArrayList<Integer> amountsArray;
    @Getter
    private ArrayList<String> diagnosArray;
    private int nItems = 0;

    public DiagnosArray(int size) {
        amountsArray = new ArrayList<>(size);
        diagnosArray = new ArrayList<>(size);
    }

    public DiagnosArray(){
        amountsArray = new ArrayList<>();
        diagnosArray = new ArrayList<>();
    }

    public static DiagnosArray parseDiagnosArray(PatientArray patients) {
        DiagnosArray array = new DiagnosArray(patients.size());
        for (int i = 0; i < patients.nPatients(); i++) {
            array.add(patients.get(i).getDiagnos());
        }
        array.sort();
        return array;
    }

    public void sort() {
        for (int out = 1; out < nItems; out++) {
            String tempString = diagnosArray.get(out);
            int tempInt = amountsArray.get(out);
            int in = out;
            while (in > 0 && amountsArray.get(in - 1) < tempInt) {
                diagnosArray.set(in,diagnosArray.get(in - 1));
                amountsArray.set(in,amountsArray.get(in - 1));
                --in;
            }
            amountsArray.set(in,tempInt);
            diagnosArray.set(in,tempString);
        }
    }

    public void add(String diagnos) {
        for (int i = 0; i < diagnosArray.size(); i++) {
            if (diagnosArray.get(i).equals(diagnos)) {
                amountsArray.set(i, amountsArray.get(i)+1);
                return;
            }
        }
        insert(diagnos);
        nItems++;
    }

    private void insert(String diagnos) {
        diagnosArray.add(diagnos);
        amountsArray.add(1);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<amountsArray.size();i++){
            if(diagnosArray.get(i)==null) break;
            builder
                    .append("diagnos = ")
                    .append(diagnosArray.get(i))
                    .append(" amount = ")
                    .append(amountsArray.get(i))
                    .append("\n");
        }
        return builder.toString();
    }
}

