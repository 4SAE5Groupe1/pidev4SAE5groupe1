package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.Emoji;


public interface EmojiRepository extends CrudRepository<Emoji, Long> {

}
