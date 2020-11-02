package com.hp.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.DistrictMapper;
import com.hp.mapper.HouseMapper;
import com.hp.mapper.TypeMapper;
import com.hp.pojo.District;
import com.hp.pojo.House;
import com.hp.pojo.HouseType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
 private DistrictMapper districtMapper;
@Autowired
private TypeMapper typeMapper;
@Autowired
protected HouseMapper houseMapper;
    @RequestMapping("/list")

    public String homelist(Model model){
        List<District> districts = districtMapper.getDisByParentId(1);
        List<HouseType> types = typeMapper.selectAll();
        model.addAttribute("districts",districts);
        model.addAttribute("types",types);
        return "front/home_list";

    }

    @RequestMapping("/showHmeList")
    @ResponseBody//处理异步请求
    public PageInfo<House> showHomeList(
      @RequestParam(defaultValue = "1") Integer pageNum,
      @RequestParam(defaultValue = "8") Integer pageSize,
      String district_id,String price,String area,String type_id){
        System.out.println(district_id+"--"+price+"--"+area+"--"+type_id);
//装到map中

        HashMap<String, String> condition = new HashMap<>();
        condition.put("district_id",district_id);
        condition.put("type_id",type_id);

        if (price!=null){
            String [] arr_price=price.split("-");
            String min_price=arr_price[0];
            String max_price=arr_price[1];
            condition.put("min_price",min_price);
            condition.put("max_price",max_price);
        }
        if (area!=null){
            String [] arr_area=area.split("-");
            String min_area=arr_area[0];
            String max_area=arr_area[1];
            condition.put("min_area",min_area);
            condition.put("max_area",max_area);
        }
        //分页
        PageHelper.startPage(pageNum,pageSize);
         //查询
List<House> houses= houseMapper.selectByCondition(condition);
    //封装到pageInfo
        return new PageInfo<House>(houses);

    }

}
