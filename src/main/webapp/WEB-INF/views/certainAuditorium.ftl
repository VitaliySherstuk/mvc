<html lang="en">

<head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
           <ul>
              <li class="li-style"><a href="/">Home Page</a></li>
              <li class="li-style"><a href="/auditoriums">Auditorium</a></li>
              <li class="li-style">Certain auditorium</li>
           </ul>
           </br>
           </br>
        <div>
            <table border="1">
                            <thead>
                                 <tr>
                                     <th>auditorium name</th>
                                     <th>seats</th>
                                     <th>VIP seats</th>
                                 </tr>
                            </thead>
                            <tbody>
                                   <tr>
                                       <td>${auditorium.name}</td>
                                       <td>${auditorium.seatsNumber}</td>
                                       <td>${auditorium.vipSeats}</td>
                                   </tr>
                            </tbody>
                        </table>
        </div>

    </body>
</html>