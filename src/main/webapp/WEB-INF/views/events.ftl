<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
                    <ul>
                      <li class="li-style"><a href="/">Home Page</a></li>
                      <li class="li-style">Events</li>
                    </ul>
        </div>
        </br>
        </br>
        <div>
           <form method="post" action="events/addEvent" onclick="return true">
                <input id="event_name" name="eventName" type="text" placeholder="eventname">
                <input id="event_base_price" name="basePrice" type="text" placeholder="base price">
                <input id="date" name="date" type="text" placeholder="date(format: yyyy MM dd)">
                <input id="time" name="time" type="text" placeholder="time (format: HH:mm)">
                <div id="module_rate">
                    <div>
                        <input id="event_rate_high" name="rate" type="radio" value="high">
                        <label for="event_rate_high">HIGH</label>
                    </div>
                    <div>
                        <input id="event_rate_mid" name="rate" type="radio" value="mid">
                        <label for="event_rate_mid">MID</label>
                    </div>
                    <div>
                        <input id="event_rate_low" name="rate" type="radio" value="low">
                        <label for="event_rate_low">LOW</label>
                    </div>
                </div>
                </br>
                <div id="module_auditorium">
                    <div>
                        <input id="auditorium_blue_hall" name="auditorium" type="radio" value="blueHall">
                        <label for="auditorium_blue_hall">Blue Hall</label>
                    </div>
                    <div>
                        <input id="auditorium_red_hall" name="auditorium" type="radio" value="redHall">
                        <label for="auditorium_red_hall">Red Hall</label>
                    </div>
                    <div>
                        <input id="auditorium_yellow_hall" name="auditorium" type="radio" value="yellowHall">
                        <label for="auditorium_yellow_hall">Yellow Hall</label>
                    </div>
                </div>
                <div>
                    <input id="submit" name="submit" type="submit" placeholder="submit">
                </div>
           </form>
        </div>
    </body>
</html>