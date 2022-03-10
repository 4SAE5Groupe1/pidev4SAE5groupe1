package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Event;

import java.util.Date;
import java.util.List;

@Repository
public interface eventrepo  extends JpaRepository<Event,Integer> {
    @Query( value ="SELECT COUNT(*) FROM participation_event u WHERE u.event_idevent=?1 ",nativeQuery = true)
    long NumberdeParticipationParIdEvent(Integer idevent);

    @Query("SELECT e FROM Event e WHERE e.Startdate =:d  ")

    List<Event> FiltrerEventByStartdate(@Param("d") Date d);
@Query("select e From Event e ORDER BY e.NumberLike desc ")
    List<Event> getlistedesEvenementmaxreact();
}
