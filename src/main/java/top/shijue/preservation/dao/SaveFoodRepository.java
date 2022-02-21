package top.shijue.preservation.dao;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午4:44
 * @Description: TODO 保存食物
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import top.shijue.preservation.pojo.Food;

import java.util.List;

public interface SaveFoodRepository extends JpaRepository<Food, Long>, JpaSpecificationExecutor<Food> {
    @Query("select f from Food f where f.name like CONCAT('%',?1,'%')")
    List<Food> foodByNameFind(String name);
}
