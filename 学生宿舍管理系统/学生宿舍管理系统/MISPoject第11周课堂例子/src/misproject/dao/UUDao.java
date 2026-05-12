package misproject.dao;

import misproject.pojo.UU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * 对UU表的浏览、查询、添加、修改、删除操作
 */
public class UUDao {
    /**
     * 对UU表的浏览操作
     */
    public static List<UU> allUUs() {
        List<UU> UUs=new ArrayList<UU>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from daoyuan";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                UU UU=new UU();
                UU.setId(rs.getInt("id"));
                UU.setName(rs.getString("name"));
                UU.setsex(rs.getString("sex"));
                UU.setguanlisushe(rs.getString("guanlisushe"));
                UU.setruzhiriqi(rs.getDate("ruzhiriqi"));
                UUs.add(UU);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return UUs;
    }
    /**
     * 对UU表的查询操作，按照name值查询
     */
    public static List<UU> queryUUsByName(String name) {
        List<UU> UUs=new ArrayList<UU>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from daoyuan where name like '%"+name+"%'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                UU UU=new UU();
                UU.setId(rs.getInt("id"));
                UU.setName(rs.getString("name"));
                UU.setsex(rs.getString("sex"));
                UU.setguanlisushe(rs.getString("guanlisushe"));
                UU.setruzhiriqi(rs.getDate("ruzhiriqi"));
                UUs.add(UU);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return UUs;
    }
    /**
     * 对UU表的查询操作，按照name和sex值查询
     */
    public static List<UU> queryUUsByNameAndsex(String name,String sex) {
        List<UU> UUs=new ArrayList<UU>();
        JDBC jdbc=new JDBC();
        try {
            jdbc.startConnection();
            String sql = "select * from daoyuan where name like '%"+name+"%' and sex='"+sex+"'";
            ResultSet rs=jdbc.query(sql);
            while(rs.next()) {
                UU UU=new UU();
                UU.setId(rs.getInt("id"));
                UU.setName(rs.getString("name"));
                UU.setsex(rs.getString("sex"));
                UU.setguanlisushe(rs.getString("guanlisushe"));
                UU.setruzhiriqi(rs.getDate("ruzhiriqi"));
                UUs.add(UU);
            }
            rs.close();
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return UUs;
    }
    /**
     * 对UU表的添加操作
     */
    public static int insertUU(UU UU) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql = "insert into daoyuan(name,sex,guanlisushe,ruzhiriqi) values (?,?,?,?)";
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, UU.getName());
            pStatement.setString(2,UU.getsex());
            pStatement.setString(3, UU.getguanlisushe());
            pStatement.setDate(4, UU.getruzhiriqi());
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
     * 对UU表的修改操作
     */
    public static int updateUU(UU UU) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="update daoyuan set name=?,sex=?,guanlisushe=?,ruzhiriqi=? where id=?";
            System.out.println(sql);
            Connection connection=jdbc.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(sql);
            pStatement.setString(1, UU.getName());
            pStatement.setString(2,UU.getsex());
            pStatement.setString(3, UU.getguanlisushe());
            pStatement.setDate(4, UU.getruzhiriqi());
            pStatement.setInt(5, UU.getId());
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
     * 对UU表的删除操作
     */
    public static int deleteUUById(int id) {
        JDBC jdbc=new JDBC();
        int result=0;
        try {
            jdbc.startConnection();
            String sql="delete from daoyuan where id="+id;
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
