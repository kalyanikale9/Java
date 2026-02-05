/*b) Write a program to create a thread for moving a ball inside a panel vertically. The ball should be created when the user
clicks on the start button.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallMovement extends JFrame implements ActionListener {

    private JButton startButton;
    private BallPanel panel;

    public BallMovement() {
        setTitle("Vertical Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the frame

        panel = new BallPanel();
        startButton = new JButton("Start");

        startButton.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        panel.startBallMovement();
    }

    public static void main(String[] args) {
        // Ensure GUI runs on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new BallMovement());
    }
}

// Panel where ball will move
class BallPanel extends JPanel {

    private int y = 0;    // Starting position inside panel
    private int x = 180;  // Horizontal center
    private int dy = 5;   // Movement speed
    private boolean running = false;
    private Timer timer;

    public BallPanel() {
        setBackground(Color.WHITE);
    }

    public void startBallMovement() {
        if (!running) {
            running = true;

            // Swing Timer updates every 30 ms
            timer = new Timer(30, e -> {
                y += dy;

                // Reverse direction on hitting top or bottom
                if (y <= 0 || y >= getHeight() - 20)
                    dy = -dy;

                repaint();
            });

            timer.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillOval(x, y, 20, 20); // draw ball (20x20)
    }
}
