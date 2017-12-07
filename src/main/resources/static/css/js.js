function yanzheng(){
    var number= $("#yanzhengmatext").val();

    $.ajax({
        type:"POST",
        url:"/re/imgvrifyControllerDefaultKaptcha",
        dataType:"json",
        data:{yanzhengma:number},
        success:function(msg){
            if(msg["info"]==1){
                alert("验证成功");
                removeAttr();
                $("#yanzhengma").html("");
            }
        }
    });

}

function sub(){
    var password= $("#password").val();
    var phone=$("#phone").val();
    alert("haha");
    $.ajax({
        type:"POST",
        url:"/register/register",
        data:{phone:phone,
            password:password
        },
        dataType:"json",
        success:function(msg){
            if(msg["status"]==1){
                alert("注册成功,恭喜你成为arvato的会员");
                location.href="/login/hello";
            }else{
                alert("因为什么神秘的原因，失败了");
            }
        }
    });

}
function checkNm() {

    var number=$("#checkNumber").val();
    var phone=$("#phone").val();
    $.ajax({
        type:"POST",
        url:"/register/checkNm",
        data:{number:number,
            phone:phone },
        dataType:"json",
        success:function(msg){
            if(msg["numbercode"]==1){
                alert("验证成功");
                $("#submitId").removeAttr("disabled");
            }
            else if(msg["numbercode"]==3){
                alert("验证码期限已经超过60秒，请重新获取");
            }
            else{
                alert("验证码错误");
                $("#buttonId").attr('disabled',true);
                $("#yanzhengma").html("<input type='text'  id='yanzhengmatext' onblur='yanzheng()'> <img alt='验证码' onclick = 'this.src=\"/re/defaultKaptcha?d=\"+new Date()*1' src='/re/defaultKaptcha' />");


            }
        }
    });
}
function sendNumber(){
    var phone=$("#phone").val();
    alert(phone);
    $.ajax({
        type:"POST",
        url:"/register/sendNumber",
        data:{phone:phone},
        dataType:"json",
        success:function(msg){
            if(msg["number"]==1){
                alert("手机验证码已成功发送，请注意查收");
            }else if(msg["number"]==3){
                alert("60秒内只能获取一次");
            }else{
                alert("手机号码错误，请更换号码");
            }
        }
    });
    $("#buttonId").attr('disabled',true);
    setTimeout(removeAttr,60000);

}
function removeAttr(){
    $("#buttonId").removeAttr("disabled");
}

function checkPassword(){
    var password= $("#password").val();
    if(password.length<=4){
        $("#passwordId").html("密码不能少于4位数字");
        return false;
    }else{
        $("#passwordId").html("");
    }
    return true;

}
function add() {
    var phone=$("#phone").val();
    if(!(/^1[34578]\d{9}$/.test(phone))){
        alert("手机号码有误，请重填");
        return false;
    }

    $.ajax({
        type:"POST",
        url:"/register/ajax",
        data:{phone:phone},
        dataType:"json",
        success:function(msg){
            var code=msg["code"];
            if(code==1){
                if(confirm("用户已存在，你要登陆吗？"))
                {
                    location.href="/login/hello";
                }
                else
                {
                    return false;
                }
            }
        }
    });


}