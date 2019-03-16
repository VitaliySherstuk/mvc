<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
                    <ul>
                      <li class="li-style"><a href="/">Home Page</a></li>
                      <li class="li-style">Account</li>
                    </ul>
        </div>
        </br>
        </br>
        <#if user??>
        <h2>${user}<h2>
        </#if>
        <#if money??>
        <h3>Money: ${money} $<h3>
        </#if>
        </br>
        </br>
        <div>
            <form method="post" action="/account/replenish" onclick="return true">
                <label>Amount of money:</label>
                <input id="money" name="amount" type="text"/>
                <input id="submit" name="submit" type="submit" placeholder="submit"/>
            </form>
        </div>
    </body>
</html>
