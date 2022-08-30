package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import login.dao.MemberDAO;
import login.vo.MemberVO;

public class MemberDAO_Test1 {
	static MemberDAO dao;
	public MemberDAO_Test1() {
		dao=new MemberDAO();
	}	
	@Test
	public void Inserttest() {
		assertEquals(1, dao.insert(new MemberVO("test","1111")));
	}
	@Test
	public void Deletetest() {
		assertEquals(1, dao.delete("test"));
	}
	@Test
	public void Existtest() {
		assertTrue(dao.exist("test"));
	}
	@Test
	public void FindOnetest() {
		assertNotNull(dao.findOne(""));
	}
}
