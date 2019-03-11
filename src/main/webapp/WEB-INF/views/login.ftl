<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" />
</head>
<body>

    <div class="login-form">
        <h1>Login page</h1>

        <form method="post" action="/j_spring_security_check">
            <div>
                username(email)
                <input type="text" name="j_username"/>
            </div>
            <br>
            <div>
                password
                <input type="text" name="j_password"/>
            </div>
            <br>
            <div>
                <label for ="remember">Remember me?</label>
                <input id="remember" type ="checkbox" name="remember-me" value="true"/>
             </div>
            <button type="submit" "value="Login"/>Login</button>
        </form>
        </br>
        <form method="get" action="/registration" onclick = "return true">
            <input type="submit" name="submit" value="registration">
        </form>
    </div>
</body>
</html>