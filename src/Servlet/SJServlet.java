package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Bean.SJBean;
import Dao.Get;

/**
 * Servlet implementation class SJServlet
 */
@WebServlet("/SJServlet")
public class SJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SJServlet() {
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
        String function=req.getParameter("function");
        String value=req.getParameter("value");
        List<SJBean> list ;
        if(function.equals("xktwo"))
        {
        	list=Get.getSJ("xkfl", "xk2","xk1" ,value );
        	
        }
        
        else if(function.equals("xkthree"))
        {
        	list=Get.getSJ("xkfl", "xk3", "xk2", value);
        }
        else if(function.equals("hytwo"))
        {
        	list=Get.getSJ("yyhy", "hy2", "hy1", value);
        }
        else
        {
        	list=Get.getSJ("yyhy", "hy3", "hy2", value);
        }
        Gson gson = new Gson();
        System.out.println("???");
        String json = gson.toJson(list);
        System.out.println("JsonÕÍ¡À");
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
