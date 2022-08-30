package login.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.MemberDAO;
import login.dao.MemberDAOInter;
import login.vo.MemberVO;

public class MemberService implements MemberServiceInter {
	MemberDAOInter dao = new MemberDAO();
	int timeout = 60;
	@Override
	public boolean login(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		MemberVO member = new MemberVO(id, password);
		boolean result=dao.login(member);
		if (result == true) {
			req.getSession().setAttribute("id", req.getParameter("id"));
			req.getSession().setMaxInactiveInterval(timeout);
			System.out.println("로그인 IP :" + req.getRemoteAddr());
			System.out.println("로그인 시간 :" + req.getSession().getCreationTime());
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("로그인 시간 :" + fmt.format(req.getSession().getCreationTime()));
			req.setAttribute("sessiontime", req.getSession().getMaxInactiveInterval());
		}
		return result;
	}

	@Override
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate(); // -> 섹션 해제
		System.out.println("로그아웃 시간 :" + req.getSession().getLastAccessedTime());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("로그아웃 시간 :" + fmt.format(req.getSession().getLastAccessedTime()));
	}

	@Override
	public void addlogin(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setMaxInactiveInterval(timeout);
		req.setAttribute("sessiontime", req.getSession().getMaxInactiveInterval());
	}
	
}
