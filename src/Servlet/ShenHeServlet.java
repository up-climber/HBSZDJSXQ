package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TableBean;
import Dao.Change;
import Dao.Select;

/**
 * Servlet implementation class ShenHeServlet
 */
@WebServlet("/ShenHeServlet")
public class ShenHeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShenHeServlet() {
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
        String method=req.getParameter("method");
        if(method.equals("xssh"))
        {
        	String id=req.getParameter("id");
        	Select s=new Select();
        	TableBean tb=s.SelectTable(id);
        	System.out.println(tb.getKjhdlx());
        	req.setAttribute("table", tb);
        	req.getRequestDispatcher("templete/xsshtable.jsp").forward(req, resp);
        	
        }
        if(method.equals("xsshed"))
        {
        	String id=req.getParameter("id");
        	String xssh=req.getParameter("xssh");
        	String xsshyj=req.getParameter("xsshyj");
        	String shbm=req.getParameter("shbm");
        	Change c=new Change();
        	c.change("book", "xssh", "id", xssh, id);
        	c.change("book", "xsshyj", "id", xsshyj, id);
        	c.change("book", "shbm", "id", shbm, id);
        	req.setAttribute("message", "审核成功");
        	req.getRequestDispatcher("templete/xssh.jsp").forward(req, resp);
        }
        if(method.equals("bmsh"))
        {
        	String id=req.getParameter("id");
        	Select s=new Select();
        	TableBean tb=s.SelectTable(id);
        	System.out.println(tb.getKjhdlx());
        	req.setAttribute("table", tb);
        	req.getRequestDispatcher("templete/bmshtable.jsp").forward(req, resp);
        	
        }
        if(method.equals("bmshed"))
        {
        	String id=req.getParameter("id");
        	String bmsh=req.getParameter("bmsh");
        	String bmshyj=req.getParameter("bmshyj");
        	Change c=new Change();
        	c.change("book", "bmsh", "id", bmsh, id);
        	c.change("book", "bmshyj", "id", bmshyj, id);
        	req.setAttribute("message", "审核成功");
        	req.getRequestDispatcher("templete/bmsh.jsp").forward(req, resp);
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
