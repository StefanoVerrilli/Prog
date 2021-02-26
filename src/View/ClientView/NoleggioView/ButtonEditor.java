package View.ClientView.NoleggioView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonEditor extends DefaultCellEditor {
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor(JTextField txt){
        super(txt);
        btn=new JButton();
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(100,30));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col){
        lbl=(obj==null) ? "":obj.toString();
        btn.setText(lbl);
        clicked=true;
        return btn;


    }

    @Override
    public Object getCellEditorValue(){
        if(clicked){
            System.out.println("ciao");
            JOptionPane.showMessageDialog(btn,lbl +"Clicked");
        }
        clicked=false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing(){
        clicked=false;
        return super.stopCellEditing();

    }

    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
}