package Student_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HallTicket")
public class HallTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno = Integer.parseInt(request.getParameter("hallticketno."));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_memo","root","root");
			Statement st = con.createStatement();
			String sql = "select * from marks_sheet where rollno="+rollno;
			
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			
			PrintWriter pw= response.getWriter();
			pw.println("Hall Ticket No :"+rs.getInt(1));
			pw.println("Name :"+rs.getString(2));
			pw.println("Telugu :"+rs.getInt(3));
			pw.println("Hindi :"+rs.getInt(4));
			pw.println("English:"+rs.getInt(5));
			pw.println("Maths:"+rs.getInt(6));
			pw.println("Science :"+rs.getInt(7));
			pw.println("Social:"+rs.getInt(8));
			
			int total = rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8);
			pw.println("Total :"+total);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		}
	}


