/*c) Using the concepts of thread synchronization create two threads as sender and receiver. Sender thread will set 
  a message to the receiver thread that will display the message on console. The sender thread accepts the input 
  message from console. Continue this process until sender sets the message as “Good Bye Corona”.*/

import java.util.Scanner;

class Message {
    private String message;
    private boolean hasMessage = false;

    public synchronized void send(String msg) {
        while (hasMessage) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        message = msg;
        hasMessage = true;
        notify();
    }

    public synchronized String receive() {
        while (!hasMessage) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        hasMessage = false;
        notify();
        return message;
    }
}

class Sender extends Thread {
    private Message msg;
    private Scanner sc = new Scanner(System.in);

    public Sender(Message msg) { this.msg = msg; }

    public void run() {
        String text = "";
        while (!text.equals("Good Bye Corona")) {
            System.out.println("Sender: Enter message: "); // println fixes overlapping
            text = sc.nextLine();
            msg.send(text);
        }
    }
}

class Receiver extends Thread {
    private Message msg;

    public Receiver(Message msg) { this.msg = msg; }

    public void run() {
        String text = "";
        while (!text.equals("Good Bye Corona")) {
            text = msg.receive();
            System.out.println("Receiver received: " + text);
        }
    }
}

public class ThreadSyncDemo {
    public static void main(String[] args) {
        Message message = new Message();
        Receiver receiver = new Receiver(message);
        Sender sender = new Sender(message);

        receiver.start();
        sender.start();
    }
}
