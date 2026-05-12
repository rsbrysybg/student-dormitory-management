package misproject.dao;

import misproject.pojo.JXUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * 对JXUser表的浏览、查询、添加、修改、删除操作
 */
public class JXUserDao {
    /**
     * 对JXUser表的浏览操作
     */
    public static List<JXUser> allJXUsers() {
        List<JXUser> JXUsers=new ArrayList<JXUser>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from xeusheng";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                JXUser JXUser=new JXUser();
                JXUser.setId(rs.getInt("id"));
                JXUser.setName(rs.getString("name"));
                JXUser.setsex(rs.getString("sex"));
                JXUser.setsusheqingkuang(rs.getString("susheqingkuang"));
                JXUser.setruxiaoriqi(rs.getDate("ruxiaoriqi"));
                JXUsers.add(JXUser);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return JXUsers;
    }
    /**
     * 对JXUser表的查询操作，按照name值查询
     */
    public static List<JXUser> queryJXUsersByName(String name) {
        List<JXUser> JXUsers=new ArrayList<JXUser>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from xeusheng where name like '%"+name+"%'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                JXUser JXUser=new JXUser();
                JXUser.setId(rs.getInt("id"));
                JXUser.setName(rs.getString("name"));
                JXUser.setsex(rs.getString("sex"));
                JXUser.setsusheqingkuang(rs.getString("susheqingkuang"));
                JXUser.setruxiaoriqi(rs.getDate("ruxiaoriqi"));
                JXUsers.add(JXUser);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return JXUsers;
    }
    /**
     * 对JXUser表的查询操作，按照name和sex值查询
     */
    public static List<JXUser> queryJXUsersByNameAndsex(String name,String sex) {
        List<JXUser> JXUsers=new ArrayList<JXUser>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from xeusheng where name like '%"+name+"%' and sex='"+sex+"'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                JXUser JXUser=new JXUser();
                JXUser.setId(rs.getInt("id"));
                JXUser.setName(rs.getString("name"));
                JXUser.setsex(rs.getString("sex"));
                JXUser.setsusheqingkuang(rs.getString("susheqingkuang"));
                JXUser.setruxiaoriqi(rs.getDate("ruxiaoriqi"));
                JXUsers.add(JXUser);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return JXUsers;
    }
    /**
     * 对JXUser表的添加操作
     */
    public static int insertJXUser(JXUser JXUser) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql = "insert into xeusheng(name,sex,susheqingkuang,ruxiaoriqi) values (?,?,?,?)";
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, JXUser.getName());
            pStatement.setString(2,JXUser.getsex());
            pStatement.setString(3, JXUser.getsusheqingkuang());
            pStatement.setDate(4, JXUser.getruxiaoriqi());
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
     * 对JXUser表的修改操作
     */
    public static int updateJXUser(JXUser JXUser) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="update xeusheng set name=?,sex=?,susheqingkuang=?,ruxiaoriqi=? where id=?";
            System.out.println(sql);
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, JXUser.getName());
            pStatement.setString(2,JXUser.getsex());
            pStatement.setString(3, JXUser.getsusheqingkuang());
            pStatement.setDate(4, JXUser.getruxiaoriqi());
            pStatement.setInt(5, JXUser.getId());
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
     * 对JXUser表的删除操作
     */
    public static int deleteJXUserById(int id) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="delete from xeusheng where id="+id;
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
