package si.um.feri.jee.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.dao.PatientDao;
import si.um.feri.jee.vao.Patient;

@Named("demo")
@SessionScoped
public class PatientJSFBean implements Serializable {

    private static final long serialVersionUID = -8979220536758073133L;

    Logger log = Logger.getLogger(PatientJSFBean.class.toString());

    @EJB
    PatientDao dao;

    //private PatientDao dao=new PatientMemoryDao();

    private Patient selectedPatient = new Patient();

    private String selectedEmail;

    public List<Patient> getAllPatients() throws Exception {
        return dao.getAll();
    }

    public List<Patient> getAllWithoutDoc() throws Exception {
        return dao.getAllWithoutDoctor();
    }

    public String savePatient() throws Exception {
        dao.save(selectedPatient);
        return "all";
    }

    public void deletePatient(Patient o) throws Exception {
        dao.delete(o.getEmail());
    }

    public void setSelectedEmail(String email) throws Exception {
        selectedEmail =email;
        selectedPatient =dao.find(email);
        if(selectedPatient ==null) selectedPatient =new Patient();
    }

    public String getSelectedEmail() {
        return selectedEmail;
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

}
