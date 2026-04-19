package Lab01;
import java.util.Scanner;
public class Ex6_6 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int sohang = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int socot = sc.nextInt();

        int[][] matrana = new int[sohang][socot];
        int[][] matranb = new int[sohang][socot];
        int[][] matrantong = new int[sohang][socot];

        System.out.println("Enter the elements of matrix A: ");
        for (int i = 0; i < sohang; i++) {
            for (int j = 0; j < socot; j++) {
                matrana[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix B: ");
        for (int i = 0; i < sohang; i++) {
            for (int j = 0; j < socot; j++) {
                matranb[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < sohang; i++) {
            for (int j = 0; j < socot; j++) {
                matrantong[i][j] = matrana[i][j] + matranb[i][j];
            }
        }

        System.out.println("The sum of matrices A and B is: ");
        for (int i = 0; i < sohang; i++) {
            for (int j = 0; j < socot; j++) {
                System.out.print(matrantong[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
