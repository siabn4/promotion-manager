package com.sindhu.promotionmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sindhu.promotionmanager.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}
