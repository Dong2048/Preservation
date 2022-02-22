package top.shijue.preservation.web;/*
 * @Author: Dong
 * @DateTime: 2022/2/16 下午4:16
 * @Description: TODO 保存食物
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shijue.preservation.pojo.Food;
import top.shijue.preservation.pojo.ShelfLife;
import top.shijue.preservation.service.SaveFoodService;
import top.shijue.preservation.service.ShelfLifeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class SaveFoodController {

    @Autowired
    private SaveFoodService saveFoodService;
    @Autowired
    private ShelfLifeService shelfLifeService;
    /**
     *siri调用保存食物
     * parameter：食物名称
     */
    @GetMapping("/FoodSave")
    public String foodSave(String name){
      try{
          Food food=new Food();
          food.setName(name);
          food.setStartTime(new Date());
         ShelfLife shelfLife= shelfLifeService.foodByNameFind(name);
         if(null==shelfLife){
             return null;
         } else{
             food.setRemainingShelfLife(shelfLife.getShelfLife());
         }
          saveFoodService.foodSave(food);
      }catch (Exception e){
          return "记录没有成功，请联系系统管理员";
      }
        return name+"已经记录完成，接近保质期时间会及时提醒您";
    }
    /**
     *siri调用查询所有食物
     */
    @GetMapping("/FoodFind")
    public String foodFind(){
        try{
            String result="";
            List<Food> list=saveFoodService.findAll();
            for (Food food : list) {
                result+="您记录的食物有"+food.getName()+",购买日期是"+new SimpleDateFormat("yyyy年MM月dd号， ahh:mm").format(food.getStartTime())+"，保质期是"+food.getShelfLife()+"天。预计"+food.getRemainingShelfLife()+"天后过期。/n";
            }
            return result;
        }catch (Exception e){
            return "没有查询成功，请联系系统管理员";
        }
    }
    /**
     *siri调用查询食物保质期
     * parameter：食物名称
     */
    @GetMapping("/foodFindName")
    public String foodFindName(String name){
        String result="";
        try{
            List<Food> list=saveFoodService.foodByNameFind(name);
            if(null==list){
                result="没有找到您需要的食物，请尝试让siri查询食物清单";
            }
            for (Food food : list) {
                result+="您记录的食物有"+food.getName()+",购买日期是"+new SimpleDateFormat("yyyy年MM月dd号， ahh:mm").format(food.getStartTime())+"，保质期是"+food.getShelfLife()+"天。预计"+food.getRemainingShelfLife()+"天后过期。/n";
            }
            return result;
        }catch (Exception e){
            return "没有查询成功，请联系系统管理员";
        }
    }
    /**
     *siri添加新的食物保质期清单
     * parameter：食物名称
     */
    @GetMapping("/shelfLifeListFind")
    public String shelfLifeListFind(String name,Long day){
        try {
            ShelfLife shelfLife = new ShelfLife();
            shelfLife.setName(name);
            shelfLife.setShelfLife(day);
            shelfLifeService.shelfLifeSave(shelfLife);
        } catch (Exception e) {
            return "添加新的食物保质期清单没有成功，请联系系统管理员";
        }
        return name + "添加食物字典表成功";
    }

    /**
     * siri快要过期的食物
     */
    @GetMapping("/overdueFoodFind")
    public String overdueFoodFind() {
        try {
            String result0 = "";
            String result3 = "";
            String result7 = "";
            String result30 = "";
            List<Food> list = saveFoodService.findAll();
            for (Food food : list) {
                if (food.getRemainingShelfLife() <= 3) {
                    result3 += food.getName() + ",剩余保质期：" + food.getRemainingShelfLife() + "天，";
                } else if (food.getRemainingShelfLife() <= 7 && food.getRemainingShelfLife() >= 3) {
                    result7 += food.getName() + ",剩余保质期：" + food.getRemainingShelfLife() + "天，";
                } else if (food.getRemainingShelfLife() <= 0) {
                    result0 += food.getName() + ",过期：" + Math.abs(food.getRemainingShelfLife()) + "天，";
                } else {
                    result30 += food.getName() + ",剩余保质期：" + food.getRemainingShelfLife() + "天，";
                }
            }

            return "保质期剩余三天的食物有：" + result3 + "请尽快食用，保质期剩余七天的食物有：" + result7 + "保质期七天以上的食物有：" + result30 + "过期的食物有：" + result0 + "过期食物帮您保留记录一周，请您尽快处理掉，防止误食。";
        } catch (Exception e) {
            return "没有查询成功，请联系系统管理员";
        }
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void calculateShelfLife() {
        List<Food> list = saveFoodService.findAll();
        for (Food food : list) {
            food.setRemainingShelfLife(food.getRemainingShelfLife() - 1);
            saveFoodService.foodSave(food);
        }
    }
}
