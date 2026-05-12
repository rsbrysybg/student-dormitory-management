package misproject.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class MyTable extends JTable {

	private static final long serialVersionUID = 1L;
    public MyTable() {
        super();
        JTableHeader tableheader=this.getTableHeader();
        tableheader.setPreferredSize(new Dimension(tableheader.getWidth(),35));
        tableheader.setFont(new Font("等线", Font.PLAIN, 16));
        this.setRowHeight(30);
        this.setFont(new Font("等线", Font.PLAIN, 16));
    }
	public MyTable(String[][] data, String[] fields) {
        super(data, fields);
    }

    public MyTable(Object[][] tableData, String[] heads) {
		// TODO Auto-generated constructor stub
    	super(tableData, heads);
    	JTableHeader tableheader=this.getTableHeader();
    	tableheader.setPreferredSize(new Dimension(tableheader.getWidth(),40));
    	tableheader.setFont(new Font("等线", Font.PLAIN, 16));
    	this.setRowHeight(35);
    	this.setFont(new Font("等线", Font.PLAIN, 16));
	}
   
    
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getFillsViewportHeight()) {
            paintEmptyRows(g);
        }
    }

    /**
     * Paints the backgrounds of the implied empty rows when the table model is
     * insufficient to fill all the visible area available to us. We don't
     * involve cell renderers, because we have no data.
     */
    protected void paintEmptyRows(Graphics g) {
        final int rowCount = getRowCount();
        final Rectangle clip = g.getClipBounds();
        if (rowCount * rowHeight < clip.height) {
            for (int i = rowCount; i <= clip.height / rowHeight; ++i) {
                g.setColor(colorForRow(i));
                g.fillRect(clip.x, i * rowHeight, clip.width, rowHeight);
            }
        }
    }

    /**
     * Returns the appropriate background color for the given row.
     */
    protected Color colorForRow(int row) {
        return (row % 2 == 0) ? Color.white : new Color(240,250,255);
    }

    /**
     * Shades alternate rows in different colors.
     */
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isCellSelected(row, column) == false) {
            c.setBackground(colorForRow(row));
            c.setForeground(UIManager.getColor("Table.foreground"));
        } else {
            c.setBackground(UIManager.getColor("Table.selectionBackground"));
            c.setForeground(UIManager.getColor("Table.selectionForeground"));
        }
        return c;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
   }
}
