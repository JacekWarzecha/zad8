package akademia.devopsi.pl.zaddomakademiadevopsitest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;


    @PostMapping("/patient")
    public ResponseEntity<Void> registerPatient (@RequestBody @Valid Patient patient){
        this.patientService.registerPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }


    @PutMapping("/patient/{pesel}")
    public ResponseEntity<Patient> updatePatient (@PathVariable @Valid Long pesel, @RequestBody @Valid Patient patient){
        this.patientService.updatePatient(pesel,patient);
        return ResponseEntity.status(HttpStatus.OK)
                .body(patient);
    }

    @DeleteMapping("/patient/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable @Valid Long pesel){
        this.patientService.deletePatient(pesel);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }


    @GetMapping("/patient")
    public ResponseEntity<List<Patient>>getPatients(){
        List<Patient>patients=this.patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK)
                .body(patients);
    }

}
