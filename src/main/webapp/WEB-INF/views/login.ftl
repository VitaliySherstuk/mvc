<!DOCTYPE html>
<html lang="en">
<head>


</head>
<body>

<div>
    <div>
        <h1>Login page</h1>

        <form method="post" action="j_spring_security_check">
            <div>
                username
                <input type="text" name="j_username"/>
            </div>
            <br>
            <div>
                login.password
                <input type="password" name="j_password"/>
            </div>
            <br>
            <div>
                <label for ="remember">Remember me?</label>
                <input id="remember" type ="checkbox" name="remember-me" value="true"/>
             </div>
            <button type="submit" "value="Login"/>Login</button>
        </form>
    </div>

    <font color="red">
        <#-- TO DO display wrong creds message -->
    </font>

    <div class="right-block">
        <img alt="welcome" src="/spring_mvc_war/resources/image/welcome.jpg">
    </div>
</div>
</body>
</html>