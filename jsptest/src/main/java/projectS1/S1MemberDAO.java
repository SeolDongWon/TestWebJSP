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
				s1MV.setMainAddress(rs.getString("mainaddress"));
				s1MV.setDetailAddress(rs.getString("detailaddress"));
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
				"insert into projects1member(id, password, name, birthday, tel, postcode, mainaddress,detailaddress) values(?,?,?,?,?,?,?,?)");
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, s1MVO.getId());
			pstmt.setString(2, s1MVO.getPassword());
			pstmt.setString(3, s1MVO.getName());
			pstmt.setString(4, s1MVO.getBirthday());
			pstmt.setString(5, s1MVO.getTel());
			pstmt.setString(6, s1MVO.getPostcode());
			pstmt.setString(7, s1MVO.getMainAddress());
			pstmt.setString(8, s1MVO.getDetailAddress());
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
				s1MV.setMainAddress(rs.getString("mainaddress"));
				s1MV.setDetailAddress(rs.getString("detailaddress"));
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

	public synchronized void updateMemberList(S1MemberVO s1MVO) {
		ConnectionPool pool = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		pool = ConnectionPool.getInstance();
		sql.append(
				"update projects1member set password=?, name=?, birthday=?, tel=?, postcode=?, mainaddress=?,detailaddress=? where id=?");
		try {
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, s1MVO.getPassword());
			pstmt.setString(2, s1MVO.getName());
			pstmt.setString(3, s1MVO.getBirthday());
			pstmt.setString(4, s1MVO.getTel());
			pstmt.setString(5, s1MVO.getPostcode());
			pstmt.setString(6, s1MVO.getMainAddress());
			pstmt.setString(7, s1MVO.getDetailAddress());
			pstmt.setString(8, s1MVO.getId());
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

	public int deleteMember(String id, String pass) {
		System.out.println(id);
		System.out.println(pass);
		ConnectionPool pool = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		pool = ConnectionPool.getInstance();
		int result = 0; // 결과치

		try {
			conn = pool.getConnection();
				pstmt = conn.prepareStatement("delete from projects1member where id=? and password=?");
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				if (0 < pstmt.executeUpdate()) {
				result = 1;// 회원탈퇴 성공
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
		return result;
	}

}
