<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="application/javascript" src="../../js/jquery-1.10.1.min.js"></script>
    <script type="application/javascript" src="../../js/jquery.json.js"></script>
    <title>注册</title>
</head>
<body>
<form name="form" action="user.html" method="post">
    <table width="207" border="0" align="center">
        <tr>
            <td colspan="2" align="center" nowrap="nowrap">用户注册</td>
        </tr>
        <tr>
            <td width="68" nowrap="nowrap">用户名</td>
            <td width="127" nowrap="nowrap"><label>
                <input name="username" type="text" id="username" size="20" value="娃哈哈" />
            </label></td>
        </tr>
        <tr>
            <td nowrap="nowrap">密　码</td>
            <td nowrap="nowrap"><input name="password" type="password" id="password" size="20" maxlength="10" value="1234" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center" nowrap="nowrap"><label>
                <input type="button"  value="注册" onclick="doSave()" />
                <input type="reset"  value="重填" />
            </label></td>
        </tr>
    </table>
</form>
</body>
</html>
<script type="application/javascript">
    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || "");
            } else {
                o[this.name] = this.value || "";
            }
        });
        return o;
    };
    var comment = $.toJSON($("form").serializeObject());
    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"ajaxsave.html",
        data:comment,
        dataType:"json",
        success:function(data){
            alert("here");
        },
        error:function(){
            alert("系统异常");
        }
    });
</script>