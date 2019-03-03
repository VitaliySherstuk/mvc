<html lang="en">

<head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
           <ul>
              <li class="li-style"><a href="/">Home Page</a></li>
              <li class="li-style">Auditoriums</li>
           </ul>
           </br>
           </br>
        <div>
            <label>Get Auditorium</label>
            <form method="post" action="/auditoriums/getAuditorium" onclick="return true">
                            <input id="au_name" name="nameAuditorium" type="text" placeholder="auditoriumname"/>
                            <div>
                                <input id="submit" name="submit" type="submit" placeholder="submit"/>
                            </div>
             </form>
            <#if notAuditorium??>
               <div>Auditotium does not exist</div>
                    </#if>
        </div>
        </br>
        </br>
        <div>
        <label>Get all auditoriums</label>
                    <form method="get" action="/auditoriums/getAllAuditorium" onclick="return true">

                        <div>
                            <input id="submit" name="submit" type="submit" placeholder="submit"/>
                        </div>
                    </form>
<#if notAuditorium??>
               <div>Auditotiums do not exist</div>
            </#if>
                </div>
    </body>
</html>