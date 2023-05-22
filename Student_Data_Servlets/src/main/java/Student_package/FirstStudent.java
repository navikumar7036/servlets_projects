package Student_package;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstStudent")
public class FirstStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno = Integer.parseInt(request.getParameter("hallticketno"));
		String name = request.getParameter("name");
		int Tel = Integer.parseInt(request.getParameter("tel"));
		int Hin = Integer.parseInt(request.getParameter("hid"));
		int Eng= Integer.parseInt(request.getParameter("eng"));
		int Mat = Integer.parseInt(request.getParameter("maths"));
		int Sci= Integer.parseInt(request.getParameter("science"));
		int Soci =Integer.parseInt(request.getParameter("social"));
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_memo","root","root");
			Statement st = con.createStatement();
			String sql = "insert into marks_sheet values("+rollno+",'"+name+"',"+Tel+","+Hin+","+Eng+","+Mat+","+Sci+","+Soci+")";
			st.executeUpdate(sql);
			st.executeUpdate("commit");
			
			PrintWriter pw= response.getWriter();
			pw.println("Record is inserted");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		}
		
	}


