package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Bean.PowerBean;
import Bean.UserBean;
import Dao.Select;

/**
 * Servlet implementation class PowerServlet
 */
@WebServlet("/PowerServlet")
public class PowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerServlet() {
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
        HttpSession session=req.getSession();
        System.out.println(session.getAttribute("username").toString()+"???");
        String username=session.getAttribute("username").toString();
        Select s=new Select();
        UserBean ub=s.SelectUser(username);
        String roleName=ub.getRole();
        PowerBean pb=s.SelectPower(roleName);
        List<PowerBean> list=new ArrayList<PowerBean>();
        list.add(pb);
        System.out.println(pb.getPower());
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try {

        	resp.getWriter().println(json);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	resp.getWriter().close();
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
