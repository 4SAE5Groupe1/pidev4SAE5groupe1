package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entites.LikeEvent;

public interface LikeRepo extends JpaRepository<LikeEvent,Integer> {
    @Query( value ="SELECT * FROM like_event c  WHERE c.user_id = ?1 ",nativeQuery = true)
    public LikeEvent FindlikeByUserId (Integer id);
}
