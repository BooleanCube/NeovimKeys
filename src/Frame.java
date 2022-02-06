import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    JFrame window;
    int size;
    double a1, a2;
    Node cursor = null, goal = null;
    String typeAttempt = "";
    String mode = "";
    double averageTime = 0;
    long startTime = 0;
    long goalCounter = 0;

    public static void main(String[] args) {
        new Frame();
    }

    public Frame() {
        size = 25;
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        a1 = (5000.0000 / (Math.pow(25.0000/5000, 1/49.0)));
        a2 = 625.0000;
        mode = "Normal";
        window = new JFrame();
        window.setContentPane(this);
        window.setTitle("Neovim Key Practice");
        window.getContentPane().setPreferredSize(new Dimension(800+16, 800+16));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
        cursor = new Node(0, 0, "");
        goal = new Node((int)(Math.random()*((this.getWidth()/size)-2)+1), (int)(Math.random()*((this.getHeight()/size)-2)+1), getRandomText());
        this.revalidate();
        this.repaint();
        startTime = System.currentTimeMillis();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        g.setColor(Color.lightGray);
        for(int j = 0; j < this.getHeight()-2*size; j += size) {
            for(int i = 0; i < this.getWidth()*size; i += size) {
                g.drawRect(i, j, size, size);
                if(goal != null && goal.x == i/size && goal.y == j/size) {
                    g.setColor(Color.blue);
                    g.fillRect(i+1, j+1, size-1, size-1);
                    g.setColor(Color.white);
                    g.drawString(goal.text, i+6, j+16);
                }
                if(cursor.x == i/size && cursor.y == j/size) {
                    if(mode.equalsIgnoreCase("Normal")) g.setColor(Color.black);
                    else g.setColor(Color.green);
                    g.fillRect(i+1, j+1, size-1, size-1);
                    if(cursor.x == goal.x && cursor.y == goal.y) {
                        g.setColor(Color.white);
                        g.drawString(goal.text, i+6, j+16);
                    }
                }
                g.setColor(Color.lightGray);
            }
        }
        g.setColor(Color.black);
        g.setFont(new Font("default", Font.BOLD, 20));
        g.drawString(mode, 10, 800);
        g.setFont(new Font("default", Font.BOLD, 16));
        g.drawString(goalCounter == 1 ? goalCounter + " goal" : goalCounter + " goals", 400, 800);
        g.drawString(
                averageTime == 1 ? "Average Time: " + String.format("%.2f", averageTime) + " second" : "Average Time: " + String.format("%.2f", averageTime) + " seconds",
                590, 800);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int currentKey = e.getKeyCode();

        if(mode.equalsIgnoreCase("Normal")) {
            if(currentKey == KeyEvent.VK_I) mode = "Insert";
            else {
                if(currentKey == KeyEvent.VK_H) cursor.x--;
                else if(currentKey == KeyEvent.VK_J) cursor.y++;
                else if(currentKey == KeyEvent.VK_K) cursor.y--;
                else if(currentKey == KeyEvent.VK_L) cursor.x++;
            }
        }

        if(mode.equalsIgnoreCase("Insert")) {
            if(currentKey == KeyEvent.VK_ESCAPE) mode = "Normal";
            else {
                if(currentKey == KeyEvent.VK_LEFT) cursor.x--;
                if(currentKey == KeyEvent.VK_DOWN) cursor.y++;
                if(currentKey == KeyEvent.VK_UP) cursor.y--;
                if(currentKey == KeyEvent.VK_RIGHT) cursor.x++;
                else {
                    char currentChar = e.getKeyChar();
                    if(typeAttempt.length() == 1 && currentChar == goal.text.charAt(1)) typeAttempt += currentChar;
                    else typeAttempt = "";
                    if(typeAttempt.length() == 0 && currentChar == goal.text.charAt(0)) typeAttempt += currentChar;
                }
                if(!(cursor.x == goal.x && cursor.y == goal.y)) typeAttempt = "";
                if(typeAttempt.length() == 2) {
                    goal = new Node((int)(Math.random()*((this.getWidth()/size))), (int)(Math.random()*((this.getHeight()/size))), getRandomText());
                    typeAttempt = "";
                    ++goalCounter;
                    double time = (System.currentTimeMillis()-startTime)/1000.0;
                    if(averageTime == 0) averageTime = time;
                    else { averageTime += time; averageTime /= 2; }
                    startTime = System.currentTimeMillis();
                }
            }
        }

        if(cursor.x < 0) cursor.x = 0;
        if(cursor.x > (getWidth()-size)/size) cursor.x--;
        if(cursor.y < 0) cursor.y = 0;
        if(cursor.y > (getHeight()-2*size)/size) cursor.y--;

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseWheelMoved(MouseWheelEvent m) {}

    @Override
    public void actionPerformed(ActionEvent e) {}

    String getRandomText() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char f = alphabet.charAt((int)(Math.random()*alphabet.length())), s = alphabet.charAt((int)(Math.random()*alphabet.length()));
        return f + "" + s;
    }

}
