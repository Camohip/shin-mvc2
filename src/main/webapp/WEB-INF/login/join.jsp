<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<main>
<div class="container">
		<form name="forms" action="creatememberProc.jsp" method="post">

			<div class="form-group">
				<label for="name">이름</label> <input type="text" class="form-control"
					id="name" name="name" placeholder="이름">
			</div>
			<div class="form-group">
				<label for="jumin">주민번호</label> <input type="text" class="form-control"
					id="jumin" name="jumin" placeholder="주민번호 '-'없이 입력하시오.">
			</div>
			<div class="form-group">
				<label for="addr">주소</label> <input type="text" class="form-control"
					id="addr" name="addr" placeholder="주소">
			</div>
			<div class="form-group">
				<label for="id">아이디</label> <input type="text" class="form-control"
					id="id" name="id" placeholder="아이디">
			</div>
			<div class="form-group">
				<label for="password">패스워드</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="패스워드">
			</div>
			<div class="form-group">
				<label for="password">패스워드</label> <input type="password"
					class="form-control" id="repassword" name="repassword"
					placeholder="패스워드재입력">
			</div>
			<a href="/login/join.jsp">회원가입</a>
			<input type="button" onclick="back()" value="뒤로가기">
		</form>
	</div>
	</main>