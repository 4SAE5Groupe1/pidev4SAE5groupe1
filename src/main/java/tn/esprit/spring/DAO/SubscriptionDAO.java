package tn.esprit.spring.DAO;

import com.google.zxing.WriterException;
import tn.esprit.spring.entites.Subscription;

import java.io.IOException;
import java.util.List;

public interface SubscriptionDAO {
    public List<Subscription> getAllSubscriptions();
    public Subscription addSubscription(Subscription b) throws IOException, WriterException;
    public Subscription updateSubscription(Subscription b);
    public void  deleteSubscription (Long SubscriptionId);
    public Subscription getSubscription(Long SubscriptionId);
}
