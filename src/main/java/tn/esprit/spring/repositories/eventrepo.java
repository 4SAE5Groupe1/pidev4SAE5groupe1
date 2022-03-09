package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Event;

@Repository
public interface eventrepo  extends JpaRepository<Event,Integer> {
    @Query( value ="SELECT COUNT(*) FROM participation_event u WHERE u.event_idevent=?1 ",nativeQuery = true)
    long NumberdeParticipationParIdEvent(Integer idevent);



}
