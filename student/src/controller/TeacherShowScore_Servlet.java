package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CourseDao;
import model.Teach_course;
import model.Teacher;

/**
 * Servlet implementation class TeacherShowScore
 */
@WebServlet("/TeacherShowScore_Servlet")
public class TeacherShowScore_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherShowScore_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Teacher teacher=(Teacher) session.getAttribute("teacher");
		System.out.println("�ҽ�����");
		try {
			ArrayList<Teach_course> teacherCourseList=CourseDao.Show_teacherCourse_List(teacher.getTea_id());
			System.out.println("������ʦ�γ̳ɼ��б�ɹ�");
			session.setAttribute("teacherCourseList", teacherCourseList);//�����session��
			response.sendRedirect("TeacherShowScoreIndex.jsp");
		} catch (Exception e) {
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
