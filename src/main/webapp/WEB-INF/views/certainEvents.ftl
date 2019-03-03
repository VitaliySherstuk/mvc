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
</div>
</br>
</br>
<div>
            <#if notCertainEvent??>
                <div>Event is not exist</div>
            </#if>
            <#if certainEvent??>
                <div>
                    <div>${event.name}</div>
                    <div>${event.auditorium.name}</div>
                    <div>${event.rate}</div>
                    <div>${event.dateTime}</div>
                </div>
            </#if>
</div>
            </body>
            </html>