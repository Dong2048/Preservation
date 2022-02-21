package top.shijue.preservation.service.impl;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午5:17
 * @Description: TODO 食物保质期字典表
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shijue.preservation.dao.ShelfLifeRepository;
import top.shijue.preservation.pojo.Food;
import top.shijue.preservation.pojo.ShelfLife;
import top.shijue.preservation.service.SaveFoodService;
import top.shijue.preservation.service.ShelfLifeService;

import java.util.List;
@Service
public class ShelfLifeServiceImpl implements ShelfLifeService {

    @Autowired
    private ShelfLifeRepository shelfLifeRepository;
    @Override
    public ShelfLife shelfLifeSave(ShelfLife shelfLife) {
        return shelfLifeRepository.save(shelfLife);
    }

    @Override
    public ShelfLife foodByNameFind(String name) {
        return shelfLifeRepository.foodByNameFind(name);
    }


}
