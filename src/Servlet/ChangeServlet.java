package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.PowerBean;
import Bean.UserBean;
import Dao.Add;
import Dao.Change;
import Dao.Select;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
        	Select s=new Select();
        	UserBean ub=s.SelectUser(username);
        	req.setAttribute("user", ub);
        	req.getRequestDispatcher("templete/ChangeUser.jsp").forward(req, resp);
        	
        }
        if(method.equals("usered"))
        {
        	String username =req.getParameter("username");
    		System.out.println(username);
            String password=req.getParameter("password");
            String name=req.getParameter("name");
            String sfzh=req.getParameter("sfzh");
            String sex=req.getParameter("sex");
            String bm=req.getParameter("bm");
            String sheng=req.getParameter("sheng");
            String shi=req.getParameter("shi");
            String gzdw=req.getParameter("gzdw");
            String zyfx=req.getParameter("zyfx");
            String szhy=req.getParameter("szhy");
            String jycd=req.getParameter("jycd");
            String zc=req.getParameter("zc");
            String txdz=req.getParameter("txdz") ;
            String yzbm=req.getParameter("yzbm");
            String sj=req.getParameter("sj");
            String gddh=req.getParameter("gddh");
            String yx=req.getParameter("yx");
            String qq=req.getParameter("qq");
            String role=req.getParameter("role");
            String status=req.getParameter("status");
            Change c=new Change();
            c.change("user", "password", "username", password, username);
            c.change("user", "name", "username", name, username);
            c.change("user", "sfzh", "username", sfzh, username);
            c.change("user", "sex", "username", sex, username);
            c.change("user", "bm", "username", bm, username);
            c.change("user", "sheng", "username", sheng, username);
            c.change("user", "shi", "username", shi, username);
            c.change("user", "gzdw", "username", gzdw, username);
            c.change("user", "zyfx", "username", zyfx, username);
            c.change("user", "szhy", "username", szhy, username);
            c.change("user", "jycd", "username", jycd, username);
            c.change("user", "zc", "username", zc, username);
            c.change("user", "txdz", "username", txdz, username);
            c.change("user", "yzbm", "username", yzbm, username);
            c.change("user", "sj", "username", sj, username);
            c.change("user", "gddh", "username", gddh, username);
            c.change("user", "yx", "username", yx, username);
            c.change("user", "qq", "username", qq, username);
            c.change("user", "role", "username", role, username);
            c.change("user", "status", "username", status, username);
            req.setAttribute("message", "修改成功");
            req.getRequestDispatcher("templete/yhgl.jsp").forward(req,resp);
        }
        if(method.equals("power"))
        {
        	String name=req.getParameter("name");
        	Select s=new Select();
        	PowerBean pb=s.SelectPower(name);
        	pb.setName(name);
        	req.setAttribute("power", pb);
        	req.getRequestDispatcher("templete/ChangePower.jsp").forward(req, resp);
        }
        if(method.equals("powered"))
        {
        	String name=req.getParameter("name");
            String xqzj_qx=req.getParameter("xqzj_qx");
            String xqgl_qx=req.getParameter("xqgl_qx");
            String yhxx_qx=req.getParameter("yhxx_qx");
            String yhxg_qx=req.getParameter("yhxg_qx");
            String xssh_qx=req.getParameter("xssh_qx");
            String bmsh_qx=req.getParameter("bmsh_qx");
            String tjcx_qx=req.getParameter("tjcx_qx");
            Change c=new Change();
            c.change("power", "xqzj_qx", "name", xqzj_qx, name);
            c.change("power", "xqgl_qx", "name", xqgl_qx, name);
            c.change("power", "yhxx_qx", "name", yhxx_qx, name);
            c.change("power", "yhxg_qx", "name", yhxg_qx, name);
            c.change("power", "xssh_qx", "name", xssh_qx, name);
            c.change("power", "bmsh_qx", "name", bmsh_qx, name);
            c.change("power", "tjcx_qx", "name", tjcx_qx, name);
            req.setAttribute("message", "修改成功");
            req.getRequestDispatcher("templete/jsgl.jsp").forward(req, resp);
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
