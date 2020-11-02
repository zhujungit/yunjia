package com.hp.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.DistrictMapper;
import com.hp.mapper.HouseMapper;
import com.hp.mapper.TypeMapper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.District;
import com.hp.pojo.House;
import com.hp.pojo.Type;
import com.hp.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private TypeMapper typeMapper;


    @RequestMapping("/streets")
    @ResponseBody//支持异步请求，不作页面跳转，该方法的返回值会赋值给页面中回调函数的参数
    public  List<District> streets(Integer did){
        //根据区域id查询对应的街道信息
       return  districtMapper.getDisByParentId(did);
    }

    //执行房源数据新增
    @RequestMapping("/add")
    //形参house，表示可以一次性接收整个form标签中所有的属性值，并把它们封装到house对象中
    public String add(House house){
        System.out.println(house);
        houseMapper.addHouse(house);
        return "admin/admin";
    }

    //跳转到新增页面
    @RequestMapping("/addPage")
    public String addPage(Model model){
        //1.查询所有房东信息
        List<Users> users = usersMapper.selectLandlord();
        //2.查询区域信息
        List<District> districts = districtMapper.getDisByParentId(1);
        //3.查询房型
        List<Type> types = typeMapper.selectAll();
        //4.上述结果集存进model中
        model.addAttribute("users",users);
        model.addAttribute("districts",districts);
        model.addAttribute("types",types);
        //5.跳转到新增页面
        return "admin/house/add_house";
    }

    //分页查询房源信息--同步
    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1")Integer pageNo,
                       @RequestParam(defaultValue = "3")Integer pageSize){
        //1.开始分页
        PageHelper.startPage(pageNo,pageSize);
        //2.mapper查询所有
        List<House> houses=houseMapper.selectAll();
        //3.封装到pageInfo
        PageInfo<House> houseInfo = new PageInfo<>(houses);
        System.out.println(houseInfo);

        //4.存到model中
        model.addAttribute("houseInfo",houseInfo);
        //5.页面跳转
        return "admin/house/show_house";
    }


}
