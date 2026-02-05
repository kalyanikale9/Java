/*Set A
a) Program to define a thread for printing text on output screen for ‘n’ number of times.
Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor.
Example:
i. First thread prints “COVID19” 10 times.
ii. Second thread prints “LOCKDOWN2020” 20 times
iii. Third thread prints “VACCINATED2021” 30 times
*/
import java.io.*;
import java.util.*;
public class tdemo4 extends Thread
{
int n;
String msg;
tdemo4(int n,String msg)
{
this.n=n;
this.msg=msg;
}
public void run()
{
try
{
for(int i=1;i<=n;i++)
{
System.out.println(msg);

}
}
catch(Exception e)
{
System.out.println(e);
}
}
public static void main(String args[])
{
Thread t1=new Thread(new tdemo4(10,"COVID19"));
t1.start();
Thread t2=new Thread(new tdemo4(20,"LOCKDOWN2020"));
t2.start();
Thread t3=new Thread(new tdemo4(30,"VACCINATED2021"));
t3.start();
}
}
