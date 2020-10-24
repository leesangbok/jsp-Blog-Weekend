package com.cos.blog.action.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

import utils.Script;

public class PostSaveProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) return;
		
		// 2. 공백, null 확인
		
		// 3. 값 검증 ( title에 <  > 코드가 들어오는걸 방지 )
		String title = request.getParameter("title");
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String content = request.getParameter("content");
		
		Post post = new Post(
				title,
				content,
				0,
				userId
		);
		
		PostDao postDao = PostDao.getInstance();
		int result = postDao.글쓰기(post);
		
		
		if(result == 1) {
			//BufferedWriter는 내려쓰기가 없다.("안녕 \n")
			Script.href(response, "/", "글쓰기 성공");
			
		}else {
			Script.back(response, "글쓰기 실패");
		}
		
		//response.sendRedirect("index.jsp");
	}
}



