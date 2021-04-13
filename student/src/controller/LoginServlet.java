package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import model.Admin;
import model.Student;
import model.Teacher;
import util.DbUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// ���������ݿ������
		Connection connection = new DbUtil().getCon();
		// ����ǰ̨������ֵ �˺ź�����
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");// ��ȡ�˺�
		String password = request.getParameter("password");// ��ȡ����
		String user = request.getParameter("user");// �ж��û���ݣ�ѧ�����ǹ���Ա
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		if (user == null || password == null) {// δ�����˺Ż�������
			System.out.println("��¼ʧ�ܣ�");
			out.print("<script>alert('账号或密码不能为空！');" + "window.location.href='../index.jsp'</script>");
		} else {
			if (user.equals("student")) {// ѧ����¼ʱ
				try {
					System.out.println("1");
					Student student = UserDao.findstudent(userid);
					if (student.getPassword().equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("student", student);
						System.out.println("��¼�ɹ���");
						response.sendRedirect("Student_index.jsp");
					} else {
						System.out.println("��¼ʧ�ܣ�");
						out.print("<script>alert('��¼ʧ�ܣ���ȷ���˺ź�����');"
								+ "window.location.href='../index.jsp'</script>");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (user.equals("teacher")) {// ����Ա��¼ʱ
				try {
					Teacher teacher = UserDao.findteacher(userid);
					if (teacher.getPassword().equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("teacher", teacher);
						System.out.println("��¼�ɹ���");
						response.sendRedirect("Teacher_index.jsp");
					} else {
						System.out.println("��¼ʧ�ܣ�");
						out.print("<script>alert('��¼ʧ�ܣ���ȷ���˺ź�����');"
								+ "window.location.href='../index.jsp'</script>");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} //
			else {// ����Ա��¼ʱ
				try {
					Admin admin = UserDao.findadmin(userid);
					if (admin.getAdmin_password().equals(password)) {
						HttpSession session = request.getSession();
						session.setAttribute("admin", admin);
						System.out.println("��¼�ɹ���");
						response.sendRedirect("Admin_index.jsp");
					} else {
						System.out.println("��¼ʧ�ܣ�");
						out.print("<script>alert('��¼ʧ�ܣ���ȷ���˺ź�����');"
								+ "window.location.href='../index.jsp'</script>");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
