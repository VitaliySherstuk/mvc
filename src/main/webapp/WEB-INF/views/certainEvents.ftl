<html lang="en">

<head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
           <ul>
              <li class="li-style"><a href="/">Home Page</a></li>
              <li class="li-style"><a href="/events">Events</a></li>
              <li class="li-style">Certain Events</li>
           </ul>

<#if notCertainEvent??>
                <div>Event is not exist</div>
            </#if>
            <#if certainEvent??>

                    <div>${event.name}</div>
                    <div>${event.rate}</div>
                    <div></div>
                    <div></div>

            </#if>
            </body>
            </html>