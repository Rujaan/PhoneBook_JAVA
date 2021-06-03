import java.util.Scanner;
import java.util.InputMismatchException;
public class TowersOfHanoi{
    public void solveTowersOfHanoi(int n, String source, String aux, String dest)
    {
        // If only 1 disk, make the move and return.

        if(n==1)
        {
            System.out.println("|"+source+"          |"+aux+"            |"+dest+"          |");
            System.out.println(" -------------------------------------");
            return;
        }

        // Move top n-1 disks from 1 to 2 using 3 as auxiliary.
        solveTowersOfHanoi(n-1, source, dest, aux);

        //Move remaining disks from 1 to 3
        System.out.println("|"+source+"          |"+aux+"            |"+dest+"          |");
        System.out.println(" -------------------------------------");

        // Move n-1 disks from 2 to 3 using 1 as auxiliary
        solveTowersOfHanoi(n-1, aux, source, dest);

    }

    public static void main(String args[])
    {
        TowersOfHanoi obj = new TowersOfHanoi();
        try{
            System.out.println("Enter number of disks :- ");

            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.close();
            if(n>8 || n<0){
                throw new NumberException();
            }

            System.out.println("The disk moves as shown below");
            System.out.println(" -------------------------------------");
            System.out.println("|Source     |Auxilary     |Destination|");
            System.out.println(" -------------------------------------");
            obj.solveTowersOfHanoi(n, "1", "2", "3");
        }
        catch(NumberException e){
            System.err.println("Error ! "+e);
        }
        catch(InputMismatchException e){
            System.err.println("Error ! "+"Please enter a valid number.");
        }
    }
}