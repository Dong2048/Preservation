package top.shijue.preservation.dao;/*
 * @Author: Dong
 * @DateTime: 2022/2/18 下午3:26
 * @Description: TODO 食物保质期字典表
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import top.shijue.preservation.pojo.Food;
import top.shijue.preservation.pojo.ShelfLife;

import java.util.List;

public interface ShelfLifeRepository extends JpaRepository<ShelfLife, Long>, JpaSpecificationExecutor<ShelfLife> {
    @Query("select f from Food f where f.name =?1")
    ShelfLife foodByNameFind(String name);
}
