package tn.esprit.spring.DAO;

import com.google.zxing.WriterException;
import tn.esprit.spring.entities.Badge;

import java.io.IOException;
import java.util.List;

public interface BadgeDAO {
    public List<Badge> getAllBadges();
    public Badge addBadge(Badge b) throws IOException, WriterException;
    public Badge updateBadge(Badge b);
    public void  deleteBadge (int badgeId);
    public Badge getBadge(int badgeId);
}
