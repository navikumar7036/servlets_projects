package Student_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
int rollno = Integer.parseInt(request.getParameter("hallticketno."));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_memo","root","root");
			Statement st = con.createStatement();
			String sql = "delete from marks_sheet where rollno="+rollno;
			st.executeUpdate(sql);
			PrintWriter pw = response.getWriter();
			pw.println("data successfully deleted...");
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
