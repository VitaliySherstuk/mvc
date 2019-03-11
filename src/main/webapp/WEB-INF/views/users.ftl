<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="linkHomePage">
            <ul>
              <li class="li-style"><a href="/">Home Page</a></li>
              <li class="li-style">Users</li>
            </ul>
        </div>
        </br>
        </br>
        <div>
            <label>Create User</label>
           <form method="post" action="/users/addUser" onclick = "return true">
                <input id="username" name="username" type="text" placeholder="username"/>
                <input id="email" name="email" type="text" placeholder="email"/>
                <input id="date" name="date" type="date"/>
                </br>
                <div id="module_rate">
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
                <input id="submit" name="submit" type="submit" placeholder="submit"/>
           </form>
        </div>
        </br>
        <div>
            <label>Get User by name</label>
            <form method="post" action="/users/userByName" onclick = "return true">
                <input id="find_by_name" name="username" type="text" placeholder="username"/>
                <input id="submit_by_name" name="submit" type="submit" placeholder="submit"/>
            </form>
            <#if notUsersByName??>
               <div>User does not exist</div>
            </#if>
        </div>
        </br>
        <div>
            <label>Get User by email</label>
            <form method="post" action="/users/userByEmail" onclick = "return true">
                <input id="find_by_email" name="email" type="text" placeholder="email"/>
                <input id="submit_by_email" name="submit" type="submit" placeholder="submit"/>
            </form>
            <#if notexist??>
                <div>User does not exist</div>
            </#if>
        </div>
    </body>
</html>
