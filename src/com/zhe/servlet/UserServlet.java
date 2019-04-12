package com.zhe.servlet;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.zhe.pojo.Sick;
import com.zhe.pojo.User;
import com.zhe.service.SickService;
import com.zhe.service.UserService;
import com.zhe.service.impl.SickServiceImpl;
import com.zhe.service.impl.UserServiceImpl;
/**
 * Servlet重定向路径总结
 * 		相对路径：从当前请求的路径资源查找资源的路径
 * 			相对路径如果是servlet的别名中包含目录，会造成重定向资源查找失败
 * 		绝对路径：第一个/表示服务器根目录
 * 			/虚拟项目名/资源路径
 * servlet请求转发
 * 		/表示项目根目录
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
 * 
 * 
 * @author yzxlz
 *
 */
public class UserServlet extends HttpServlet {
	//声明日志对象
	Logger logger=Logger.getLogger(UserServlet.class);
	//获取service层对象
	UserService us=new UserServiceImpl();
	SickService ss=new SickServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=req.getParameter("oper");
		if ("login".equals(oper)) {
			//调用登陆处理方法
			checkUserLogin(req,resp);
		}else if ("reg".equals(oper)) {
			//调用注册功能
			userReg(req,resp);
		}else if ("out".equals(oper)) {
			//调用退出功能
			userOut(req,resp);
		}else if ("pwd".equals(oper)) {
			//调用密码修改功能
			userChangePwd(req,resp);
		}else if ("show".equals(oper)) {
			//调用显示所有用户功能
			userShow(req,resp);
		}else if ("gao".equals(oper)){
			//调用显示高血压病人信息
			gaoShow(req, resp);
		}else if ("tang".equals(oper)){
			//调用显示高血压病人信息
			tangShow(req, resp);
		}else if ("wei".equals(oper)){
			//调用显示高血压病人信息
			weiShow(req, resp);
		}else if ("delete".equals(oper)){
			//删除高血压病人信息
			//gaoDelete(req, resp);
		}else if ("deleteW".equals(oper)){
			//删除胃病病人信息
			weiDelete(req, resp);
		}else if ("weiAdd".equals(oper)) {
			weiAdd(req,resp);
		}else if ("gaoAdd".equals(oper)) {
			gaoAdd(req,resp);
		}else if ("tangAdd".equals(oper)) {
			tangAdd(req,resp);
		}
		
		else{
			logger.debug("没有找到对应的操作符："+oper);
		}
		
		
		
	}
	private void tangAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id=req.getParameter("tid")!=""?Integer.parseInt(req.getParameter("tid")):0;
		String uname=req.getParameter("tname");
		int age=req.getParameter("tage")!=""?Integer.parseInt(req.getParameter("tage")):0;
		String sex=req.getParameter("tsex");
		String dis=req.getParameter("tdis");
		String adv=req.getParameter("tadv");
		
		Sick s=new Sick(id, uname, sex, age, dis, adv);
		System.out.println(s);
		//处理请求信息
			//调用业务层
			int index=ss.tangAddService(s);
			System.out.println(index);
		//响应处理信息
			if(index>0){
				
				resp.sendRedirect("/sm/user/addSuc.jsp");
			}
		
	}
	private void gaoAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id=req.getParameter("gid")!=""?Integer.parseInt(req.getParameter("gid")):0;
		String uname=req.getParameter("gname");
		int age=req.getParameter("gage")!=""?Integer.parseInt(req.getParameter("gage")):0;
		String sex=req.getParameter("gsex");
		String dis=req.getParameter("gdis");
		String adv=req.getParameter("gadv");
		
		Sick s=new Sick(id, uname, sex, age, dis, adv);
		System.out.println(s);
		//处理请求信息
			//调用业务层
			int index=ss.gaoAddService(s);
			System.out.println(index);
		//响应处理信息
			if(index>0){
				
				resp.sendRedirect("/sm/user/addSuc.jsp");
			}
		
	}
	private void weiAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id=req.getParameter("wid")!=""?Integer.parseInt(req.getParameter("wid")):0;
		String uname=req.getParameter("wname");
		int age=req.getParameter("wage")!=""?Integer.parseInt(req.getParameter("wage")):0;
		String sex=req.getParameter("wsex");
		String dis=req.getParameter("wdis");
		String adv=req.getParameter("wadv");
		
		Sick s=new Sick(id, uname, sex, age, dis, adv);
		System.out.println(s);
		//处理请求信息
			//调用业务层
			int index=ss.weiAddService(s);
			System.out.println(index);
		//响应处理信息
			if(index>0){
				
				resp.sendRedirect("/sm/user/addSuc.jsp");
			}
			
		
	}
	private void weiDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		//处理请求信息
		//调用业务层
		int index=ss.weiDelService(id);
		System.out.println(index);
	//响应处理信息
		if(index>0){
			
			resp.sendRedirect("/sm/user/addDel.jsp");
		}
		
	}
	private void weiShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
		//调用service
		
		List<Sick> wei=ss.weiShowService();
		//判断
		if(wei!=null){
			//将查询的用户数据存储到request对象
			req.setAttribute("wei", wei);
			//请求转发
			req.getRequestDispatcher("/user/weibing.jsp").forward(req, resp);
			return;
		}
	}
	private void tangShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
		//调用service
		List<Sick> tang=ss.tangShowService();
		//判断
		if(tang!=null){
			//将查询的用户数据存储到request对象
			req.setAttribute("tang", tang);
			//请求转发
			req.getRequestDispatcher("/user/tangniaobing.jsp").forward(req, resp);
			return;
		}
		
	}
	//注册用户信息
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			//age的值是int，但是有时候int的值为空便会抛出异常，使用问号判断来对值进行规范
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}
			
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
		//处理请求信息
			//调用业务层
			int index=us.userRegService(u);
			System.out.println(index);
		//响应处理信息
			if(index>0){
				//获取session
				HttpSession hs=req.getSession();
				hs.setAttribute("reg", "true");
				//重定向
				resp.sendRedirect("/sm/login.jsp");
			}
	}
	//显示高血压病人用户信息
	private void gaoShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<Sick> gao=ss.sickShowService();
			//判断
			if(gao!=null){
				//将查询的用户数据存储到request对象
				req.setAttribute("gao", gao);
				//请求转发
				req.getRequestDispatcher("/user/gaoxueya.jsp").forward(req, resp);
				return;
			}
		
	}
	//显示所有用户信息
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<User> lu=us.userShowService();
			//判断
			if(lu!=null){
				//将查询的用户数据存储到request对象
				req.setAttribute("lu", lu);
				//请求转发
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
		
	}
	//用户修改密码
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取新密码
			String newPwd =req.getParameter("newPwd");
			//从session获取用户信息
			User u=(User) req.getSession().getAttribute("user");
			int uid=u.getUid();
		//处理密码
			//调用service处理
			int index=us.userChangePwdService(newPwd,uid);
			if(index>0){
				//用session做一个标记，知道跳转到登陆页面是从哪个地方跳转过来的
				//获取session对象
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd", "true");
				//重定向到登陆页面
				resp.sendRedirect("/sm/login.jsp");
			}
			
	}
	//用户退出
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs=req.getSession();
		//强制销毁session
		hs.invalidate();
		//重定向到主页面
		resp.sendRedirect("/sm/login.jsp");
	}
	//处理登陆
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
			//获取请求信息
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
				//处理请求信息
					
					//校验
				User u=us.checkUserLoginService(uname, pwd);
				if(u!=null){
					//获取session对象
					HttpSession hs =req.getSession();
					//将用户信息存储到session中
					hs.setAttribute("user", u);
					//重定向
					/*在servlet页面重定向,一个/表示服务器路径,直接写项目下文件路径就是相对路径
					 * 相对路径有缺点，就是在重定向时候他会默认去掉最后一位的/内容取前面的作为相对路径
					 * 而有时候我们servlet写成 xxx/xx的时候就会出现500的情况
					*/
					resp.sendRedirect("/sm/main/main.jsp");
					return;
				}else{
					//添加标识符到request
					req.setAttribute("flag", 0);
					//请求转发（因为重定向是两次请求，我们需要把错误的内容显示出来，则使用重定向不太方便）
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
					return;
				}
				//响应请求信息
					//直接响应
					//请求转发
					
	}
	
	
	
}
