package misproject.pojo;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 数据表user的实体类
 */
public class User {
    private int id;
    private String name;
    private String sex;
    private String jianjie;
    private Date ruzhiriqi;
    public User() {
        super();
    }
    public User(String name, String sex, String jianjie, Date ruzhiriqi) {
        super();
        this.name = name;
        this.sex = sex;
        this.jianjie = jianjie;
        this.ruzhiriqi = ruzhiriqi;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getjianjie() {
        return jianjie;
    }
    public void setjianjie(String jianjie) {
        this.jianjie = jianjie;
    }
    public Date getruzhiriqi() {
        return ruzhiriqi;
    }
    public void setruzhiriqi(Date ruzhiriqi) {
        this.ruzhiriqi = ruzhiriqi;
    }
    public void setruzhiriqi(String ruzhiriqi) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        try {
            date = format.parse(ruzhiriqi);
            this.ruzhiriqi=new Date(date.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.ruzhiriqi=null;
        }

    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", jianjie=" + jianjie + ", ruzhiriqi=" + ruzhiriqi
                + "]";
    }
}