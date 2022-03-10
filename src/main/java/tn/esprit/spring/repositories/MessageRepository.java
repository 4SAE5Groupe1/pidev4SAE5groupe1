package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.Message;


public interface MessageRepository extends CrudRepository<Message, Long> {

}
