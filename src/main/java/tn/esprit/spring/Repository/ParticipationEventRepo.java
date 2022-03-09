package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.ParticipationEvent;

import java.util.List;

@Repository
public interface ParticipationEventRepo extends JpaRepository<ParticipationEvent,Integer> {
    @Query( value ="SELECT * FROM participation_event c  WHERE c.event_idevent = ?1 ",nativeQuery = true)
     List<ParticipationEvent> getlistparticipationwithIdEvent ( Integer idevent);
}
