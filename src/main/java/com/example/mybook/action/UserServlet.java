package com.example.mybook.action;

import com.example.mybook.Biz.UserBiz;
import com.example.mybook.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user.let")
public class UserServlet extends HttpServlet {
    UserBiz userBiz = new UserBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //设置编码防止请求和响应乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //响应的输出流对象
        PrintWriter out = resp.getWriter();

        //1.判读用户请求的类型为login
        String method = req.getParameter("type");
        switch (method) {
            case "login":
                // 2.从login.html中获取用户名和密码,验证码
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");
                String userCode=req.getParameter("valcode");
                String code = session.getAttribute("code").toString();
//                //不区分大小写

               if(!code.equalsIgnoreCase(userCode)){
                   out.println("<script>alert('验证码输入错误');location.href = 'login.html';</script>");
                    return;
                }
                // 3.调用UserBiz的getUser方法，根据用户名和密码获取对应的用户对象
                User user = userBiz.getUser(name, pwd);
                System.out.println(user);
                // 4.判断用户对象是否为null: 
                if (user == null) {
                    //  4.1 如果是null表示用户名或密码不正确 ，提示错误，回到登录页面. 
                    out.println("<script>alert('用户名或密码不存在');location.href = 'login.html';</script>");
                } else {
                    //  4.2 非空：表示登录成功, 将用户对象保存到session中,提示登录成功后,将页面跳转到index.jsp
                    session.setAttribute("user", user);//user-->Object
                    out.println("<script>alert('登录成功');location.href='index.jsp';</script>");
                }
                break;
            case"register":
                System.out.println(1111);
                String nameadd = req.getParameter("name");
                String pwdadd = req.getParameter("pwd");
//            User user1=userBiz.getUser(nameadd,pwdadd);
//            if(user1!=null){
//                out.println("<script>alter('用户名已存在');parent.window.location.href='login.html';</script>");
//            }
            int k= userBiz.adduser(nameadd,pwdadd);
            System.out.println(k);
            if(k!=0){
                out.println("<script>alert('用户名已存在');parent.window.location.href='login.html';</script>");
            }else{
                //session.setAttribute("user",user);
                out.println("<script>alert('注册成功');parent.window.location.href='login.html';</script>");
            }
            break;
            //修改密码（个人中心）
            case"modifyPwd":
                //验证用户是否登录
                if(session.getAttribute("user")==null){
                    out.println("<script>alert('请登录');parent.window.location.href='login.html';</script>");
                    return;

                }
                //修改密码
                String newPwd=req.getParameter("newpwd");
                long id=((User)session.getAttribute("user")).getId();
                int count=userBiz.modifyPwd(id,newPwd);
                System.out.println(count);
                if(count==1){
                    out.println("<script>alert('密码修改成功');parent.window.location.href='login.html';</script>");


                }else{
                    out.println("<script>alert('密码修改失败');parent.window.location.href='login.html';</script>");
                }
                break;
            case "exit":

                if(session.getAttribute("user")==null){
                    out.println("<script>parent.window.location.href='login.html';</script>");
                    return;
                }
                session.invalidate();
                out.println("<script>parent.window.location.href='login.html';</script>");
                break;

        }
    }
}

