package si.um.feri.jee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.jee.ejb.PatientEJBRemote;
import si.um.feri.jee.vao.Patient;

@Stateless
public class PatientMemoryDao implements PatientDao, PatientEJBRemote {

    Logger log=Logger.getLogger(PatientMemoryDao.class.toString());

    // private List<Patient> people=Collections.synchronizedList(new ArrayList<>());

    @PersistenceContext(unitName = "testdb")
    EntityManager em;

    @Override
    public List<Patient> getAll() {
        log.info("DAO: get all");
        return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }

    @Override
    public List<Patient> getAllWithoutDoctor() {
        /*List<Patient> result = new ArrayList<>();
        for (Patient o : people) {
            if (o.getDoctor() == null || o.getDoctor().isEmpty()) {
                result.add(o);
            }
        }*/
        return em.createQuery("SELECT p FROM Patient p WHERE p.doctor is NULL OR p.doctor = ''", Patient.class).getResultList();
    }

    @Override
    public Patient find(String email)  {
        /*log.info("DAO: finding "+email);
        for (Patient o : people)
            if (o.getEmail().equals(email))
                return o;*/
        em.createQuery("SELECT p FROM Patient p WHERE p.email = :email");
        return null;
    }

    @Override
    public void save(Patient o)  {
        /*log.info("DAO: saving "+o);
        if(find(o.getEmail())!=null) {
            log.info("DAO: editing "+o);
            delete(o.getEmail());
        }
        people.add(o);*/
        em.persist(o);
    }

    @Override
    public void delete(String email) {
        /*log.info("DAO: deleting "+email);
        for (Iterator<Patient> i = people.iterator(); i.hasNext();) {
            if (i.next().getEmail().equals(email))
                i.remove();
        }*/
        Patient o = em.find(Patient.class, email);
        em.remove(o);
    }

    public void edit(String email) {
        Patient p = em.find(Patient.class, email);

    }

}