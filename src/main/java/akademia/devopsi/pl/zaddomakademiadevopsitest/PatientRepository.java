package akademia.devopsi.pl.zaddomakademiadevopsitest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository <Patient, Long> {




}
