<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
         <div id="linkHomePage">
             <ul>
                <li class="li-style"><a href="/">Home Page</a></li>
                <li class="li-style">Tickets</li>
             </ul>
         </div>
         <div>
             <form method="post" action="events/addEvent" onclick="return true">
                <input id="event_name" name="eventName" type="text" placeholder="eventname">
                 <input id="event_base_price" name="basePrice" type="text" placeholder="base price">
                 <input id="date" name="date" type="text" placeholder="date(format: yyyy MM dd)">
                 <input id="time" name="time" type="text" placeholder="time (format: HH:mm)">
                 <div id="module_rate">
             </form>
         </div>
    </body>
<html>