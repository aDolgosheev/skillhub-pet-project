package com.dolgosheev.skillhubpetproject.service;

import com.dolgosheev.skillhubpetproject.model.Achievement;
import com.dolgosheev.skillhubpetproject.model.User;
import com.dolgosheev.skillhubpetproject.repository.AchievementRepository;
import com.dolgosheev.skillhubpetproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;
    private final UserRepository userRepository;

    public AchievementService(AchievementRepository achievementRepository, UserRepository userRepository) {
        this.achievementRepository = achievementRepository;
        this.userRepository = userRepository;
    }

    public void awardAchievement(Long userId, String achievementName, String description) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Achievement achievement = new Achievement();
        achievement.setName(achievementName);
        achievement.setDescription(description);
        achievement.setUser(user);
        achievement.setAchievedAt(LocalDateTime.now());
        achievementRepository.save(achievement);

//        // Пример обновления уровня пользователя
//        user.setLevel(user.getLevel() + 1);
//        userRepository.save(user);
    }
}
