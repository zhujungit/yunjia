package com.hp.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.DistrictMapper;
import com.hp.mapper.HouseMapper;
import com.hp.mapper.TypeMapper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.District;
import com.hp.pojo.House;
import com.hp.pojo.HouseType;
import com.hp.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController{
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @RequestMapping("/streets")
    @ResponseBody//支持异步请求，不做跳转
    public List<District> streets(Integer did){

  return districtMapper.getDisByParentId(did);
    }

    @RequestMapping("/add")
    //形参house  表示可以一次行接收整个form标签中所有的属性值，并把他们封装在house对象中
    public String add(House house){
        System.out.println(house);
        return "admin/admin";
    }



    @RequestMapping("/addPage")
    public String addHousePage(Model model){
        //查询出所有的用户信息
        List<Users> users = usersMapper.selectLandlord();
        //2.查询出所有的类型信息
        List<HouseType> types = typeMapper.selectAll();
        //3.查询出所有的区域信息:城区 (和 街道)
        List<District> districts = districtMapper.getDisByParentId(1);
        //4.上述集合存入model
        model.addAttribute("users",users);
        model.addAttribute("types",types);
        model.addAttribute("districts",districts);
//        System.out.println(districts);
        //5.跳转到新增页面
        return "admin/house/add_house";
    }









    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize){
        //1.分页
        PageHelper.startPage(pageNo,pageSize);
        //2.查询
        List<House> houses = houseMapper.selectAll();
        System.out.println(houses);
        //3.封装pageInfo
        PageInfo<House> houseInfo = (PageInfo<House>) new PageInfo<>(houses);
        System.out.println(houseInfo);
        //4.存model
        model.addAttribute("houseInfo",houseInfo);
        //5.跳转showHouse.html
        return "admin/house/houseShow";
    }
}