package top.shijue.preservation.service.impl;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午4:42
 * @Description: TODO 保存食物
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shijue.preservation.dao.SaveFoodRepository;
import top.shijue.preservation.pojo.Food;
import top.shijue.preservation.service.SaveFoodService;

import java.util.List;

@Service
public class SaveFoodServiceImpl implements SaveFoodService {
    @Autowired
    private SaveFoodRepository saveFoodRepository;
    @Override
    public Food foodSave(Food food) {
        return saveFoodRepository.save(food);
    }


    @Override
    public List<Food> findAll() {
        return saveFoodRepository.findAll();
    }

    @Override
    public List<Food> foodByNameFind(String name) {
        return saveFoodRepository.foodByNameFind(name);
    }

}
