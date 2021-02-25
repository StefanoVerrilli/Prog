package View.ClientView.NoleggioView;

import javax.swing.*;
import java.awt.*;

public class TableNoleggi extends JPanel {
    JTable table;
    public TableNoleggi(String[] Columns, Object[][] Data) {
        table = new JTable(Data, Columns) {
            @Override
            public boolean isCellEditable(int raw, int column) {
                switch(column){
                    case 3:
                        return true;
                    default:
                        return false;
                }
            }
        };
        table.setFont(new Font("Dialog", Font.PLAIN, 20));
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        this.setLayout(new BorderLayout());
        int dim = table.getRowCount() * table.getRowHeight();
        System.out.println(table.getSize());
        table.setBackground(Color.white);
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));
        table.getTableHeader().setReorderingAllowed(false); // disabilita la modifica dell'ordine delle colonne
        table.getTableHeader().setResizingAllowed(false); // disabilita il ridimensionamento delle colonne

        JScrollPane Scrollmap = new JScrollPane(table);

        Scrollmap.getViewport().setViewPosition(new Point(0,0));
        Scrollmap.setPreferredSize(new Dimension(1000,dim));
        Scrollmap.getVerticalScrollBar().setMaximum(1);
        Scrollmap.getVerticalScrollBar().setMinimum(1);
        //Scrollmap.setVerticalScrollBarPolicy(Scrollmap.VERTICAL_SCROLLBAR_ALWAYS);
        add(Scrollmap);
    }
}