package top.shijue.preservation.service;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午5:21
 * @Description: TODO 食物字典表
 */

import top.shijue.preservation.pojo.Food;
import top.shijue.preservation.pojo.ShelfLife;

public interface ShelfLifeService {

    ShelfLife shelfLifeSave(ShelfLife shelfLife);
    ShelfLife foodByNameFind(String name);
}
