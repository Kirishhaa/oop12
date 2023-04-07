package com.example.oop12.structures;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.io.Serializable;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class Patient implements Serializable {
    private int id,medCardNo;
    private String surname, name, fatherName, address;
    private long phonenumber;
    private String diagnos;

    public Patient(int id, int medCardNo, String surname,
                   String name, String fatherName,
                   String address, long phonenumber, String diagnos) {
        this.id = id;
        this.medCardNo = medCardNo;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.diagnos = diagnos;
    }

    public Patient() {

    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public int getMedCardNo() {
        return medCardNo;
    }

    public String getDiagnos() {
        return diagnos;
    }

    public static Patient parsePatient(String line) {
        String[] split = line.split(" ");
        return new Patient(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                split[2],
                split[3],
                split[4],
                split[5],
                Long.parseLong(split[6]),
                split[7]
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient)
            return this.medCardNo == ((Patient) obj).medCardNo;
        else return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return medCardNo;
    }

    @Override
    public String toString() {
        return id + " " + surname + " " + name + " " + fatherName + " " + address + " " + phonenumber + " " + medCardNo+" "+diagnos;
    }
}
