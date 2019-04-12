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
 * Servlet�ض���·���ܽ�
 * 		���·�����ӵ�ǰ�����·����Դ������Դ��·��
 * 			���·�������servlet�ı����а���Ŀ¼��������ض�����Դ����ʧ��
 * 		����·������һ��/��ʾ��������Ŀ¼
 * 			/������Ŀ��/��Դ·��
 * servlet����ת��
 * 		/��ʾ��Ŀ��Ŀ¼
 * 		req.getRequestDispatcher("/��Դ·��").forward(req, resp);
 * 
 * 
 * @author yzxlz
 *
 */
public class UserServlet extends HttpServlet {
	//������־����
	Logger logger=Logger.getLogger(UserServlet.class);
	//��ȡservice�����
	UserService us=new UserServiceImpl();
	SickService ss=new SickServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=req.getParameter("oper");
		if ("login".equals(oper)) {
			//���õ�½������
			checkUserLogin(req,resp);
		}else if ("reg".equals(oper)) {
			//����ע�Ṧ��
			userReg(req,resp);
		}else if ("out".equals(oper)) {
			//�����˳�����
			userOut(req,resp);
		}else if ("pwd".equals(oper)) {
			//���������޸Ĺ���
			userChangePwd(req,resp);
		}else if ("show".equals(oper)) {
			//������ʾ�����û�����
			userShow(req,resp);
		}else if ("gao".equals(oper)){
			//������ʾ��Ѫѹ������Ϣ
			gaoShow(req, resp);
		}else if ("tang".equals(oper)){
			//������ʾ��Ѫѹ������Ϣ
			tangShow(req, resp);
		}else if ("wei".equals(oper)){
			//������ʾ��Ѫѹ������Ϣ
			weiShow(req, resp);
		}else if ("delete".equals(oper)){
			//ɾ����Ѫѹ������Ϣ
			//gaoDelete(req, resp);
		}else if ("deleteW".equals(oper)){
			//ɾ��θ��������Ϣ
			weiDelete(req, resp);
		}else if ("weiAdd".equals(oper)) {
			weiAdd(req,resp);
		}else if ("gaoAdd".equals(oper)) {
			gaoAdd(req,resp);
		}else if ("tangAdd".equals(oper)) {
			tangAdd(req,resp);
		}
		
		else{
			logger.debug("û���ҵ���Ӧ�Ĳ�������"+oper);
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
		//����������Ϣ
			//����ҵ���
			int index=ss.tangAddService(s);
			System.out.println(index);
		//��Ӧ������Ϣ
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
		//����������Ϣ
			//����ҵ���
			int index=ss.gaoAddService(s);
			System.out.println(index);
		//��Ӧ������Ϣ
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
		//����������Ϣ
			//����ҵ���
			int index=ss.weiAddService(s);
			System.out.println(index);
		//��Ӧ������Ϣ
			if(index>0){
				
				resp.sendRedirect("/sm/user/addSuc.jsp");
			}
			
		
	}
	private void weiDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		//����������Ϣ
		//����ҵ���
		int index=ss.weiDelService(id);
		System.out.println(index);
	//��Ӧ������Ϣ
		if(index>0){
			
			resp.sendRedirect("/sm/user/addDel.jsp");
		}
		
	}
	private void weiShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
		//����service
		
		List<Sick> wei=ss.weiShowService();
		//�ж�
		if(wei!=null){
			//����ѯ���û����ݴ洢��request����
			req.setAttribute("wei", wei);
			//����ת��
			req.getRequestDispatcher("/user/weibing.jsp").forward(req, resp);
			return;
		}
	}
	private void tangShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
		//����service
		List<Sick> tang=ss.tangShowService();
		//�ж�
		if(tang!=null){
			//����ѯ���û����ݴ洢��request����
			req.setAttribute("tang", tang);
			//����ת��
			req.getRequestDispatcher("/user/tangniaobing.jsp").forward(req, resp);
			return;
		}
		
	}
	//ע���û���Ϣ
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			//age��ֵ��int��������ʱ��int��ֵΪ�ձ���׳��쳣��ʹ���ʺ��ж�����ֵ���й淶
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}
			
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
		//����������Ϣ
			//����ҵ���
			int index=us.userRegService(u);
			System.out.println(index);
		//��Ӧ������Ϣ
			if(index>0){
				//��ȡsession
				HttpSession hs=req.getSession();
				hs.setAttribute("reg", "true");
				//�ض���
				resp.sendRedirect("/sm/login.jsp");
			}
	}
	//��ʾ��Ѫѹ�����û���Ϣ
	private void gaoShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
			//����service
			List<Sick> gao=ss.sickShowService();
			//�ж�
			if(gao!=null){
				//����ѯ���û����ݴ洢��request����
				req.setAttribute("gao", gao);
				//����ת��
				req.getRequestDispatcher("/user/gaoxueya.jsp").forward(req, resp);
				return;
			}
		
	}
	//��ʾ�����û���Ϣ
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
			//����service
			List<User> lu=us.userShowService();
			//�ж�
			if(lu!=null){
				//����ѯ���û����ݴ洢��request����
				req.setAttribute("lu", lu);
				//����ת��
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
		
	}
	//�û��޸�����
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������
			String newPwd =req.getParameter("newPwd");
			//��session��ȡ�û���Ϣ
			User u=(User) req.getSession().getAttribute("user");
			int uid=u.getUid();
		//��������
			//����service����
			int index=us.userChangePwdService(newPwd,uid);
			if(index>0){
				//��session��һ����ǣ�֪����ת����½ҳ���Ǵ��ĸ��ط���ת������
				//��ȡsession����
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd", "true");
				//�ض��򵽵�½ҳ��
				resp.sendRedirect("/sm/login.jsp");
			}
			
	}
	//�û��˳�
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡsession����
		HttpSession hs=req.getSession();
		//ǿ������session
		hs.invalidate();
		//�ض�����ҳ��
		resp.sendRedirect("/sm/login.jsp");
	}
	//�����½
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
			//��ȡ������Ϣ
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
				//����������Ϣ
					
					//У��
				User u=us.checkUserLoginService(uname, pwd);
				if(u!=null){
					//��ȡsession����
					HttpSession hs =req.getSession();
					//���û���Ϣ�洢��session��
					hs.setAttribute("user", u);
					//�ض���
					/*��servletҳ���ض���,һ��/��ʾ������·��,ֱ��д��Ŀ���ļ�·���������·��
					 * ���·����ȱ�㣬�������ض���ʱ������Ĭ��ȥ�����һλ��/����ȡǰ�����Ϊ���·��
					 * ����ʱ������servletд�� xxx/xx��ʱ��ͻ����500�����
					*/
					resp.sendRedirect("/sm/main/main.jsp");
					return;
				}else{
					//��ӱ�ʶ����request
					req.setAttribute("flag", 0);
					//����ת������Ϊ�ض�������������������Ҫ�Ѵ����������ʾ��������ʹ���ض���̫���㣩
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
					return;
				}
				//��Ӧ������Ϣ
					//ֱ����Ӧ
					//����ת��
					
	}
	
	
	
}
