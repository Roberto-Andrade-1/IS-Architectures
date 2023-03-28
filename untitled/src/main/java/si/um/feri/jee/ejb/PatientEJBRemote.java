package si.um.feri.jee.ejb;

import si.um.feri.jee.vao.Patient;

import java.util.List;

public interface PatientEJBRemote {
    List<Patient> getAllWithoutDoctor();
}