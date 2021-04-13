package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Score;
import util.DbUtil;

public class ScoreDao {
	private static Connection conn = null;

	public static ArrayList<Score> Show_Score_List(String stu_id) throws Exception {
		ArrayList<Score> myScoreList = new ArrayList<Score>();
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		String sql = "select * from Score where stu_id = '" + stu_id + "'";
		state = conn.createStatement();
		System.out.println("准备查询成绩");
		rs = state.executeQuery(sql);
		while (rs.next()) {
			Score score = new Score();
			score.setCourse_id(rs.getString("course_id"));
			score.setStu_id(rs.getString("stu_id"));
			score.setScore(rs.getString("score"));
			score.setCourse_name(rs.getString("course_name"));
			myScoreList.add(score);
		}
		conn.close();
		return myScoreList;
	}
}
