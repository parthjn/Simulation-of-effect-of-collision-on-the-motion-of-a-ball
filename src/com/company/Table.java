package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class Table extends JPanel
{
    private JTable table;
    private String top[];
    private String content[][];
    public Table()
    {
        super();
        top=new String[2];
        top[0]="Touch Down Height";
        top[1]="Maximum Height Achieved";
        content=new String [10][2];
        for(int i=1;i<=10;i++)
        {
            content[i-1][0]=Integer.toString(i)+").";
        }
        table=new JTable(content,top);
        table.setBounds(20,20,50,100);
        setSize(200,200);
        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);
        setVisible(false);
    }
    public void displayTable(int h,double e)
    {
        double height=h;
        for(int i=1;i<=10;i++)
        {
            content[i-1][1]=Double.toString(height);
            height=height*e*e;

        }
        table.setModel(new DefaultTableModel(content,top));
    }
    public void visible(){
        setVisible(true);
    }
}
