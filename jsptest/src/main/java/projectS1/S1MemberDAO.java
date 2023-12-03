package projectS1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionPool;

public class S1MemberDAO {

	public S1MemberDAO() {
		super();
	}

	public S1MemberVO LoginCheck(S1MemberVO s1MVO) {
		S1MemberVO s1MV = null;
		ConnectionPool pool = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		pool = ConnectionPool.getInstance();
		sql.append("select * from projects1member where id=? and password=?");

		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, s1MVO.getId());
			pstmt.setString(2, s1MVO.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				s1MV = new S1MemberVO();
				s1MV.setId(rs.getString("id"));
				s1MV.setPassword(rs.getString("password"));
				s1MV.setName(rs.getString("name"));
				s1MV.setBirthday(rs.getString("birthday"));
				s1MV.setTel(rs.getString("tel"));
				s1MV.setPostcode(rs.getString("postcode"));
				s1MV.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return s1MV;

	}

	public synchronized void setMemberList(S1MemberVO s1MVO) {
		ConnectionPool pool = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		pool = ConnectionPool.getInstance();
		sql.append(
				"insert into projects1member(id, password, name, birthday, tel, postcode, address) values(?,?,?,?,?,?,?)");
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, s1MVO.getId());
			pstmt.setString(2, s1MVO.getPassword());
			pstmt.setString(3, s1MVO.getName());
			pstmt.setString(4, s1MVO.getBirthday());
			pstmt.setString(5, s1MVO.getTel());
			pstmt.setString(6, s1MVO.getPostcode());
			pstmt.setString(7, s1MVO.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized ArrayList<S1MemberVO> getMemberList() {
		ArrayList<S1MemberVO> arrList = new ArrayList<S1MemberVO>();
		ConnectionPool pool = null;
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		S1MemberVO s1MV = null;
		pool = ConnectionPool.getInstance();
		sql.append("select * from projects1member");
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				s1MV = new S1MemberVO();
				s1MV.setId(rs.getString("id"));
				s1MV.setPassword(rs.getString("password"));
				s1MV.setName(rs.getString("name"));
				s1MV.setBirthday(rs.getString("birthday"));
				s1MV.setTel(rs.getString("tel"));
				s1MV.setPostcode(rs.getString("postcode"));
				s1MV.setAddress(rs.getString("address"));
				arrList.add(s1MV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrList;
	}

	public Boolean idDuplicateCheck(String id) {
		System.out.println("SMDA.idDupCheck : " + id);
		boolean idCheck = false;

		ConnectionPool connPool = null;
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pstmt = null;
		connPool = ConnectionPool.getInstance();
		sql.append("select * from projects1member where id=?");
		try {
			conn = connPool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			if (0 != pstmt.executeUpdate()) {
				idCheck = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return idCheck;
	}
}