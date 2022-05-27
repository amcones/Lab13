import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayExceptionTest {

    public static void main(String[] args) {
        int[] array = new int[100];
        Random random=new Random();
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt();
        }
        System.out.print("Enter an index: ");
        while(true) {
            Scanner sc = new Scanner(System.in);
            try {
                int pos = sc.nextInt();
                System.out.print("The element is "+array[pos]);
                break;
            } catch (InputMismatchException ex) {
                System.out.print("Incorrect input re-enter one integers number: ");
            } catch (IndexOutOfBoundsException ex){
                System.out.print("Out of Bounds re-enter one integers(0-99): ");
            }
        }
    }
}
