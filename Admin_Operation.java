package QuizCompetition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin_Operation {

	
	public void addQuestion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/quiz";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		// write SQL query
		String sql = "INSERT INTO question(id, questions, alternateOption,correctOption) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		
	    Scanner sc=new Scanner(System.in);
	    System.out.println("how much question you want to add:");
	    int n=sc.nextInt();
	    
	    for(int i=1;i<=n;i++) {
	    	
	    	System.out.println("Enter id");
	    	int id=sc.nextInt();
	    	sc.nextLine();
	    	
	    	System.out.println("Enter "+i+" question:");
	    	String question=sc.nextLine();
	    	
	    	System.out.println("Enter option for "+i+" question");
	    	String option=sc.nextLine();
	    	
	    	System.out.println("Enter correct answer for "+i+" question");
	    	String answer=sc.nextLine();
	    	
	    	ps.setInt(1,id);
	    	ps.setString(2, question);
	    	ps.setString(3, option);
	    	ps.setString(4, answer);
	    	ps.executeUpdate();
	    }
	    
	    System.out.println("Questions are added................");
	    //execute query
	    
	}
	
	public void seeUserData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/quiz";
		String username="root";
		String password="root@123";
		
		//get connection with DB
		Connection connection=DriverManager.getConnection(url,username,password);
		
		// write SQL query
		String sql = "Select * from userRecords";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		System.out.println("----------- User Results -----------");
		while(rs.next()) {
			String name=rs.getString(1);
			int score=rs.getInt(2);
			
			System.out.println(name+" -> "+score);
		}
		
		connection.close();
	}
	
	
}
