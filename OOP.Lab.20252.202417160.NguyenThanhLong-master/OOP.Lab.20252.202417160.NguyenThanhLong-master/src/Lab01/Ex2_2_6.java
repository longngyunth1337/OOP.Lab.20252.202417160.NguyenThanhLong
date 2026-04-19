package Lab01;
import java.util.Scanner;
public class Ex2_2_6 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    while (true) {
	        System.out.println("\nChoose an option:");
	        System.out.println("1. Solve linear equation with one variable");
	        System.out.println("2. Solve system of two linear equations");
	        System.out.println("3. Solve quadratic equation with one variable");
	        System.out.println("4. Exit");

	        System.out.print("Your choice: ");
	        int luaChon;

	        if (sc.hasNextInt()) {
	            luaChon = sc.nextInt();
	        } else {
	            System.out.println("Invalid input. Please enter an integer.");
	            sc.next();
	            continue;
	        }

	        switch (luaChon) {
	            case 1:
	                System.out.print("Enter coefficient a: ");
	                double hesoa = sc.nextDouble();

	                System.out.print("Enter coefficient b: ");
	                double hesob = sc.nextDouble();

	                if (hesoa == 0) {
	                    if (hesob == 0) {
	                        System.out.println("The equation has infinitely many solutions.");
	                    } else {
	                        System.out.println("The equation has no solution.");
	                    }
	                } else {
	                    double nghiem = -hesob / hesoa;
	                    System.out.println("Solution: x = " + nghiem);
	                }
	                break;

	            case 2:
	                System.out.print("Enter a1, b1, c1: ");
	                double hesoa1 = sc.nextDouble();
	                double hesob1 = sc.nextDouble();
	                double hesoc1 = sc.nextDouble();

	                System.out.print("Enter a2, b2, c2: ");
	                double hesoa2 = sc.nextDouble();
	                double hesob2 = sc.nextDouble();
	                double hesoc2 = sc.nextDouble();

	                double d = hesoa1 * hesob2 - hesoa2 * hesob1;

	                if (d == 0) {
	                    if (hesoa1 * hesoc2 == hesoa2 * hesoc1 && hesob1 * hesoc2 == hesob2 * hesoc1) {
	                        System.out.println("The system has infinitely many solutions.");
	                    } else {
	                        System.out.println("The system has no solution.");
	                    }
	                } else {
	                    double x = (hesoc1 * hesob2 - hesoc2 * hesob1) / d;
	                    double y = (hesoa1 * hesoc2 - hesoa2 * hesoc1) / d;
	                    System.out.println("Solution: x = " + x + ", y = " + y);
	                }
	                break;

	            case 3:
	                System.out.print("Enter coefficient a: ");
	                double a = sc.nextDouble();

	                System.out.print("Enter coefficient b: ");
	                double b = sc.nextDouble();

	                System.out.print("Enter coefficient c: ");
	                double c = sc.nextDouble();

	                if (a == 0) {
	                    if (b == 0) {
	                        if (c == 0) {
	                            System.out.println("The equation has infinitely many solutions.");
	                        } else {
	                            System.out.println("The equation has no solution.");
	                        }
	                    } else {
	                        double x = -c / b;
	                        System.out.println("Solution: x = " + x);
	                    }
	                } else {
	                    double delta = b * b - 4 * a * c;

	                    if (delta > 0) {
	                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
	                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
	                        System.out.println("The equation has two distinct roots: x1 = " + x1 + ", x2 = " + x2);
	                    } else if (delta == 0) {
	                        double x = -b / (2 * a);
	                        System.out.println("The equation has one double root: x = " + x);
	                    } else {
	                        System.out.println("The equation has no real roots.");
	                    }
	                }
	                break;

	            case 4:
	                System.out.println("Program ended.");
	                sc.close();
	                return;

	            default:
	                System.out.println("Invalid choice. Please choose from 1 to 4.");
	        }
	    }
	}
}
