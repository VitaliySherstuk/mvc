<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
                    <ul>
                      <li class="li-style"><a href="/">Home Page</a></li>
                      <li class="li-style">Booking</li>
                    </ul>
        </div>
        </br>
        </br>
        <div id ="ticketPrice">
            <label>Choose event to find tickets:</lebel>
            <form method="post" action="/booking/ticketPrice" onclick="return true">
                    <table>
                    <#list events as event>
                      <tr>
                      <td>
                      <label>${event.name} ${event.auditorium.name} ${event.dateTime} ${event.rate}</label>
                      <label>Seats: ${event.auditorium.seatsNumber}<label>
                      <input name="event" type="radio" value="${event.name}  ${event.auditorium.name}  ${event.dateTime}"/>
                    </td>
                    </tr>
                    </#list>
                   </table>
                <label for="seats">Enter number of places</label>
                <input id="seats" name="seats" type="text"/>
                <input id="userEmail" name="userEmail" type="" placeholder="user email"/>
                <input id="submit" name="submit" type="submit" placeholder="submit"/>
            </form>
        </div>
        </br>
        </br>

        <div id ="ticketForEvent">

                    <label for="seats">Get tiket for event</label>
                    <form method="post" action="/booking/ticketForEvent" onclick="return true">
                        <input id="f_eventName" name="eventName" type="text" placeholder="eventName"/>
                        <input id="f_date" name="date" type="date" />
                        <input id="f_time" name="time" type="time" />
                        <div id="module_auditorium">
                                            <div>
                                                <input id="auditorium_blue_hall" name="auditorium" type="radio" value="Blue hall"/>
                                                <label for="auditorium_blue_hall">Blue Hall</label>
                                            </div>
                                            <div>
                                                <input id="auditorium_red_hall" name="auditorium" type="radio" value="Red hall"/>
                                                <label for="auditorium_red_hall">Red Hall</label>
                                            </div>
                                            <div>
                                                <input id="auditorium_yellow_hall" name="auditorium" type="radio" value="Yellow hall"/>
                                                <label for="auditorium_yellow_hall">Yellow Hall</label>
                                            </div>
                                        </div>
                        <input id="submit" name="submit" type="submit" placeholder="submit"/>
                    </form>
                    <#if not_tickets??>
                        <div>There are not those tickets</div>
                    </#if>
                </div>
    </body>
</html>
