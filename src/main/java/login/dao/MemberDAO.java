package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.vo.MemberVO;

public class MemberDAO implements MemberDAOInter {

	Connection conn;
	PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "shin", "9971");
		} catch (Exception e) {
			System.out.println("Data Base 접속 관련 오류");
			e.printStackTrace();
		}
	}

	public int insert(MemberVO member) {
		String sql = null;
		int result = 0;
		try {
			sql = "insert into member values(member_idx_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Data Base 입력 오류");
			e.printStackTrace();
		}
		return result;
	}

	public List<MemberVO> findAll() {
		String sql = null;
		ResultSet result = null;
		List<MemberVO> list = null;
		try {
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();

			list = new ArrayList();

			while (result.next()) {
				MemberVO vo = new MemberVO();
				vo.setIdx(result.getInt("idx"));
				vo.setId(result.getString("id"));
				vo.setPassword(result.getString("password"));
				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("Data Base 입력받기 오류");
			e.printStackTrace();
		}
		return list;
	}

	public MemberVO findOne(int idx) {
		String sql = null;
		ResultSet result = null;
		MemberVO member = null;
		try {
			sql = "select * from member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeQuery();

			if (result.next()) {
				member = new MemberVO(result.getInt("idx"), result.getString("id"), result.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("Data Base 찾기 오류");
			e.printStackTrace();

		}
		return member;
	}

	public int update(MemberVO member) {
		String sql = null;
		int result = 0;
		try {
			sql = "update member set password=? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setInt(2, member.getIdx());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Data Base 업데이트 오류");
			e.printStackTrace();
		}
		return result;
	}

	public int delete(int idx) {
		String sql = null;
		int result = 0;
		try {
			sql = "delete from member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Data Base 삭제 오류");
			e.printStackTrace();
		}
		return result;
	}

	public boolean exist(int idx) {
		try {
			if (findOne(idx) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}
		return false;
	}

	public MemberVO findOne(String id) {
		String sql = null;
		ResultSet result = null;
		MemberVO vo = null;
		try {
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();

			if (result.next()) {
				vo = new MemberVO(result.getInt("idx"), result.getString("id"), result.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("Data Base 찾기 오류");
			e.printStackTrace();

		}
		return vo;
	}

	public int updateById(MemberVO member) {
		String sql = null;
		int result = 0;
		try {
			sql = "update member set password=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setInt(2, member.getIdx());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Data Base 업데이트 오류");
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String id) {
		String sql = null;
		int result = 0;
		try {
			sql = "delete from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Data Base 삭제 오류");
			e.printStackTrace();
		}
		return result;
	}

	public boolean exist(String id) {
		if (findOne(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(MemberVO member) {
		String sql = null;
		ResultSet result = null;
		try {
			sql = "select * from member where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			result = pstmt.executeQuery();

			if (result.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("로그인 오류");
			e.printStackTrace();

		}
		return false;
	}
}
