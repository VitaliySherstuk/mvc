<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
                    <ul>
                      <li class="li-style"><a href="/">Home Page</a></li>
                      <li class="li-style"><a href="/booking">Booking</a></li>
                      <li class="li-style">Preorder</li>
                    </ul>
        </div>
        </br>
        </br>

        <#if wrongUser??>
                        <div>User does not exist</div>
                    </#if>
                    <#if bookButton??>
                        <div>
                            <p>${event}</p>
                        </div>

                        <div>
                            <p>Seats: ${seats}</p>
                        </div>
                        <div>
                            <p>Price: ${ticketPrice}</p>
                        </div>
                        <form method="post" action="/booking/book" onclick="return true">
                            <input name="event" type="hidden" value="${event}"/>
                            <input name="seats" type="hidden" value="${seats}"/>
                            <input name="userEmail" type="hidden" value="${userEmail}"/>
                            <input name="ticketPrice" type="hidden" value="${ticketPrice}"/>
                            <input id="submit_book" name="book" type="submit"/>
                        </form>
                    </#if>
        <div>
            <#if message??>
                <p>BOOKED</p>
            </#if>
        </div>
</html>