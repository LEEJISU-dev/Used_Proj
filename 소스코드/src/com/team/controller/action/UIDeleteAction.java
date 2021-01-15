package com.team.controller.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.PageDAO;
import com.team.dto.PageVO;

public class UIDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/Main.jsp";
		PageDAO pDao = PageDAO.getInstance();
		PageVO pVo = new PageVO();
		
		HttpSession session = request.getSession();
		
		pDao.deleteMember((String)session.getAttribute("UserId"));
		session.removeAttribute("UserId");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
