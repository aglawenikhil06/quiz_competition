package QuizCompetition;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		Admin_Operation obj=new Admin_Operation();
		User_Operation usObj=new User_Operation();		
	    String chh;
	    
	    do {
		System.out.println("Enter your role ");
		System.out.println("enter 1 admin role");
		System.out.println("enter 2 user role");
		int ch=sc.nextInt();
		
	
		switch(ch) {
		
			case 1: System.out.println("Enter 1 for Add question for quiz");
					System.out.println("Enter 2 to see user results");
					int choice=sc.nextInt();
					if(choice==1) {
						obj.addQuestion();
					}else {
						obj.seeUserData();
					}
			        break;
			        
			case 2:String name=usObj.insertUserData();
				   usObj.startQuiz(name);
				   break;
			
			default:System.out.println("Invalid choice");
					break;
		}
		
		System.out.println("Do you continue(yes/no)");
		chh=sc.next();
		}while(chh.equals("yes") || chh.equals("Yes"));
		
		
	}

}
