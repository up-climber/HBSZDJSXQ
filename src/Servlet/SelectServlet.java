package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.PowerBean;
import Bean.TableBean;
import Bean.UserBean;
import Dao.Get;
import Dao.Select;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
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
        if(method.equals("user"))
        {
        	String username=req.getParameter("username");
        	List<UserBean> userall=Get.getUser(username);
        	java.util.Collections.reverse(userall);
    		req.setAttribute("all", userall);
    		req.getRequestDispatcher("templete/yhgl.jsp").forward(req, resp);
        }
        if(method.equals("power"))
        {
        	String name=req.getParameter("name");
        	List<PowerBean> powerall=Get.getPower(name);
        	java.util.Collections.reverse(powerall);
    		req.setAttribute("all", powerall);
    		req.getRequestDispatcher("templete/jsgl.jsp").forward(req, resp);
        }
        if(method.equals("xssh"))
        {
        	String kjhdlx=req.getParameter("kjhdlx");
        	List<TableBean> tablerall=Get.getTableXssh(kjhdlx);
        	java.util.Collections.reverse(tablerall);
    		req.setAttribute("all", tablerall);
    		req.getRequestDispatcher("templete/xssh.jsp").forward(req, resp);
        }
        if(method.equals("bmsh"))
        {
        	HttpSession session=req.getSession();
            String username=session.getAttribute("username").toString();
        	String kjhdlx=req.getParameter("kjhdlx");
        	Select s=new Select();
        	UserBean ub=s.SelectUser(username);
        	List<TableBean> tablerall=Get.getTableBmsh(kjhdlx,ub.getBm());
        	java.util.Collections.reverse(tablerall);
    		req.setAttribute("all", tablerall);
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
