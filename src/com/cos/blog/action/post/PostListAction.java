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

public class PostListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tempPage = request.getParameter("page");
		int page = 0;
		
		if(tempPage == null) {
			page = 0;
		}else {
			page = Integer.parseInt(tempPage);
		}
		
		PostDao postDao = PostDao.getInstance();
		List<Post> posts = postDao.글목록(page);
		
		int count = postDao.글개수();
		
		int lastPage = (count%3) == 0?(count/3):(count/3)+1; //true : false
		lastPage = lastPage-1;
		
		System.out.println("lastPage "+lastPage);
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("posts", posts);
		
		RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
		dis.forward(request, response);
	}
}




