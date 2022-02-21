package top.shijue.preservation.pojo;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午5:16
 * @Description: TODO 食物保质期字典表
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_shelfLife")
public class ShelfLife {
    @Id
    @GeneratedValue
    private Long id;
    //食物名称
    private String name;
    //保质期
    private Long shelfLife;
}
