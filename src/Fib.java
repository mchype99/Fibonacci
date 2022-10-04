package q1;
import java.util.InputMismatchException;

/**
 A class that calculates and displays the Fibonacci series.
 */
public class Fib {
    int fib0, fib1;

    /**
     Constructs a Fib object that can calculate a Fibonacci
     series.
     @param f0 the first number of the fibonacci series.
     @param f1 the second number of the fibonacci series.
     */
    public Fib(int f0, int f1)
    {
        fib0 = f0;
        fib1 = f1;
    }

    /**
     Computes F(n) using an iterative algorithm.
     @param n the index of the fibonacci series that will be returned.
     @return F(n) of the fibonacci series.
     */
    public int f(int n) {
        int f0 = fib0, f1 = fib1, f2 = f0 + f1;

        if (n < 0)
            throw new IllegalArgumentException("Error, n must be a positive integer!");
        else if (n == 0)
            return f0;
        else if (n == 1)
            return f1;
        else {
            for (int i = 2; i < n; i++){
                f0 = f1;
                f1 = f2;
                f2 = f0 + f1;
            }
            return f2;
        }
    }

    /**
     Computes F(n) using a recursive algorithm.
     @param n the index of the fibonacci series that will be returned.
     @return F(n) of the fibonacci series.
     */
    public int fRec(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Error, n must be a positive integer!");
        else if (n == 0)
            return fib0;
        else if (n == 1)
            return fib1;
        else
            return fRec(n-1) + fRec(n-2);
    }

    /**
     main code sequence. Instantiate a Fib object and calculate
     and display the fibonacci series using both algorithms.
     */
    public static void main(String[] args) {
        try {
            // get numbers F(0), F(1) and n from args[0], args[1] and args[2].
            int f0 = Integer.parseInt(args[0]);
            int f1 = Integer.parseInt(args[1]);
            int n = Integer.parseInt(args[2]);

            // create a Fib object with params F(0) and F(1)
            Fib fib = new Fib(f0, f1);

            //validate n
            fib.f(n);

            // the iterative method f(i)
            System.out.println("Fibonacci series using iterative method:");
            for (int i = 0; i < n + 1; i++) {
                System.out.println(fib.f(i));
            }

            // the recursive method fRec(i)
            System.out.println("Fibonacci series using recursive method:");
            for (int i = 0; i < n + 1; i++) {
                System.out.println(fib.fRec(i));
            }
        } catch (InputMismatchException e) {
            System.out.println("Error, must enter integers!");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error, must enter integers!");
            System.exit(1);
            //printStackTrace(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error, must enter 3 integers!");
            System.exit(1);
        }
    }
};
