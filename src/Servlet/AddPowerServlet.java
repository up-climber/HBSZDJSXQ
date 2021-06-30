package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.PowerBean;
import Dao.Add;

/**
 * Servlet implementation class AddPowerServlet
 */
@WebServlet("/AddPowerServlet")
public class AddPowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPowerServlet() {
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
        String name=req.getParameter("name");
        String str1=req.getParameter("xqzj_qx");
        System.out.println("是什么"+str1);
        String str2=req.getParameter("xqgl_qx");
        String str3=req.getParameter("yhxx_qx");
        String str4=req.getParameter("yhxg_qx");
        String str5=req.getParameter("xssh_qx");
        String str6=req.getParameter("bmsh_qx");
        String str7=req.getParameter("tjcx_qx");
        int xqzj_qx=Integer.parseInt(str1);
        int xqgl_qx=Integer.parseInt(str2);
        int yhxx_qx=Integer.parseInt(str3);
        int yhxg_qx=Integer.parseInt(str4);
        int xssh_qx=Integer.parseInt(str5);
        int bmsh_qx=Integer.parseInt(str6);
        int tjcx_qx=Integer.parseInt(str7);
        int power=0;
        PowerBean pb=new PowerBean();
        pb.setName(name);
        pb.setXqzj_qx(xqzj_qx);
        pb.setXqgl_qx(xqgl_qx);
        pb.setYhxx_qx(yhxx_qx);
        pb.setYhxg_qx(yhxg_qx);
        pb.setXssh_qx(xssh_qx);
        pb.setBmsh_qx(bmsh_qx);
        pb.setTjcx_qx(tjcx_qx);
        pb.setPower(power);
        Add a=new Add();
        a.AddPower("power", pb);
        req.setAttribute("message", "添加成功");
        req.getRequestDispatcher("templete/open.jsp").forward(req, resp);
        		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
