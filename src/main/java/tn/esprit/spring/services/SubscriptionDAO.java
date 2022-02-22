package tn.esprit.spring.services;

import tn.esprit.spring.entities.Subscription;

import java.util.List;

public interface SubscriptionDAO {
    public List<Subscription> getAllSubscriptions();
    public Subscription getSubscription(int subscriptionId);
    public Subscription addSubscription(Subscription subscription);
    public Subscription updateSubscription(Subscription subscription);
    public void deleteSubscription(int subscriptionId);
}
