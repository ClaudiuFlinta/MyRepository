package PrezentationLayer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class InterfataAngajat{

    JFrame main;
    Container container;
    JPanel panel;
    static JTextArea notificare;

    public static void setNotificare(String s) {
        notificare.append(s);
    }

    public InterfataAngajat(){

        main = new JFrame("Main Employee Interface");

        {
            container = main.getContentPane();
            container.setBackground(Color.white);
            container.setVisible(true);
        }

        {
            panel = new JPanel();
            panel.setBounds(50, 50, 900, 550);
            panel.setBackground(Color.white);
        }

        {
            main.setVisible(true);
            main.setLayout(null);
        }

        {
            container.add(panel);
            container.setSize(550, 300);
            main.setSize(1000, 800);
            container.setVisible(true);
        }

        {

            notificare = new JTextArea(30, 60);
            notificare.setPreferredSize(new Dimension(900, 15000));
            notificare.setEditable(false);

            JScrollPane scrollView = new JScrollPane(notificare, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            panel.add(scrollView);
            main.setVisible(true);


        }

    }

    public static  void  main(String args[]){
        new InterfataAngajat();
    }



}
