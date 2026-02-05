/*b) Write a program in which threads sleep for 6 sec in the loop in reverse order from 100 to 1 and change the name of the thread.*/
public class ReverseCountdownThread extends Thread {

   public ReverseCountdownThread(String name) {
       super(name); // Call the superclass constructor to set the initial name
   }

   @Override
   public void run() {
       try {
           for (int i = 100; i >= 1; i--) {
               // Change the thread name in each iteration
               setName("CountdownThread-" + i);
               System.out.println(Thread.currentThread().getName() + ": " + i);
               Thread.sleep(6000); // Sleep for 6 seconds (6000 milliseconds)
           }
       } catch (InterruptedException e) {
           System.out.println(Thread.currentThread().getName() + " was interrupted.");
           Thread.currentThread().interrupt(); // Restore the interrupted status
       }
   }

  public static void main(String[] args) {
  // Create an instance of the custom thread with an initial name
  ReverseCountdownThread myThread = new    ReverseCountdownThread("InitialCountdownThread");
       myThread.start(); // Start the thread
   }
}
