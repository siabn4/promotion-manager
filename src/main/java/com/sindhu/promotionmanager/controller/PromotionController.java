package com.sindhu.promotionmanager.controller;


import com.sindhu.promotionmanager.model.Promotion;
import com.sindhu.promotionmanager.model.User;
import com.sindhu.promotionmanager.service.PromotionService;
import com.sindhu.promotionmanager.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;
    private final UserRepository userRepository;

    public PromotionController(PromotionService promotionService, UserRepository userRepository) {

        this.promotionService = promotionService;
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<Promotion> getAllPromotions(){
        return promotionService.getAllPromotions();
    }

    @GetMapping("/{id}")
    public Promotion getPromotionById(@PathVariable Long id){
        return promotionService.getPromotionById(id);
    }

    @PutMapping("/{id}")
    public Promotion updatePromotion(
            @PathVariable Long id,
            @RequestBody Promotion promotion){

        return promotionService.updatePromotion(id, promotion);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id){
        promotionService.deletePromotion(id);
    }

    @PostMapping
    public Promotion createPromotion(@RequestBody Promotion promotion){
        return promotionService.createPromotion(promotion);
    }

    @GetMapping("/users/{userId}/promotions")
    public List<Promotion> getUserPromotions(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        return promotionService.getUserPromotions(user);
    }


}
