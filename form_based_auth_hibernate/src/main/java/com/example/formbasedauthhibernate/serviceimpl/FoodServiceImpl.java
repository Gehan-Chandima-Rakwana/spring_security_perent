package com.example.formbasedauthhibernate.serviceimpl;

import com.example.formbasedauthhibernate.entity.Food;
import com.example.formbasedauthhibernate.exception.ItemNotFoundException;
import com.example.formbasedauthhibernate.repository.FoodRepository;
import com.example.formbasedauthhibernate.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    /***
     *
     * @return
     * @throws ItemNotFoundException
     */
    @Override
    public List<Food> findAll() throws ItemNotFoundException {
        try {
            return foodRepository.findAll();
        }catch (Exception e){
            throw new ItemNotFoundException("Items Not In List");
        }
    }

    /***
     *
     * @param food
     * @return
     */
    @Override
    public Food addNewFood(Food food) {
        try {
            return foodRepository.save(food);
        } catch (Exception e) {
            throw new RuntimeException("Not Success");
        }
    }

    /***
     *
     * @param id
     * @return
     * @throws ItemNotFoundException
     */
    @Override
    public Optional<Food> findByID(Long id) throws ItemNotFoundException {
            try {
                return foodRepository.findById(id);
            }catch (Exception e){
                throw new ItemNotFoundException("Items Not In List");
            }
    }

    /***
     *
     * @param id
     * @param food
     * @return
     */
    @Override
    public Food updateFood(Long id, Food food) {
        boolean result = foodRepository.existsById(id);
        if (result)
            return foodRepository.save(food);
        return food;
    }

    /***
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteFood(Long id) {
        boolean result = foodRepository.existsById(id);
        if (result){
            foodRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
