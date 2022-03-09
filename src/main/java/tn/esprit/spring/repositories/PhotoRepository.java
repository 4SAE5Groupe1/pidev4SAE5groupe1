package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Photo;
@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {
}
