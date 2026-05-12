package misproject.dao;


import java.sql.ResultSet;

import misproject.pojo.LoginUser;


public class LoginUserDao {
    public static LoginUser login1(String account,String pwd,String role) {
        JDBC jdbc=new JDBC();
        LoginUser loginUser=null;
        try {
            jdbc.startConnection();
            String sql="select * from User where name=" + "'" + account + "' and pas=" + "'" + pwd + "' and role=" + "'" + role + "'" ;
            ResultSet rs=jdbc.query(sql);

            if(rs.next()) {
                loginUser=new LoginUser();
                loginUser.setName(rs.getString("name"));
            }
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loginUser;
    }
    public static LoginUser login2(String account,String pwd,String role) {
        JDBC jdbc=new JDBC();
        LoginUser loginUser=null;
        try {
            jdbc.startConnection();
            String sql="select * from User where name=" + "'" + account + "' and pas=" + "'" + pwd + "' and role=" + "'" + role + "'" ;

            ResultSet rs=jdbc.query(sql);

            if(rs.next()) {
                loginUser=new LoginUser();
                loginUser.setName(rs.getString("name"));
            }
            jdbc.stopConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loginUser;
    }
}
