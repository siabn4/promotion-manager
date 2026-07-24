package com.sindhu.promotionmanager.repository;
import com.sindhu.promotionmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sindhu.promotionmanager.model.Promotion;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByUser(User user);
}
