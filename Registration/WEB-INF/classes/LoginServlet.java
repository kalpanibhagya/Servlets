import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>First Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Hello world</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	
	

}