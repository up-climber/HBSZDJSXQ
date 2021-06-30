package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.TableBean;
import Dao.Get;
import net.sf.json.JSONArray;
import test.Duotiaojian;

/**
 * Servlet implementation class AllSelectServlet
 */
@WebServlet("/AllSelectServlet")
public class AllSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSelectServlet() {
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
        String username=session.getAttribute("username").toString();
        String method=req.getParameter("method");
        if(method.equals("mybook"))
        {
        	String name[];
    		String value[];
    		String flag1[];
    		String flag2[];
    		name=req.getParameterValues("name");
    		value=req.getParameterValues("value");
    		flag1=req.getParameterValues("binghuo");
    		flag2=req.getParameterValues("jingmo");
    		
    		List<TableBean> tableall=Get.getMyBook(username,"book", name, value, flag1, flag2, name.length);
    		java.util.Collections.reverse(tableall);
    		req.setAttribute("all", tableall);
    		
    		req.getRequestDispatcher("/templete/mywj.jsp").forward(req, resp);
        }
        else if(method.equals("allbook"))
        {
        	String name[];
    		String value[];
    		String flag1[];
    		String flag2[];
    		name=req.getParameterValues("name");
    		value=req.getParameterValues("value");
    		flag1=req.getParameterValues("binghuo");
    		flag2=req.getParameterValues("jingmo");
    		List<TableBean> tableall=Get.getAllBook("book", name, value, flag1, flag2, name.length);
    		List list=Get.getAllNameValue("book", name, value, flag1, flag2, name.length);
    	    req.setAttribute("mapDataJson", JSONArray.fromObject(list));
    		java.util.Collections.reverse(tableall);
    		req.setAttribute("all", tableall);
    		req.getRequestDispatcher("templete/tjcx.jsp").forward(req, resp);
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
