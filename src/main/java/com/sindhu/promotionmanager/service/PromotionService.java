package com.sindhu.promotionmanager.service;

import com.sindhu.promotionmanager.model.Promotion;
import com.sindhu.promotionmanager.model.User;
import com.sindhu.promotionmanager.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public Promotion updatePromotion(Long id, Promotion updatedPromotion) {
        Promotion existingPromotion = promotionRepository.findById(id).orElse(null);

        if (existingPromotion != null) {
            existingPromotion.setTitle(updatedPromotion.getTitle());
            existingPromotion.setStore(updatedPromotion.getStore());
            existingPromotion.setCouponCode(updatedPromotion.getCouponCode());
            existingPromotion.setCategory(updatedPromotion.getCategory());
            existingPromotion.setDescription(updatedPromotion.getDescription());
            existingPromotion.setUsed(updatedPromotion.getUsed());

            return promotionRepository.save(existingPromotion);
        }

        return null;
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }

    public List<Promotion> getUserPromotions(User user){
        return promotionRepository.findByUser(user);
    }
}
