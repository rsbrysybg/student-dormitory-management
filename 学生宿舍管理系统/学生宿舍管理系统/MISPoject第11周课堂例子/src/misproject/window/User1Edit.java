/*
 * Created by JFormDesigner on Mon Apr 29 11:42:25 CST 2024
 */

package misproject.window;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import misproject.dao.UUDao;
import misproject.pojo.UU;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author Administrator
 */
public class User1Edit extends JDialog {
    public static void main(String[] args) {
        new User1Edit();
    }
    public User1Edit() {
        super();
        initComponents();
        initTable();
    }
    public User1Edit(Window owner) {
        super(owner);
        initComponents();
        initTable();
    }
    /**
     * 为table对象中选中一行添加事件，在table中显示tb_UU表所有记录。
     * 调用UUDao.allUUs()查询tb_UU表所有记录
     * 然后调用setTableData()将结果转换为二维数组tableData，在table中显示
     */
    private void initTable(){
        //为table对象中选中一行添加事件
        table1.getSelectionModel().addListSelectionListener(e -> valueChanged(e));
        //调用UUDao.allUUs()查询tb_UU表所有记录
        //然后调用getTableData()将结果转换为二维数组tableData
        //需要按功能调用对应dao包中类的对应方法。
        list= UUDao.allUUs();
        showTableData(list);
        //修改、删除按钮不可用
        button4.setEnabled(false);
        button5.setEnabled(false);
    }
    /**
     * 以姓名和性别为查询条件查询UU表
     * 调用UUDao.queryUUsByName()按姓名查询tb_UU表记录
     * 然后调用getTableData()将结果转换为二维数组tableData。
     * 需要按功能调用对应dao包中类的对应方法。
     */
    private void UUQuery(){
        String name=this.textField1.getText();
        String sex=(String)this.comboBox1.getSelectedItem();
        list=null;
        if(sex.equals("全部")){
            list=UUDao.queryUUsByName(name);
        }else{
            list=UUDao.queryUUsByNameAndsex(name,sex);
        }
        showTableData(list);
        //修改、删除按钮不可用
        button4.setEnabled(false);
        button5.setEnabled(false);
    }
    /**
     * 将集合list转为二维数组,在table中显示，其中参数UU表示list中元素为UU类对象，
     * 需要按表对应类调整
     */
    private void showTableData(List<UU> UUs){
        //表头
        String[]heads={"姓名","性别","管理宿舍","入职日期"};
        //表内容
        Object[][] tableData=new Object[UUs.size()][heads.length];
        int i=0;
        for(UU UU:UUs){
            tableData[i][0]=UU.getName();
            tableData[i][1]=UU.getsex();
            tableData[i][2]=UU.getguanlisushe();
            tableData[i][3]=UU.getruzhiriqi();
            i++;
        }
        //将表头和表内容显示到table1对象
        this.table1.setModel(new DefaultTableModel(tableData,heads));
    }
    /**
     * 单击查询按纽的响应
     */
    private void buttonQuery(ActionEvent e) {
        UUQuery();
    }
    /**
     * 组合框选择性别后的响应
     */
    private void comboBox1(ActionEvent e) {
        UUQuery();
    }
    /**
     * 查询部分清空按钮的响应
     */
    private void queryClear(ActionEvent e) {
        textField1.setText("");
        comboBox1.setSelectedIndex(0);
    }
    /**
     * 从文本框和单选按钮获取UU数据
     */
    private UU getUUfromUI() {
        if(textField2.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "请输入课名");
            return null;
        }
        if(textField4.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "请输入考试日期");
            return null;
        }
        if(textField3.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "请输入任课老师");
            return null;
        }
        UU UU=new UU();
        UU.setName(textField2.getText());
        UU.setguanlisushe(textField3.getText());
        UU.setruzhiriqi(textField4.getText());
        if(radioButton2.isSelected()) {
            UU.setsex("女");
        }else {
            UU.setsex("男");
        }
        System.out.println(UU);
        return UU;
    }

    /**
     * 在table中选中一行时的响应
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            //设置currentIndex为当前选中行索引
            int currentIndex = table1.getSelectedRow();
            System.out.println(currentIndex);
            //没有选中行，返回
            if(currentIndex<0) return;
            //将table选中行的信息显示到编辑区域的文本框、单选按钮中，需要按功能调用对应方法
            textField2.setText(list.get(currentIndex).getName());
            textField3.setText(list.get(currentIndex).getguanlisushe());
            textField4.setText(list.get(currentIndex).getruzhiriqi().toString());
            if(list.get(currentIndex).getsex().endsWith("男")) {
                radioButton1.setSelected(true);
            }else {
                radioButton2 .setSelected(true);
            }
            //修改、删除按钮可用
            button4.setEnabled(true);
            button5.setEnabled(true);
        }
    }
    /**
     * 添加按钮单击的响应
     * @param e
     */
    private void buttonAdd(ActionEvent e) {
        //显示对话框，单击确定返回值为0
        int n = JOptionPane.showConfirmDialog(null,"确定将当前信息作为新纪录添加到数据库吗？","确定要添加新记录吗？",0);
        System.out.println(n);
        if(n==0) {
            UU UU = getUUfromUI();
            if(UU==null )
                return ;
            int ok = UUDao.insertUU(UU);
            if (ok == 0) {
                JOptionPane.showMessageDialog(null, "添加失败");
            } else {
                JOptionPane.showMessageDialog(null, "添加成功");
                UUQuery();
                clear();
            }
        }
    }
    /**
     * 修改按钮单击的响应
     * @param e
     */
    private void buttonModify(ActionEvent e) {
        //设置currentIndex为当前选中行索引
        int currentIndex = table1.getSelectedRow();
        //没有当前选中记录，返回
        if(currentIndex==-1){
            JOptionPane.showMessageDialog(null, "请在表格中选中要修改的记录");
            return ;
        }
        //显示对话框，单击是返回0
        int n = JOptionPane.showConfirmDialog(null,"确定将选定记录修改为当前信息并存储到数据库吗？","确定要修改当前记录吗？",0);
        System.out.println(n);
        if(n==0) {
            UU UU = getUUfromUI();
            if(UU==null )
                return ;
            UU.setId(list.get(currentIndex).getId());
            int ok=UUDao.updateUU(UU);
            if(ok==0) {
                JOptionPane.showMessageDialog(null, "修改失败");
            }else {
                JOptionPane.showMessageDialog(null, "修改成功");
                UUQuery();
                clear();
            }
        }
    }
    /**
     * 删除按钮单击的响应
     * @param e
     */
    private void buttonDel(ActionEvent e) {
        //设置currentIndex为当前选中行索引
        int currentIndex = table1.getSelectedRow();
        //没有当前选中记录，返回
        if(currentIndex==-1){
            JOptionPane.showMessageDialog(null, "请在表格中选中要修改的记录");
            return ;
        }
        //显示对话框，单击是返回0
        int n = JOptionPane.showConfirmDialog(null,"确定要删除选定记录吗？","确定要删除记录吗？",0);
        System.out.println(n);
        if(n==0) {
            int ok=UUDao.deleteUUById(list.get(currentIndex).getId());
            if(ok==0) {
                JOptionPane.showMessageDialog(null, "删除失败");
            }else {
                JOptionPane.showMessageDialog(null, "删除成功");
                UUQuery();
                clear();
            }
        }
    }
    /**
     * 清空文本框,是单选按钮设为默认值“男”
     */
    private void clear(){
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        radioButton1.setSelected(true);
        radioButton2.setSelected(false);
    }
    private void buttonClear(ActionEvent e) {
        clear();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label2 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        panel4 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label7 = new JLabel();
        textField3 = new JTextField();
        label8 = new JLabel();
        textField4 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new MyTable();
        hSpacer2 = new JPanel(null);
        panel3 = new JPanel();
        hSpacer1 = new JPanel(null);

        //======== this ========
        setPreferredSize(new Dimension(1000, 500));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u5b66\u9662");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FormLayout(
                "2*(default, $lcgap), 67dlu, $lcgap, 8dlu, $lcgap, 63dlu, 2*($lcgap, default)",
                "default, $lgap, 24dlu, 5*($lgap, default), $lgap, 34dlu, 7*($lgap, default)"));

            //---- label2 ----
            label2.setText("\u67e5\u8be2\u6761\u4ef6");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 18));
            panel1.add(label2, CC.xywh(5, 3, 5, 1));

            //---- label1 ----
            label1.setText("\u59d3\u540d");
            label1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label1, CC.xy(5, 7));

            //---- textField1 ----
            textField1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(textField1, CC.xy(9, 7));

            //---- label3 ----
            label3.setText("\u7b5b\u9009");
            label3.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label3, CC.xy(5, 9));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5168\u90e8",
                "\u7537",
                "\u5973"
            }));
            comboBox1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            comboBox1.addActionListener(e -> comboBox1(e));
            panel1.add(comboBox1, CC.xy(9, 9));

            //---- button1 ----
            button1.setText("\u6e05\u7a7a");
            button1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button1.addActionListener(e -> queryClear(e));
            panel1.add(button1, CC.xy(5, 13));

            //---- button2 ----
            button2.setText("\u67e5\u8be2");
            button2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button2.addActionListener(e -> buttonQuery(e));
            panel1.add(button2, CC.xy(9, 13));

            //---- label4 ----
            label4.setText("\u5bfc\u5458\u4fe1\u606f");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFont(new Font("\u7b49\u7ebf", Font.BOLD, 18));
            panel1.add(label4, CC.xywh(5, 17, 5, 1));

            //---- label5 ----
            label5.setText("\u59d3\u540d");
            label5.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label5, CC.xy(5, 19));

            //---- textField2 ----
            textField2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(textField2, CC.xy(9, 19));

            //---- label6 ----
            label6.setText("\u6027\u522b");
            label6.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label6, CC.xy(5, 21));

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout());

                //---- radioButton1 ----
                radioButton1.setText("\u7537");
                radioButton1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
                radioButton1.setSelected(true);
                panel4.add(radioButton1);

                //---- radioButton2 ----
                radioButton2.setText("\u5973");
                radioButton2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
                panel4.add(radioButton2);
            }
            panel1.add(panel4, CC.xywh(8, 21, 4, 1));

            //---- label7 ----
            label7.setText("\u7ba1\u7406\u5bbf\u820d");
            label7.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label7, CC.xy(5, 23));

            //---- textField3 ----
            textField3.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(textField3, CC.xy(9, 23));

            //---- label8 ----
            label8.setText("\u5165\u804c\u65e5\u671f");
            label8.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(label8, CC.xy(5, 25));

            //---- textField4 ----
            textField4.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            panel1.add(textField4, CC.xy(9, 25));

            //---- button3 ----
            button3.setText("\u6dfb\u52a0");
            button3.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button3.addActionListener(e -> buttonAdd(e));
            panel1.add(button3, CC.xy(5, 27));

            //---- button4 ----
            button4.setText("\u4fee\u6539");
            button4.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button4.addActionListener(e -> buttonModify(e));
            panel1.add(button4, CC.xy(9, 27));

            //---- button5 ----
            button5.setText("\u5220\u9664");
            button5.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button5.addActionListener(e -> buttonDel(e));
            panel1.add(button5, CC.xy(5, 29));

            //---- button6 ----
            button6.setText("\u6e05\u7a7a");
            button6.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button6.addActionListener(e -> buttonClear(e));
            panel1.add(button6, CC.xy(9, 29));
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new FlowLayout());

            //======== scrollPane1 ========
            {
                scrollPane1.setPreferredSize(new Dimension(550, 427));
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1);

            //---- hSpacer2 ----
            hSpacer2.setPreferredSize(new Dimension(30, 10));
            panel2.add(hSpacer2);
        }
        contentPane.add(panel2, BorderLayout.EAST);

        //======== panel3 ========
        {
            panel3.setLayout(new FlowLayout());

            //---- hSpacer1 ----
            hSpacer1.setMinimumSize(new Dimension(50, 12));
            hSpacer1.setPreferredSize(new Dimension(30, 10));
            panel3.add(hSpacer1);
        }
        contentPane.add(panel3, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JPanel panel4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private MyTable table1;
    private JPanel hSpacer2;
    private JPanel panel3;
    private JPanel hSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    //当前UU表的查询结果
    private List<UU> list;
}
