<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div>
            Hello!!!
        </div>
        <div>
            <a href="/users">UserPage</a>
        </div>
        <div>
            <a href="/auditoriums">Auditoriums</a>
        </div>
        <div>
            <a href="/events">EventPage</a>
        </div>
        <div>
             <a href="/booking">Booking</a>
        </div>
        <div>
             <a href="/load">Load from file</a>
        </div>

        <div>
             <a href="/account">Account</a>
        </div>
        </br>
        </br>
        <div>
            <form id="logout" action="/j_spring_security_logout" method="get">
                    <input  name="logout" value="logout"  type="submit" />
                </form>
        </div>

    </body>
</html>
