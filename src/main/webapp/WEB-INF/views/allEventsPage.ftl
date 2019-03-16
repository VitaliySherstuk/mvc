<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
           <ul>
              <li class="li-style"><a href="/">Home Page</a></li>
              <li class="li-style"><a href="/events">Events</a></li>
              <li class="li-style">All Events</li>
           </ul>
        </div>
         </br>
         </br>
         <div>
            <table border="1">
                <thead>
                     <tr>
                         <th>eventName</th>
                         <th>date</th>
                         <th>auditorium</th>
                         <th>rate</th>
                     </tr>
                </thead>
                <tbody>
                    <#list events as event>
                       <tr>
                           <td>${event.name}</td>
                           <td>${event.dateTime}</td>
                           <td>${event.auditorium.name}</td>
                           <td>${event.rate}</td>
                       </tr>
                    </#list>
                </tbody>
            </table>
         </div>
    </body>
</html>