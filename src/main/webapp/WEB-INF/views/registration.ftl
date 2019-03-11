<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="login-form">
           <label>Create User</label>
           <br>
           <br>
           <form method="post" action="/registration/add" onclick = "return true">
                Username
                <input id="username" name="username" type="text" placeholder="username"/>
                <br>
                <br>
                Email
                <input id="email" name="email" type="text" placeholder="email"/>
                <br>
                <br>
                Date
                <input id="date" name="date" type="date"/>
                <br>

                <div id="module_rate">
                <br>
                <labe>Role</label>
                                    <div>
                                        <input id="role_user" name="role" type="radio" value="ROLE_USER"/>
                                        <label for="event_rate_high">USER</label>
                                    </div>
                                    <div>
                                        <input id="role_admin" name="role" type="radio" value="ROLE_ADMIN"/>
                                        <label for="event_rate_mid">ADMIN</label>
                                    </div>
                                </div>
                 <br>

                 Password
                 <input id="password" name="password" type="text" placeholder="password"/>
                 <br>
                 <br>
                <input id="submit" name="submit" type="submit"/>
           </form>

        </div>
    </body>
</html>