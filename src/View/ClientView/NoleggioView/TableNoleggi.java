package View.ClientView.NoleggioView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TableNoleggi extends JPanel {
    JTable table;
    public TableNoleggi(ArrayList<Park> data,String[] columns) {
        DefaultTableModel Model = new DefaultTableModel(columns,0);
        JTable table = new JTable(Model) {
            @Override
            public boolean isCellEditable(int raw, int column) {
                switch(column){
                    case 2:
                        return true;
                    default:
                        return false;
                }
            }};

        for(int i=0;i<data.size();i++){
            String Nome = data.get(i).getName();
            String Indirizzo = data.get(i).getStreet();
            Object[] array = {Nome,Indirizzo,"Prenota"};
            Model.addRow(array);
        }

        table.setRowHeight(30);
        int dim = Model.getRowCount() * table.getRowHeight();
        table.setPreferredSize(new Dimension(1000,300));
        table.setFont(new Font("Dialog", Font.PLAIN, 20));
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        this.setLayout(new BorderLayout());
        System.out.println(table.getSize());
        table.setBackground(Color.white);
        table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField()));
        table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.getTableHeader().setReorderingAllowed(false); // disabilita la modifica dell'ordine delle colonne
        table.getTableHeader().setResizingAllowed(false); // disabilita il ridimensionamento delle colonne

        JScrollPane Scrollmap = new JScrollPane(table);

        Scrollmap.getViewport().setViewPosition(new Point(0,0));
        Scrollmap.setPreferredSize(new Dimension(1000,300));
        Scrollmap.getVerticalScrollBar().setMaximum(1);
        Scrollmap.getVerticalScrollBar().setMinimum(1);
        //Scrollmap.setVerticalScrollBarPolicy(Scrollmap.VERTICAL_SCROLLBAR_ALWAYS);
        add(Scrollmap);
    }
}