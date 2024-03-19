import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Thread[] fibRunnables;
    public static Integer[] fibonacci;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the Fibonacci sequence: ");
        int size = sc.nextInt();

        fibRunnables = new Thread[size];
        fibonacci = new Integer[size];

        for(int i = 0; i < size; i++){
            fibRunnables[i] = new Thread(new FibRunnable(i));
        }

        fibRunnables[size-1].start();

        for(Thread t : fibRunnables){
            t.join();
        }

        System.out.println(Arrays.toString(fibonacci));
    }
}