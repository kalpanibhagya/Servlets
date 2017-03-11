package pk1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String DB_URL = "jdbc:mysql://localhost:3306/registration";
	public String DB_USER = "root";
	public String DB_PWD = "";
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String full_name = request.getParameter("fullname");
		String city = request.getParameter("city");
		String sex = request.getParameter("gender");
		String email= request.getParameter("email");
		String tele = request.getParameter("phone");
		String prof = request.getParameter("profession");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			Statement stmt =conn.createStatement();
			
			String insert = "INSERT INTO reg_user (user_name,password,full_name,city,sex,email,tele,profession) VALUES ('"+username+"','"+password+"','"+full_name+"','"+city+"','"+sex+"','"+email+"','"+tele+"','"+prof+"')";
			stmt.executeUpdate(insert);
			
			response.sendRedirect("insert_message.html");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}

}
