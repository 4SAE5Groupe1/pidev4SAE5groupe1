package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Categorieevent;
@Repository

public interface categrorieeventRepo extends JpaRepository<Categorieevent,Integer> {
}
