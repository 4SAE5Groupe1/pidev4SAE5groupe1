package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService implements SubscriptionDAO {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = (List<Subscription>) subscriptionRepository.findAll();
        return subscriptions;
    }

    @Override
    public Subscription getSubscription(int subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElse(null);
        return subscription;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(int subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }
}
