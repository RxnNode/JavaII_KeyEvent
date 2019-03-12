package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CCMK extends JFrame {

    private JButton But_L = new JButton("Enlarge");
    private JButton But_S = new JButton("Shrink");
    private CCPanel canvas = new CCPanel();

    public CCMK(){
        JPanel panel = new JPanel();
        panel.add(But_L);
        panel.add(But_S);
        this.add(canvas, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);

        But_L.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.enlarge();
                canvas.requestFocusInWindow();
            }
        });


        But_S.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shrink();
                canvas.requestFocusInWindow();
            }
        });

        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) canvas.enlarge();
                else if (e.getButton() == MouseEvent.BUTTON3) canvas.shrink();
            }
        });

        canvas.setFocusable(true); canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) canvas.enlarge();
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) canvas.shrink();
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new CCMK();
        frame.setTitle("CC");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }



    class CCPanel extends JPanel{

        private int rad = 10;

        public void enlarge(){
            rad++;
            repaint();
        }
        public void shrink(){
            rad--;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawOval(getWidth()/2 - rad,getHeight()/2 - rad,rad*2,rad*2);
        }

    }

}
