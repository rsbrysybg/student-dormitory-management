package misproject.pojo;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 数据表user的实体类
 */
public class JXUser {
    private int id;
    private String name;
    private String sex;
    private String susheqingkuang;
    private Date ruxiaoriqi;
    public JXUser() {
        super();
    }
    public JXUser(String name, String sex, String susheqingkuang, Date ruxiaoriqi) {
        super();
        this.name = name;
        this.sex = sex;
        this.susheqingkuang = susheqingkuang;
        this.ruxiaoriqi = ruxiaoriqi;
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
    public String getsex() {
        return sex;
    }
    public void setsex(String sex) {
        this.sex = sex;
    }
    public String getsusheqingkuang() {
        return susheqingkuang;
    }
    public void setsusheqingkuang(String susheqingkuang) {
        this.susheqingkuang = susheqingkuang;
    }
    public Date getruxiaoriqi() {
        return ruxiaoriqi;
    }
    public void setruxiaoriqi(Date ruxiaoriqi) {
        this.ruxiaoriqi = ruxiaoriqi;
    }
    public void setruxiaoriqi(String ruxiaoriqi) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        try {
            date = format.parse(ruxiaoriqi);
            this.ruxiaoriqi=new Date(date.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.ruxiaoriqi=null;
        }

    }
    @Override
    public String toString() {
        return "JXUser [id=" + id + ", name=" + name + ", sex=" + sex + ", susheqingkuang=" + susheqingkuang + ", ruxiaoriqi=" + ruxiaoriqi
                + "]";
    }
}