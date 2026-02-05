/*a) Write a program that simulates a traffic light. The program lets the user select one of three lights: red, yellow,
  or green with radio buttons. On selecting a button, an appropriate message with “stop” or “ready” or “go”should appear
  above the buttons in a selected color. Initially there is no message shown.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLightSimulation extends JFrame implements ActionListener {

    JRadioButton red, yellow, green;
    JLabel message;

    public TrafficLightSimulation() {

        setTitle("Traffic Light Simulation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Label for displaying message
        message = new JLabel("");
        message.setFont(new Font("Arial", Font.BOLD, 24));
        add(message);

        // Radio buttons
        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("Green");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(yellow);
        group.add(green);

        // Add listeners
        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        // Add buttons to frame
        add(red);
        add(yellow);
        add(green);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (red.isSelected()) {
            message.setText("STOP");
            message.setForeground(Color.RED);
        } 
        else if (yellow.isSelected()) {
            message.setText("READY");
            message.setForeground(Color.ORANGE);
        } 
        else if (green.isSelected()) {
            message.setText("GO");
            message.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLightSimulation();
    }
}

