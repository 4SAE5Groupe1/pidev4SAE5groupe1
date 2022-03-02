package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.ParticipationEvent;
@Repository
public interface ParticipationEventRepo extends JpaRepository<ParticipationEvent,Integer> {
}
