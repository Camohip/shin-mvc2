package test;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		/*
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("사과","aplle");
		map.put("오렌지","orange");
		map.put("망고","manggo");
		map.put("바나나","banana");
		
		System.out.println(map.get("사과"));
		*/
		
		HashMap<String, String>map=new HashMap<String, String>();
		/*
		map.put("/index","/WEB-INF/index.jsp");
		map.put("/login/login","/WEB-INF/login/login.jsp");
		map.put("/login/join","/WEB-INF/login/join.jsp");
		map.put("/login/addlogin","/WEB-INF/home/main.jsp");
		*/
		String page=".home/login.jsp";
		System.out.println(map.get(page));
	}

}
