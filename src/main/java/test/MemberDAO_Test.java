package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import login.dao.MemberDAO;
import login.vo.MemberVO;

public class MemberDAO_Test {
	static MemberDAO dao;
	public MemberDAO_Test() {
		dao=new MemberDAO();
	}
	//@BeforeClass
	@Test
	public void Inserttest() {
		assertEquals(1, dao.insert(new MemberVO("test1","1111")));
	}
	//@Test
	public void Deletetest() {
		assertEquals(1, dao.delete("test1"));
	}
	@Test
	public void Existtest() {
		assertTrue(dao.exist("admin"));
	}
	
}
