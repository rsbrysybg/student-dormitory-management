/*
 * Created by JFormDesigner on Mon Apr 29 11:08:20 CST 2024
 */

package misproject.window;

import misproject.dao.LoginUserDao;
import misproject.pojo.LoginUser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author wjl
 */
public class Login extends JFrame {
    public String V="导员",V1="学院";
    public static void main(String []args){
        new Login();
    }
    public Login() {
        initComponents();
    }

    private void quit(ActionEvent e) {
        System.exit(0);
    }

    private void login(ActionEvent e) {
        //获取账号和密码
        String account=this.textField1.getText();
        String pwd=new String(this.passwordField1.getPassword());
        if(account.isBlank()||pwd.isBlank()){
            JOptionPane.showMessageDialog(null,"账号或密码不能为空，请重试");
            return ;
        }
        //根据账号和密码查找记录
        boolean value = radioButton1.isSelected();
        boolean value1 = radioButton2.isSelected();
        if(value1){
            LoginUser user1= LoginUserDao.login1(account,pwd,V);
            if(user1!=null){
                JOptionPane.showMessageDialog(null,"登录成功！");
                new Main().setVisible(true);
                this.dispose();
            }else{
                //没有找到相关记录，提示登录有误
                JOptionPane.showMessageDialog(null,"账号或密码错误，请重试");
            }
        } else if (value) {
            LoginUser user2= LoginUserDao.login2(account,pwd,V1);
            if(user2!=null){JOptionPane.showMessageDialog(null,"登录成功！");
                new MainJX().setVisible(true);
               this.dispose();
            }else{
                //没有找到相关记录，提示登录有误
                JOptionPane.showMessageDialog(null,"账号或密码错误，请重试");
            }
        }

    }

    private void radioButton1(ActionEvent e) {
        // TODO add your code here
    }

    private void  radioButton2(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        panel4 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setTitle("\u767b\u5f55\u7a97\u53e3");
        setPreferredSize(new Dimension(400, 300));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        label1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        contentPane.add(label1);
        label1.setBounds(105, 65, 45, 25);

        //---- textField1 ----
        textField1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        contentPane.add(textField1);
        textField1.setBounds(175, 60, 110, 35);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        contentPane.add(label2);
        label2.setBounds(105, 105, label2.getPreferredSize().width, 30);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        contentPane.add(passwordField1);
        passwordField1.setBounds(175, 105, 110, 35);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        button1.addActionListener(e -> login(e));
        contentPane.add(button1);
        button1.setBounds(95, 190, 85, 35);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        button2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
        button2.addActionListener(e -> quit(e));
        contentPane.add(button2);
        button2.setBounds(220, 190, 85, 35);

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout());

            //---- radioButton1 ----
            radioButton1.setText("\u5b66\u9662");
            radioButton1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            radioButton1.setSelected(true);
            radioButton1.addActionListener(e -> radioButton1(e));
            panel4.add(radioButton1);

            //---- radioButton2 ----
            radioButton2.setText("\u5bfc\u5458");
            radioButton2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            radioButton2.addActionListener(e -> radioButton2(e));
            panel4.add(radioButton2);
        }
        contentPane.add(panel4);
        panel4.setBounds(175, 145, 183, 31);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JPanel panel4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
