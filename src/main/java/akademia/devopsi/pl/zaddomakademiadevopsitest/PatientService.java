package akademia.devopsi.pl.zaddomakademiadevopsitest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class PatientService {
    private final Map<Long, Patient> patients;
    private final PatientRepository patientRepository;


    public void registerPatient (Patient patient){
        if(patientRepository.existsById(patient.getPesel())) {
            throw new PatientException("Pesel:  " + patient.getPesel() + "  already exists");
        }
            patientRepository.save(patient);
        }


    public void updatePatient(Long pesel, Patient patient){
        if(patientRepository.existsById(pesel)){
            Patient registeredPatient = patientRepository.findById(pesel).get();
            registeredPatient.setName(patient.getName());
            registeredPatient.setSurname(patient.getSurname());
            registeredPatient.setTelephone(patient.getTelephone());
            registeredPatient.setComments(patient.getComments());
            patientRepository.save(registeredPatient);
        }
    }

    public void deletePatient(Long pesel){
        if(patientRepository.findById(pesel).isPresent()) {
            patientRepository.deleteById(pesel);
        } else{
                throw new PatientException("Pesel:  " + pesel + "  not exists");
            }
        }


    public List<Patient> getPatients(){
        List<Patient>tmpPatients=new ArrayList<>();
        for( Long pesel:this.patients.keySet()){
            tmpPatients.add(this.patients.get(pesel));
        }
        return tmpPatients;
    }

}
