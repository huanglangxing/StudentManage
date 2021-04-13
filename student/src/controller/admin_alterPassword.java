package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;

/**
 * Servlet implementation class admin_alterPassword
 */
@WebServlet("/admin_alterPassword")
public class admin_alterPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_alterPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");// 获取账号
		String password = request.getParameter("password");// 获取密码
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		Connection connection=new DbUtil().getCon();
		Statement state=null;
		int rs=0;
		String sql="update student set password='" + password + "'where stu_id=" + userid + ";";
		try {
			state = connection.createStatement();
			rs=state.executeUpdate(sql);// 更改数据库
			if(rs==0) {//老师账号
				sql="update teacher set password='" + password + "'where tea_id=" + userid + ";";
				state.executeUpdate(sql);// 更改数据库
			}
			response.sendRedirect("Admin_index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
