package QuizCompetition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User_Operation {

	public String insertUserData() throws ClassNotFoundException, SQLException  {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/quiz";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		// write SQL query
		String sql = "INSERT INTO userRecords(name) VALUES (?)";
		 
	    PreparedStatement ps = connection.prepareStatement(sql);
	    Scanner sc=new Scanner(System.in);
	    
	    System.out.println("Enter your name: ");
	    String name=sc.next();
	    
	    ps.setString(1, name);
	    	    
	    
	    //execute query
	    ps.executeUpdate();
	    
	    
	    System.out.println("Data Inserted Sucessfully......");
	    //close connection
	  
	    return name;
	}
	
	
	public void startQuiz(String name) throws ClassNotFoundException, SQLException {
		System.out.println("*************");
		System.out.println("Start Quiz");
		System.out.println("*************");
		System.out.println();
		System.out.println("                      ---------------------");
		System.out.println("                      |   QUIZ Question   |");
		System.out.println("                      ---------------------");
		Scanner sc=new Scanner(System.in);
		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/quiz";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		// write SQL query
		String sql = "Select questions, alternateOption,correctOption from question ORDER BY RAND() LIMIT 5";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int score=0;
		int total=0;
		while(rs.next()) {
		    total++;
			System.out.println("-----------------------------------------------------------------------");
			String question=rs.getString(1);
			String option=rs.getString(2);
			String correctOption=rs.getString(3);
			
			System.out.println(question);
			System.out.println(option);
			
			System.out.println("Enter your answer:");
			String answer=sc.nextLine();
			
			if(answer.equalsIgnoreCase(correctOption)) {
				System.out.println("Answer is correct");
				score++;
			}else {
				System.out.println("Answer is wrong, Correct answer is:"+correctOption);
			}
			
		}
		
		System.out.println("*****************************************");
		System.out.println("your score of quiz is: "+score+" / "+total);
		System.out.println("*****************************************");
		
		String updateScore="UPDATE userRecords SET score = ? WHERE name = ?";
		PreparedStatement psUpdate = connection.prepareStatement(updateScore);
		psUpdate.setInt(1, score);
		psUpdate.setString(2, name);
		psUpdate.executeUpdate();
	}
}
