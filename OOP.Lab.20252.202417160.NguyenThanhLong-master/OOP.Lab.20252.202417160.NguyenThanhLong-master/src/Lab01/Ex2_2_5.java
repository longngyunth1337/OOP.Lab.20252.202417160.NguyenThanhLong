package Lab01;
import javax.swing.JOptionPane;
public class Ex2_2_5 {
	public static void main(String[] args) {
		double a, b;
		String inputA = JOptionPane.showInputDialog("Nhap so a:");
		a = Double.parseDouble(inputA);
		String inputB = JOptionPane.showInputDialog("Nhap so b:");
		b = Double.parseDouble(inputB);
		double sum = a + b;
		double difference = a - b;
		double product = a * b;
		double quotient = a / b;
		if(b == 0)
		{
			JOptionPane.showMessageDialog(null, "Sum = " + sum + "\nDifference = " + difference + "\nProduct = " + product
					+ "\nQuotient = Error" );
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sum = " + sum + "\nDifference = " + difference + "\nProduct = " + product
					+ "\nQuotient = " + quotient);
		}
	}
}
