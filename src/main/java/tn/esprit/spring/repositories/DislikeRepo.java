package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entites.DislikeEvent;

public interface DislikeRepo extends JpaRepository<DislikeEvent , Integer> {
    @Query( value ="SELECT * FROM dislike_event c  WHERE c.user_id = ?1",nativeQuery = true)
    public DislikeEvent FindDislikeByUserId (Integer id);
}
