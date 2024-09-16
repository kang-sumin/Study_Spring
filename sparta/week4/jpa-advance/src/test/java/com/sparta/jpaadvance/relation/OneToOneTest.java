package com.sparta.jpaadvance.relation;

import com.sparta.jpaadvance.entity.Food;
import com.sparta.jpaadvance.entity.User;
import com.sparta.jpaadvance.repository.FoodRepository;
import com.sparta.jpaadvance.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class OneToOneTest {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(value = false) // 테스트에서 @Transactional에 의해 자동으로 rollback 되어 확인 불가하기 때문에 false 설정해줌
    @DisplayName("1대1 단방향 테스트")
    void test1(){

        // given
        User user = new User();
        user.setName("Robbie");

        Food food = new Food(); // 외래 키의 주인인 Food Entity에 user 필드에 user 객체를 추가
        food.setName("후라이드 치킨");
        food.setPrice(15000);
        food.setUser(user); // 외래 키(연관관계) 설정

        // when-then
        userRepository.save(user);
        foodRepository.save(food);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("1대1 양방향 테스트 : 외래 키 저장 실패")
    void test2() {
        // given
        Food food = new Food();
        food.setName("고구마 피자");
        food.setPrice(30000);

        // 외래 키의 주인이 아닌 User 에서 Food 를 저장해보겠습니다.
        User user = new User();
        user.setName("Robbie");
        user.setFood(food);

        // when-then
        userRepository.save(user);
        foodRepository.save(food);

        // 확인해 보시면 user_id 값이 들어가 있지 않은 것을 확인하실 수 있습니다.
    }

    @Test
    @Rollback(value = false)
    @DisplayName("1대1 양방향 테스트 : 외래 키 저장 실패 -> 성공")
    void test3() {
        // given
        Food food = new Food();
        food.setName("고구마 피자");
        food.setPrice(30000);

        // 외래 키의 주인이 아닌 User 에서 Food 를 저장하기 위해 addFood() 메서드 추가
        // 외래 키(연관 관계) 설정 food.setUser(this); 추가
        User user = new User();
        user.setName("Robbie");
        user.addFood(food);

        //when-then
        userRepository.save(user);
        foodRepository.save(food);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("1대1 양방향 테스트")
    void test4() {

        // given
        User user = new User();
        user.setName("Robbert");

        Food food = new Food();
        food.setName("고구마 피자");
        food.setPrice(30000);
        food.setUser(user); // 외래 키(연관 관계) 설정

        // when-then
        userRepository.save(user);
        foodRepository.save(food);
    }

}
