package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Select;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String username=req.getParameter("user");
        String password=req.getParameter("pwd");
        HttpSession session=req.getSession();
        String randNumber=session.getAttribute("rand").toString();
        String randcode=req.getParameter("randcode");
        Select s=new Select();
        if(s.SelectLogin(username, password)&&randNumber.equals(randcode))
        {
        	session.setAttribute("username", username);
        	req.setAttribute("message", "µ«¬º≥…π¶");
        	System.out.println(session.getAttribute("username").toString());
        	req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else
        {
        	if(s.SelectLogin(username, password))
        	{
        		req.setAttribute("message", "’À∫≈ªÚ√‹¬Î”–ŒÛ");
            	req.getRequestDispatcher("login.jsp").forward(req, resp);
        	}
        	else
        	{
        		req.setAttribute("message", "—È÷§¬Î¥ÌŒÛ");
            	req.getRequestDispatcher("login.jsp").forward(req, resp);
        	}
        }
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
