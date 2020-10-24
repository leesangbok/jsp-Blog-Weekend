package com.cos.blog.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

import utils.Script;

public class PostSearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("keyword") == null || request.getParameter("keyword").equals("")) {
			Script.back(response, "검색키워드가 없습니다.");
			return;
		}
		
		//최초 요청시에는 0, 그뒤부터는 +1 혹은 -1 로 값이 들어옴
		int page = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		
		PostDao postdao= PostDao.getInstance();
		
		List<Post> posts = postdao.글목록(page, keyword);
		int count = postdao.글개수(keyword);
		
		int lastPage = (count%3) == 0?(count/3):(count/3)+1; //true : false
		lastPage = lastPage-1;
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("posts", posts);
		
		RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
		dis.forward(request, response);
	}
	
}
