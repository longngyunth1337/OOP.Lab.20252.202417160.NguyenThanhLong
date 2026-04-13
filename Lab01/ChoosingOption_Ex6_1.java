package Lab01;
import javax.swing.JOptionPane;
class ChoosingOption_Ex6_1 {
	public static void main(String[] args) {
		Object[] options = {"Agree", "Decline"};
	       int option = JOptionPane.showOptionDialog(null,"Do you want to change to the first class ticket?","Custom Option",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
	       String result;
	       if (option == 0) {
	           result = "Agree";
	       } else if (option == 1) {
	           result = "Decline";
	       } else {
	           result = "Closed";
	       }
	       JOptionPane.showMessageDialog(
	               null,
	               "You've chosen: " + result
	       );
	       System.exit(0);
	}
}
