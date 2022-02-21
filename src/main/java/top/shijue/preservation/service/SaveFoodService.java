package top.shijue.preservation.service;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午4:25
 * @Description: TODO 保存食物接口
 */

import top.shijue.preservation.pojo.Food;

import java.util.List;

public interface SaveFoodService {

    Food foodSave(Food food);
    List<Food> findAll();
    List<Food> foodByNameFind(String name);
}
