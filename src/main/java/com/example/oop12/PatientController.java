package com.example.oop12;


import com.example.oop12.structures.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientService service;

    @GetMapping("/patients")
    public String showPatientArray(Model model) {
        model.addAttribute("patients", service.getPatients());
        model.addAttribute("diagnos_array",service.getDiagnosArray());
        model.addAttribute("amount_array", service.getAmountArray());
        return "patients";
    }

    @GetMapping("/save_patients")
    public String savePatients(){
        service.savePatients();
        return "redirect:/patients";
    }

    @GetMapping("/add_patient")
    public String addPatient(
            @RequestParam("patient_id") int id,
            @RequestParam("patient_lastname") String lastname,
            @RequestParam("patient_name") String name,
            @RequestParam("patient_fathername") String fathername,
            @RequestParam("patient_address") String address,
            @RequestParam("patient_phonenumber") long phonenumber,
            @RequestParam("patient_medcardno") int medcardno,
            @RequestParam("patient_diagnos") String diagnos) {
        service.addPatient(
                new Patient(id,
                medcardno,
                lastname,
                name,
                fathername,
                address,
                phonenumber,
                diagnos));
        return "redirect:/patients";
    }

    @GetMapping("/remove_patient")
    public String removePatient(@RequestParam int medcardno){
        service.deletePatientByMedCardNo(medcardno);
        return "redirect:/patients";
    }

    @GetMapping("/range_patients")
    public String rangePatients(@RequestParam("patients_start") int start,
                                @RequestParam("patients_end") int end,
                                Model model){
        model.addAttribute("range_patients", service.getRangePatients(start, end));
        return "/range";
    }

    @GetMapping("/number_patients")
    public String numberPatients(@RequestParam("patient_phonenumber_first") int num,
                                 Model model) {
        model.addAttribute("number_patients", service.getNumberPatients(num));
        return "/phonenumber";
    }

    @GetMapping("/find_patient")
    public String findPatient(@RequestParam("patient_medcardno") int medcardNo,
                              Model model){
        model.addAttribute("finded_patient", service.findPatientByMedcard(medcardNo));
        return "/finding";
    }
}
