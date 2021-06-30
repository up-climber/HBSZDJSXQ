package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.TableBean;
import Dao.Add;

/**
 * Servlet implementation class tableServlet
 */
@WebServlet("/tableServlet")
public class tableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tableServlet() {
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
        System.out.println(session.getAttribute("username").toString()+"!!!");
        String username=session.getAttribute("username").toString();
        String xssh="Î´ÉóºË";
        String xsshyj="";
        String bmsh="Î´ÉóºË";
        String bmshyj="";
        String jgqc=req.getParameter("jgqc");
        String gkglbm=req.getParameter("gkglbm");
        String txdz=req.getParameter("txdz");
        String szdy=req.getParameter("szdy");
        String wz=req.getParameter("wz");
        String dzyx=req.getParameter("dzyx");
        String frdb=req.getParameter("frdb");
        String yzbm=req.getParameter("yzbm");
        String lxr=req.getParameter("lxr");
        String gddh=req.getParameter("gddh");
        String yddh=req.getParameter("yddh");
        String cz=req.getParameter("cz");
        String jgsx=req.getParameter("jgsx");
        String jgjj=req.getParameter("jgjj");
        String jsxqmc=req.getParameter("jsxqmc");
        String qsnf=req.getParameter("req");
        String jznf=req.getParameter("jznf");
        String zywt=req.getParameter("zywt");
        String jsgj=req.getParameter("jsgj");
        String yqmb=req.getParameter("yqmb");
        String str[]=req.getParameterValues("gjz");
        String gjz="";
        for(int i=0;i<str.length;i++)
        {
        	gjz+=str[i];
        	if(i!=str.length-1)
        	{
        		gjz+="¡¢";
        	}
        }
        
        String ntrzjze=req.getParameter("ntrzjze");
        String jsxqjjfs=req.getParameter("jsx1jjfs");
        String hzyxdw=req.getParameter("hzyxdw");
        String kjhdlx=req.getParameter("kjhdlx");
        String xkfl="";
        String xqjsssly="";
        String xqjsyyhy="";
        if(kjhdlx.equals("»ù´¡ÑÐ¾¿"))
        {
        	String str1[]=req.getParameterValues("xkfl");
            for(int i=0;i<str1.length;i++)
            {
            	xkfl+=str1[i];
            	if(i!=str1.length-1)
            	{
            		xkfl+="¡¢";
            	}
            }
        }
        else
        {
        	xqjsssly=req.getParameter("xqjsssly");
        	String str2[]=req.getParameterValues("xqjsyyhy");
        	for(int i=0;i<str2.length;i++)
            {
        		xqjsyyhy+=str2[i];
            	if(i!=str2.length-1)
            	{
            		xqjsyyhy+="¡¢";
            	}
            }
        }
        
        
       
        String status="Î´ÉóºË";
        String shbm="";
        TableBean tb=new TableBean();
        tb.setUsername(username);
        tb.setXssh(xssh);
        tb.setXsshyj(xsshyj);
        tb.setBmsh(bmsh);
        tb.setBmshyj(bmshyj);
        tb.setJgqc(jgqc);
        tb.setGkglbm(gkglbm);
        tb.setTxdz(txdz);
        tb.setSzdy(szdy);
        tb.setWz(wz);
        tb.setDzyx(dzyx);
        tb.setFrdb(frdb);
        tb.setYzbm(yzbm);
        tb.setLxr(lxr);
        tb.setGddh(gddh);
        tb.setYddh(yddh);
        tb.setCz(cz);
        tb.setJgsx(jgsx);
        tb.setJgjj(jgjj);
        tb.setJsxqmc(jsxqmc);
        tb.setQsnf(qsnf);
        tb.setJznf(jznf);
        tb.setZywt(zywt);
        tb.setJsgj(jsgj);
        tb.setYqmb(yqmb);
        tb.setGjz(gjz);
        tb.setNtrzjze(ntrzjze);
        tb.setJsxqjjfs(jsxqjjfs);
        tb.setHzyxdw(hzyxdw);
        tb.setKjhdlx(kjhdlx);
        
        tb.setXkfl(xkfl);
        
        tb.setXqjsssly(xqjsssly);
        tb.setXqjsyyhy(xqjsyyhy);
        
        tb.setStatus(status);
        tb.setShbm(shbm);
        
        
        Add a=new  Add();
        a.AddTable("book", tb);
        req.setAttribute("message", "Ìí¼Ó³É¹¦");
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
