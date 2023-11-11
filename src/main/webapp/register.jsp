<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/9/21
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>YC图书管理系统注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="YC图书管理系统" />
    <meta name="keywords" content="YC,网站管理系统,企业网站" />
    <meta name="Author" content="phenix" />
    <meta name="CopyRight" content="xx科技" />
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
  </head>
  <body>
  <table width="100%" >
    <!-- 顶部部分 -->
    <tr height="41"><td colspan="2" background="./Images/login_top_bg.gif">&nbsp;</td></tr>
    <!-- 主体部分 -->
    <tr style="background:url(./Images/login_bg.jpg) repeat-x;" height="532"    >
      <!-- 主体左部分 -->
      <td id="left_cont" valign="top"  width="100%" height="100%">
        <table  >
          <tr>
            <td width="20%" rowspan="2">
              <ul>
                <li><img src="./Images/book.jpg" />&nbsp;<a href="javascript:void(0)"></a></li>
              </ul>
            </td>
          </tr>
        </table>
      </td>
      <!-- 主体右部分 -->
      <td id="right_cont">
        <table height="100%">
          <tr height="30%"><td colspan="3">&nbsp;</td></tr>
          <tr>
            <td width="30%" rowspan="5">&nbsp;</td>
            <td valign="top" id="form1">
              <form id="fmLogin1" method="post" action="user.let?type=register">
                <table valign="top" width="50%">
                  <tr><td colspan="2"><h4 style="letter-spacing:1px;font-size:16px;">YC图书管理系统账号注册</h4></td></tr>
                  <tr><td>管理员：</td><td><input type="text" name="name" required /></td></tr>
                  <tr><td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="pwd" required/></td></tr>
                  <tr class="bt"><td>&nbsp;</td><td><input type="submit" value="注册"/>&nbsp;<input type="reset" value="重填" /> </td></tr>
                </table>
              </form>
            </td>
            <td rowspan="5">&nbsp;</td>
          </tr>
          <tr><td colspan="3">&nbsp;</td></tr>
        </table>
      </td>
    </tr>
    <!-- 底部部分 -->
    <tr id="login_bot"><td colspan="2"><p>Copyright © 2011-2021 YC课堂科技信息有限公司</p></td></tr>
  </table>

  </body>
</html>
