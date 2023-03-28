package si.um.feri.jee.dao;

import java.util.List;

import jakarta.ejb.Local;
import si.um.feri.jee.vao.Patient;

@Local
public interface PatientDao {

    List<Patient> getAll();

    Patient find(String email);
    void save(Patient o);
    void delete(String email);
    List<Patient> getAllWithoutDoctor();

}