import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();	
		Scanner scnr = new Scanner(System.in);
		String response;
		System.out.println("Josephus - N. Hoang\n");
		
		do {
		try {	
		System.out.print("How many members of the group? ");
		int members = scnr.nextInt();
		System.out.print("What is the skip count? ");
		int skip = scnr.nextInt();
		scnr.nextLine();
		
		for (int i = 0; i < members; queue.add(i+1), i++);
		
		while (queue.size() > 1) {
			for (int i = 1; i <= skip; i++) {
				if (i == skip)
					queue.remove();
				else 
					queue.add(queue.remove());				
				}
		}
		System.out.println("You want to be in position #" + queue.element()); 
		queue.clear();
		System.out.print("\nAgain [Y/N]? ");
		response = scnr.nextLine();
		System.out.println();
		
		} catch (InputMismatchException e) {
			System.out.println("Please enter an integer.");
			response = "Y";
			scnr.nextLine();
		}
		} while(response.equalsIgnoreCase("Y"));
		
		System.out.println("Goodbye and Good luck!");
		scnr.close();
	}

}
