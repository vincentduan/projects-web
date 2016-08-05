/**
 * check text
 */
function getFocus()  // 设置用户名文本框获取焦点
{
    document.getElementById("mobilNum").focus();
}
 
function checktelephone()  // 检查电话号码
{
 var mytelephone=document.getElementById("mobilNum").value;
 var myDivtelephone=document.getElementById("mobilNumDiv");
 if(mytelephone!="")
 {
     var reg = /^[1]{1}[0-9]{10}$/i;
     if(!reg.test(mytelephone))
        {
            myDivtelephone.innerHTML="<font color='red'>只能输入11位数字！</font>";
            return false;
        }
     else
     {
      myDivtelephone.innerHTML="<font color='red'>√</font>";
      return true;
     }
 }
 else
 {
     myDivtelephone.innerHTML="<font color='red'>×</font>";
     return true;
 }
}

function checkVerifyNum(){
	 var myVerifyNum=document.getElementById("verifyNum").value;
	 var myVerifyNum=document.getElementById("verifyNumDiv");
	 if(myVerifyNum=="")
	 {
	  myDivpassword.innerHTML="<font color='red'>验证码不能为空!</font>";
	  return false;
	 }
	 else
	{
		 return true;
	}
}
 
function checkpassword()  // 检查密码
{
 var mypassword=document.getElementById("checkpassd").value;
 var myDivpassword=document.getElementById("checkpassdDiv");
 if(mypassword=="")
 {
  myDivpassword.innerHTML="<font color='red'>密码不能为空!</font>";
  return false;
 }
 else if(mypassword.length<6)
 {
  myDivpassword.innerHTML="<font color='red'>密码至少应为六位!</font>";
  return false;
 }
 else
 {
  myDivpassword.innerHTML="<font color='red'>√</font>";
  return true;
 } 
}
 
function checkpassrwordagain()  // 检查确认密码
{
 var myispassword=document.getElementById("checkpassdagain").value;
 var myDivispassword=document.getElementById("checkpassdagainDiv");
 if(myispassword=="")
 {
     myDivispassword.innerHTML="<font color='red'>确认密码不能为空!</font>";
     return false;
 }
 else if(document.getElementById("checkpassd").value!=document.getElementById("checkpassdagain").value)
 {
  myDivispassword.innerHTML="<font color='red'>确认密码与密码不一致!</font>";
  return false;
 } 
 else
 {
  myDivispassword.innerHTML="<font color='red'>√</font>";
  return true;
 } 
}
 
function checkall()  // 检查所有
{
    if(checktelephone()&&checkVerifyNum()&&checkpassd()&&checkpassdagain())
    {
        return true;
    }
    return false;
}
 
