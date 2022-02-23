package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Event;
@Repository
public interface eventrepo  extends JpaRepository<Event,Integer> {
}
