package bugs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//please fix problem with panel color change: expect
//click on button - color should be changed
public class NPE implements ActionListener {
    public JFrame frame;
//JPanel panel;
//JLabel label;

    public static void main(String[] args) {
        NPE gui = new NPE();
        gui.go();
    }//end of main

    public void go() {
        System.out.println("Entered Go()");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b_frame = new JButton("Click to change the color");
        b_frame.addActionListener(this);
        Panel d_panel = new Panel();

        frame.getContentPane().add(BorderLayout.SOUTH, b_frame);
        frame.getContentPane().add(BorderLayout.CENTER, d_panel);

        frame.setSize(300, 300);
        frame.setVisible(true);


    }//end of go

    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().setBackground(Color.CYAN);
    }


}