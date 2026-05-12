package misproject.pojo;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 数据表user的实体类
 */
public class UU {
    private int id;
    private String name;
    private String sex;
    private String guanlisushe;
    private Date ruzhiriqi;
    public UU() {
        super();
    }
    public UU(String name, String sex, String guanlisushe, Date ruzhiriqi) {
        super();
        this.name = name;
        this.sex = sex;
        this.guanlisushe = guanlisushe;
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
    public String getsex() {
        return sex;
    }
    public void setsex(String sex) {
        this.sex = sex;
    }
    public String getguanlisushe() {
        return guanlisushe;
    }
    public void setguanlisushe(String guanlisushe) {
        this.guanlisushe = guanlisushe;
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
        return "UU [id=" + id + ", name=" + name + ", sex=" + sex + ", guanlisushe=" + guanlisushe + ", ruzhiriqi=" + ruzhiriqi
                + "]";
    }
}