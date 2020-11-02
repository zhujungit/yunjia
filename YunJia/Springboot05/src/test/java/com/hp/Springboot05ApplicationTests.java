package com.hp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot05ApplicationTests {
@Autowired
private UsersMapper usersMapper;

    @Test
    void test1() {
        //执行分页，pageNum： 当前页 ， pageSize ：每页显示数据条数
        PageHelper.startPage(1, 5);
        //调用通用mapper查询所有数据
        List<Users> users = usersMapper.selectAll();
        System.out.println("users"+users);
        Page page=(Page) users;
        System.out.println("page"+page);
        //查询结果集封装到pageInfo对象中

        PageInfo<Users> pageInfo = new PageInfo<>(users);
        //输出pageInfo
        System.out.println("pageInfo:"+pageInfo);
    }

}
