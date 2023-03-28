package si.um.feri.jee.ejb;

import jakarta.ejb.Remote;
import si.um.feri.jee.vao.Patient;

import java.util.List;

@Remote
public interface PatientEJBRemote {

    List<Patient> getAllWithoutDoctor();
}
