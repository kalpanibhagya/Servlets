package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	public String DB_URL = "jdbc:mysql://localhost:3306/registration";
	public String DB_USER = "root";
	public String DB_PWD = "";
	
	/*String message = "hello ,you are a valid user"; 
    String invalid_message = "Sorry,invalid";*/
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			Statement stmt =conn.createStatement();
			
			String valsql = "SELECT user_name,city,password,profession FROM reg_user WHERE user_name='"+user+"'";
			ResultSet rs = stmt.executeQuery(valsql);
			
			while(rs.next()){
				String db_user = rs.getString("user_name");
				String dbpw = rs.getString("password");
				String city = rs.getString("city");
				String prof = rs.getString("profession");
	    	
		    	if(user.matches(db_user) && (pwd.matches(dbpw))){
		    		
		    		HttpSession session = request.getSession();
		    		//store user in session object
		    		session.setAttribute("User", db_user);
		    		session.setAttribute("City", city);
		    		session.setAttribute("Profession", prof);
		    		
		    		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request,response);
		    		
		    		/*out.println("<html>");
		    		out.println("<head>");
		    		out.println("<title>Welcome Page</title>");
		    		out.println("</head>");
		    		out.println("<body>");
		    		out.println("<h1>Welcome to ABC Home Page</h1>");
		    		out.println("<p> Welcome " +session.getAttribute("User") + ". Hey you are from <b>"+session.getAttribute("City")+"</b></p>");
		    		out.println("</body>");
		    		out.println("</html>");*/
		    		
		    	}else{
		    		RequestDispatcher rd = request.getRequestDispatcher("registration.html");
					rd.forward(request,response);
		    	}
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
		/*out.println(" ");
		out.println("<html><body>");
		
		if(user.matches("Nimal") && (pwd.matches("1234"))){
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request,response);
			//out.println("<h2>"+message+"</h2>");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("registration.html");
			rd.forward(request,response);
			//out.println("<h2>"+invalid_message+"</h2>");
		}
		
		
		//out.println("welcome "+user);		
		out.println("</body></html>");*/
		
	}

}
