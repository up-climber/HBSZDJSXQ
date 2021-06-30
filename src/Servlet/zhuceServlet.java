package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import Dao.Add;

/**
 * Servlet implementation class zhuceServlet
 */
@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuceServlet() {
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
        String role="×¢²á";
        String status="OK";
        UserBean ub=new UserBean();
        ub.setUsername(username);
        ub.setPassword(password);
        ub.setName(name);
        ub.setSfzh(sfzh);
        ub.setSex(sex);
        ub.setBm(bm);
        ub.setSheng(sheng);
        ub.setShi(shi);
        ub.setGzdw(gzdw);
        ub.setZyfx(zyfx);
        ub.setSzhy(szhy);
        ub.setJycd(jycd);
        ub.setZc(zc);
        ub.setTxdz(txdz);
        ub.setYzbm(yzbm);
        ub.setSj(sj);
        ub.setGddh(gddh);
        ub.setYx(yx);
        ub.setQq(qq);
        ub.setRole(role);
        ub.setStatus(status);
        Add a=new Add();
        a.AddUser("user", ub);
        HttpSession session=req.getSession();
        session.setAttribute("username", username);
        req.setAttribute("message", "×¢²á³É¹¦");
        req.getRequestDispatcher("main.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
