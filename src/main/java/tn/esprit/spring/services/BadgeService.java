package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.BadgeDAO;
import tn.esprit.spring.entites.Badge;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.BadgeRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.util.List;
@Service
public class BadgeService implements BadgeDAO {
    //String img=this.generateQRCodeImage();
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Badge> getAllBadges() {
        List<Badge> badges = badgeRepository.findAll();
        return badges;
    }

    @Override
    public Badge addBadge(Badge b)  {
        return badgeRepository.save(b);
    }

    @Override
    public Badge updateBadge(Badge b) {
        return badgeRepository.save(b);
    }

    @Override
    public void deleteBadge(int badgeId) {
        badgeRepository.deleteById(badgeId);
    }

    @Override
    public Badge getBadge(int badgeId) {
        Badge b = badgeRepository.findById(badgeId).orElse(null);
        return b;
    }

    public void ajouterEtaffecterListeBadge(Badge badge, int idUser) {
        badgeRepository.save(badge);
        User user = userRepository.findById( idUser).orElse(null);

            badge.setUser(user);

        badgeRepository.save(badge);

    }
}
