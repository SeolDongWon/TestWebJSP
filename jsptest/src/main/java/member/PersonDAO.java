package member;

import java.sql.*;
import java.util.*;

import jdbc.ConnectionPool;

public class PersonDAO {

	public PersonDAO() {

	}

	public Vector<PersonVO> getMemberList() {
		ConnectionPool pool = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector<PersonVO> personList = new Vector<PersonVO>();
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.getConnection();
			String strQuery = "select * from TempMember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				PersonVO person = new PersonVO();
				person.setId(rs.getString("id"));
				person.setName(rs.getString("name"));
				person.setEmail(rs.getString("email"));
				personList.add(person);
			}
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return personList;
	}
}