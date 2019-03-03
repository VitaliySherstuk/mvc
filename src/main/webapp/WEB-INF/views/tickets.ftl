<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
         <div id="linkHomePage">
             <ul>
                <li class="li-style"><a href="/">Home Page</a></li>
                <li class="li-style"><a href="/booking">Booking</a></li>
                <li class="li-style">Tickets</li>
             </ul>
         </div>
         </br>
         </br>
         <div>
         <table border="1">
            <thead>
                <tr>
                <th>id</th>
                <th>event_name</th>
                <th>date</th>
                <th>rate</th>
                <th>auditorium</th>
                <th>seats</th>
                <th>user</th>
                <th>price</th>
                </tr>
            </thead>
            <tbody>
                <#list tickets as ticket>
                    <tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.event.name}</td>
                        <td>${ticket.dateTime}</td>
                        <td>${ticket.event.rate}</td>
                        <td>${ticket.event.auditorium.name}</td>
                        <td>${ticket.seats}</td>
                        <td>${ticket.user.email}</td>
                        <td>${ticket.price}</td>
                    </tr>
                </#list>
            </tbody>
         </table>
         </div>
         </br>
         </br>
         <div>

                <form method="post" action="/booking/pdf" produces = "application/pdf" onclick="return true">
                    <label>Download</lebel>
                    <input name="id" type="hidden" value="${id}"/>
                    <input name="submit" type="submit"/>
                </form>
         </div>
    </body>
<html>