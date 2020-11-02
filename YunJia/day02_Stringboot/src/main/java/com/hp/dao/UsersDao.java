package com.hp.dao;

import com.hp.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UsersDao {

    @Autowired
    private DataSource dataSource;

    public List<Users> getUsers() throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement pstm = con.prepareStatement("select *from users");
        ResultSet rs = pstm.executeQuery();
        ArrayList<Users> list = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            Users users = new Users(id, username, password);
            list.add(users);

        }
        return list;
    }

    public Users getUserById(int uid) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement pstm = con.prepareStatement("select *from users where id=?");
        pstm.setInt(1, uid);
        ResultSet rs = pstm.executeQuery();

        Users users = null;

        if (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            users = new Users(id, username, password);
        }
        return users;
    }
}