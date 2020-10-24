package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;

import utils.Script;

public class UserLogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 무효화
		// 2. 메인 페이지 이동 Redirect
		HttpSession session = request.getSession();
		session.invalidate();
		Script.href(response, "/", "로그아웃 하셨습니다");
	}

}
