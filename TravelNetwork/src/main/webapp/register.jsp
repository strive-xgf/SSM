<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!--注册jsp页面-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/register.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        //输入校验
        var usernameFlag;
        var passwordFlag;
        var emailFlag;
        function checkUsername() {

            //判断一下账号输入是否合法
            var username = $("#username").val();
            //8-20位字符或数字
            var reg = /^\w{8,20}$/;
            usernameFlag = reg.test(username);
            if (usernameFlag) {
                //符合条件，提示username可用，清空前面的报错
                $("#username").css("border", "");
                $("#errorMsg").html("");
            } else {
                //修改边框，提示不可用
                $("#username").css("border", "3px solid red");
                $("#errorMsg").html("用户名必须是8-20位数字和字母组合");
            }
            return usernameFlag;
        }

        function checkPassword() {
            //判断一下密码输入是否合法
            var password = $("#password").val();
            var reg = /^\w{8,20}$/;
            passwordFlag = reg.test(password);
            if (passwordFlag) {
                $("#errorMsg").html("");
                //不提示
                $("#password").css("border", "");
            } else {
                //提示
                $("#password").css("border", "3px solid red");
                if(usernameFlag){//用户名输入正确才显示密码错误
                    $("#errorMsg").html("密码必须是8-20位数字和字母组合");
                }

            }
            return passwordFlag;
        }

        function checkEmail() {
            //判断一下密码输入是否合法
            var email = $("#email").val();
            var reg = /^\w+@\w+\.\w+$/;
            emailFlag = reg.test(email);
            if (emailFlag) {
                $("#errorMsg").html("");
                //不提示,无边框
                $("#email").css("border", "");
            } else {
                //提示
                $("#email").css("border", "3px solid red");
                if(usernameFlag && passwordFlag){//如果用户名和密码都正确才显示邮箱错误，前面的优先显示
                    $("#errorMsg").html("邮箱输入不正确");
                }
            }
            return emailFlag;
        }

        //页面初始化执行
        $(function () {
            //账号密码 手机号 邮箱 -> 通过正则判断，是否合法
            //格式正确不作提示，如果错误将边框改成红色
            $("#username").blur(checkUsername)
            $("#password").blur(checkPassword)
            $("#email").blur(checkEmail)

            $("#registerForm").submit(function () {
                if(!usernameFlag){
                    $("#errorMsg").html("用户名必须是8-20位数字和字母组合");
                }else if(!passwordFlag){
                    $("#errorMsg").html("密码必须是8-20位数字和字母组合");
                }else if(!emailFlag){
                    $("#errorMsg").html("邮箱输入不正确")
                }
                //ajax提交
                if (checkUsername() && checkPassword() && checkEmail()) {
                    //使用serialize()序列化方法，将整个表单序列化成json字符串发送给后台
                    $.post("RegisterServlet", $("#registerForm").serialize(),
                        function (data) {
                            //{code:1,data:成功}
                            if (data.code == 1) {
                                window.location = "login.jsp";
                            } else {
                                //注册失败，错误提示信息
                                $("#errorMsg").html(data.data);
                            }
                        }, "json");
                }
                return false;
            })
        });
    </script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp" %>
</div>
<!-- 头部 end -->
<div class="rg_layout">
    <div class="rg_form clearfix">
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">
            <div id="errorMsg" style="color:red;font-size: 22px"></div>
            <!--注册表单-->
            <form id="registerForm">

                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register">
                <table style="margin-top: 25px;">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="email">Email</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="email" name="email" placeholder="请输入Email">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="name">姓名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="name" name="name" placeholder="请输入真实姓名">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">手机号</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="sex">性别</label>
                        </td>
                        <td class="td_right gender">
                            <input type="radio" id="sex" name="sex" value="男" checked> 男
                            <input type="radio" name="sex" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="birthday">出生日期</label>
                        </td>
                        <td class="td_right">
                            <input type="date" id="birthday" name="birthday" placeholder="年/月/日">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="check">验证码</label>
                        </td>
                        <td class="td_right check">
                            <input type="text" id="inputCheckCode" name="inputCheckCode" class="check">
                            <img src="checkCodeServlet" height="32px" alt="看不清？点我换一换" onclick="changeCheckCode(this)">
                            <script type="text/javascript">
                                //图片点击事件，点击更换验证码
                                function changeCheckCode(img) {
                                    img.src="checkCodeServlet?"+new Date().getTime();//添加时间戳
                                }
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册">
                            <span id="msg" style="color: red;"></span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="#">立即登录</a>
            </p>
        </div>
    </div>
</div>
<!--引入尾部-->
<div id="footer">
    <%@include file="footer.jsp" %>
</div>

</body>
</html>