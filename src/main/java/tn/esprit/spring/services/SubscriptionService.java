package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.SubscriptionDAO;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.SubscriptionRepo;
import tn.esprit.spring.repositories.UserRepository;

import java.util.List;
@Service
public class SubscriptionService implements SubscriptionDAO {
    @Autowired
    SubscriptionRepo SubscriptionRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> Subscriptions = SubscriptionRepository.findAll();
        return Subscriptions;
    }

    @Override
    public Subscription addSubscription(Subscription b)  {
        return SubscriptionRepository.save(b);
    }

    @Override
    public Subscription updateSubscription(Subscription b) {
        return SubscriptionRepository.save(b);
    }


    @Override
    public void deleteSubscription(Long SubscriptionId) {
        SubscriptionRepository.deleteById(SubscriptionId);
    }

    @Override
    public Subscription getSubscription(Long SubscriptionId) {
        Subscription b = SubscriptionRepository.findById(SubscriptionId).orElse(null);
        return b;
    }



}
