/*c) Write a program that implements a multi-thread application that has three threads.
First thread generates random integer every 1 second and if the value is even, second thread 
computes the square of the number and prints. If the value is odd, the third thread will print 
the value of cube of the number.*/
import java.util.Random;

// Thread to compute square
class Square extends Thread {
    int n;
    Square(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Square: " + n * n);
    }
}

// Thread to compute cube
class Cube extends Thread {
    int n;
    Cube(int n) {
        this.n = n;
    }
    public void run() {
        System.out.println("Cube: " + n * n * n);
    }
}

// Thread to generate numbers
class NumberGenerator extends Thread {
    public void run() {
        try {
            Random r = new Random();
            for (int i = 1; i <= 10; i++) {
                int n = r.nextInt(20);
                System.out.println("Generated number is: " + n);

                if (n % 2 == 0) {
                    new Square(n).start();
                } else {
                    new Cube(n).start();
                }

                Thread.sleep(1000); // 1 second
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Main class
public class TDemo7 {
    public static void main(String[] args) {
        new NumberGenerator().start();
    }
}

~                                                                                                                                                                                                                                                                       
~                   
