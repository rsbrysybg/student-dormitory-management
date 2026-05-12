package misproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misproject.pojo.User;


/**
 * 对user表的浏览、查询、添加、修改、删除操作
 */
public class UserDao {
    /**
     * 对user表的浏览操作
     */
    public static List<User> allUsers() {
        List<User> users=new ArrayList<User>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from zg";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setjianjie(rs.getString("jianjie"));
                user.setruzhiriqi(rs.getDate("ruzhiriqi"));
                users.add(user);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return users;
    }
    /**
     * 对user表的查询操作，按照name值查询
     */
    public static List<User> queryUsersByName(String name) {
        List<User> users=new ArrayList<User>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from  zg where name like '%"+name+"%'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setjianjie(rs.getString("jianjie"));
                user.setruzhiriqi(rs.getDate("ruzhiriqi"));
                users.add(user);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return users;
    }
    /**
     * 对user表的查询操作，按照name和sex值查询
     */
    public static List<User> queryUsersByNameAndSex(String name,String sex) {
        List<User> users=new ArrayList<User>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from zg where name like '%"+name+"%' and sex='"+sex+"'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setjianjie(rs.getString("jianjie"));
                user.setruzhiriqi(rs.getDate("ruzhiriqi"));
                users.add(user);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return users;
    }
    /**
     * 对user表的查询操作，按照id值查询
     */
    public static User queryUsersById(int id) {
        JDBC jdbc=new JDBC();
        User user=null;
        try {
            jdbc.startConnection();
            String sql = "select * from zg where id="+id;
            ResultSet rs=jdbc.query(sql);
            if(rs.next()) {
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setjianjie(rs.getString("jianjie"));
                user.setruzhiriqi(rs.getDate("ruzhiriqi"));
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return user;
    }
    /**
     * 对user表的添加操作
     */
    public static int insertuser(User user) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql = "insert into zg(name,sex,jianjie,ruzhiriqi) values (?,?,?,?)";
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, user.getName());
            pStatement.setString(2,user.getSex());
            pStatement.setString(3, user.getjianjie());
            pStatement.setDate(4, user.getruzhiriqi());
            System.out.println(sql);
            result=pStatement.executeUpdate();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        return result;
    }
    /**
     * 对user表的修改操作
     */
    public static int updateUserjianjie(String jianjie,int id) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="update zg set jianjie='"+jianjie+"' where id="+id;
            System.out.println(sql);
            result=jdbc.update(sql);
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        return result;
    }
    /**
     * 对user表的修改操作
     */
    public static int updateUser(User user) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="update zg set name=?,sex=?,jianjie=?,ruzhiriqi=? where id=?";
            System.out.println(sql);
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, user.getName());
            pStatement.setString(2,user.getSex());
            pStatement.setString(3, user.getjianjie());
            pStatement.setDate(4, user.getruzhiriqi());
            pStatement.setInt(5, user.getId());
            System.out.println(sql);
            result=pStatement.executeUpdate();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        return result;
    }
    /**
     * 对user表的删除操作
     */
    public static int deleteUserById(int id) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="delete from zg where id="+id;
            System.out.println(sql);
            result=jdbc.update(sql);
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        return result;
    }
}
