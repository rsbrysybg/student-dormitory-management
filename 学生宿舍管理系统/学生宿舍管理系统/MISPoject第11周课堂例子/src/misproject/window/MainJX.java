/*
 * Created by JFormDesigner on Mon Apr 29 11:33:04 CST 2024
 */

package misproject.window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author wjl
 */
public class MainJX extends JFrame {
    public static void  main(String[] args) {
        new MainJX();
    }
    public MainJX() {
        initComponents();
    }


    private void button3(ActionEvent e) {
        new User1Edit(this).setVisible(true);
    }

    private void userEdit(ActionEvent e) {
        new JXEdit(this).setVisible(true);
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        toolBar1 = new JToolBar();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(1200, 800));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u5b66\u751f\u5bbf\u820d\u7ba1\u7406-\u5b66\u9662\u754c\u9762");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== toolBar1 ========
        {
            toolBar1.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));

            //---- button2 ----
            button2.setIcon(UIManager.getIcon("FileChooser.listViewIcon"));
            button2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button2.addActionListener(e -> userEdit(e));
            toolBar1.add(button2);
            toolBar1.addSeparator();

            //---- button3 ----
            button3.setIcon(UIManager.getIcon("FileChooser.listViewIcon"));
            button3.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 16));
            button3.addActionListener(e -> {
			button3(e);
		});
            toolBar1.add(button3);
        }
        contentPane.add(toolBar1);
        toolBar1.setBounds(new Rectangle(new Point(0, 0), toolBar1.getPreferredSize()));

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JToolBar toolBar1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
