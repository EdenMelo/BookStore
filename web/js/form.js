window.onload = function (){
        var subButton = document.getElementById("sub_btn");

        subButton.onclick = function (){
            var username = document.getElementById("username").value;
            var password = document.getElementById("pw").value;
            var repeatPassword = document.getElementById("rw").value;

            //正则表达式：表示字符不能以数字开头，只能包含下划线和字母，并且长度是1~10
            var UsernamePatton = /^[_A-z]\w{1,10}$/;

            //①验证用户名

            if(!UsernamePatton.test(username)){
                alert("用户名不正确！");
                return false;
            }

            //正则表达式：6~16的字符
            var passwordPatton = /^\w{6,16}$/;
            if(!passwordPatton.test(password)){
                alert("密码不合法！");
                return false;
            }else {
                if(repeatPassword!==password){
                    alert("两次密码输入不一致！");
                    return false;
                }
            }



        }
};

