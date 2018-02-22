package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleCookiesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public SimpleCookiesDemo() {
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=response.getWriter();
			//读取浏览器端发送过来的cookie
			Cookie[] cookies=request.getCookies();
			int v=0;
			String s=null;
			if(cookies!=null){
				boolean flag=false;
				for(Cookie c:cookies){
					String name=c.getName();
					if("count".equals(name)){
						//找到了输出
						v=Integer.parseInt(c.getValue());
						v++;
						s=v+"";
						response.addCookie(new Cookie("count",s));
						out.println(c.getValue());
						out.println("+++++++"+s);
						flag=true;
					}
				}if(!flag){
					//没有找到则添加
					Cookie c=new Cookie("count","0");
							response.addCookie(c);
					
				}
			}else{
				//找不到任何的cookie
				Cookie c=new Cookie("count","0");
				response.addCookie(c);
			}
	
	}

}
