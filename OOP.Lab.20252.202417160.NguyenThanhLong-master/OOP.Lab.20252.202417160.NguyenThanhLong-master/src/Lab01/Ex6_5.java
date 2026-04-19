package Lab01;
import java.util.Scanner;
public class Ex6_5 {

	    static void quickSort(int[] arr, int low, int high) {

	        if (low < high) {

	            int pivot = arr[high];
	            int i = low - 1;

	            for (int j = low; j < high; j++) {
	                if (arr[j] < pivot) {
	                    i++;

	                    int temp = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = temp;
	                }
	            }

	            int temp = arr[i + 1];
	            arr[i + 1] = arr[high];
	            arr[high] = temp;

	            int p = i + 1;

	            quickSort(arr, low, p - 1);
	            quickSort(arr, p + 1, high);
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();
	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++)
	            arr[i] = sc.nextInt();

	        int sum = 0;

	        for (int i = 0; i < n; i++)
	            sum += arr[i];

	        double avg = (double) sum / n;

	        quickSort(arr, 0, n - 1);

	        System.out.print("Sorted array: ");
	        for (int x : arr)
	            System.out.print(x + " ");
	        System.out.println();
	        System.out.println("Sum = " + sum);
	        System.out.println("Average = " + avg);
	    }
}