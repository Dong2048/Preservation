package top.shijue.preservation.pojo;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午4:29
 * @Description: TODO 食物类
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "t_food")
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    //食物名称
    private String name;
    //保质期
    private Long shelfLife;
    //剩余保质期时间
    private Long RemainingShelfLife;
    //开始时间
    Date startTime;
    //结束时间
    Date endTime;
}
