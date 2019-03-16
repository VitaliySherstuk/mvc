<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
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
        <div id="123">
           <label for="123">Create Event</label>
           <form method="post" action="/events/addEvent" onclick="return true">
                <input id="event_name" name="eventName" type="text" placeholder="eventname"/>
                <input id="event_base_price" name="basePrice" type="text" placeholder="base price"/>
                <input id="date" name="date" type="date" />
                <input id="time" name="time" type="time" />
                <div id="module_rate">
                    <div>
                        <input id="event_rate_high" name="rate" type="radio" value="high"/>
                        <label for="event_rate_high">HIGH</label>
                    </div>
                    <div>
                        <input id="event_rate_mid" name="rate" type="radio" value="mid"/>
                        <label for="event_rate_mid">MID</label>
                    </div>
                    <div>
                        <input id="event_rate_low" name="rate" type="radio" value="low"/>
                        <label for="event_rate_low">LOW</label>
                    </div>
                </div>
                </br>
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
                <div>
                    <input id="ticketPrice" type="text" name="ticketPrice" placeholder="ticketPrice"/>
                </div>
                <div>
                    <input id="submit" name="submit" type="submit" placeholder="submit"/>
                </div>
           </form>
            <#if message??>
               <div>Event was created</div>
            </#if>
        </div>
        </br>
        </br>
            <div id=all_events>
                <form method="get" action="/events/allEvents" onclick="return true">
                    <p>Get all Events</p>
                    <input id="submit_get_all_events" name="submit" type="submit"/>
                </form>
                <#if notEvents??>
                    <div>Event is not exist</div>
                </#if>
            </div>
        </br>
        </br>
        <div>
            <label>Get Event</label>
            <form method="post" action="/events/getEvent" onclick="return true">
                <input id="in_get_certain_events_n" name="eventName" type="text" placeholder="event name"/>
                <input id="in_get_certain_events_d" name="date" type="date"/>
                <input id="in_get_certain_events_t" name="time" type="time"/>
                <div id="e_module_auditorium">
                    <div>
                        <input id="e_auditorium_blue_hall" name="auditorium" type="radio" value="Blue hall"/>
                        <label for="e_auditorium_blue_hall">Blue hall</label>
                    </div>
                    <div>
                        <input id="e_auditorium_red_hall" name="auditorium" type="radio" value="Red hall"/>
                        <label for="e_auditorium_red_hall">Red hall</label>
                    </div>
                    <div>
                        <input id="e_auditorium_yellow_hall" name="auditorium" type="radio" value="Yellow hall"/>
                        <label for="e_auditorium_yellow_hall">Yellow hall</label>
                    </div>
                </div>
                <input id="e_submit_get_all_events" name="submit" type="submit"/>
            </form>
        </div>
        </br>
                </br>
        <div>
            <label>Remove Event</label>
            <form method="post" action="/events/removeEvent" onclick="return true">
                            <input id="in_get_certain_events_n" name="eventName" type="text" placeholder="event name"/>
                            <input id="in_get_certain_events_d" name="date" type="date"/>
                            <input id="in_get_certain_events_t" name="time" type="time"/>
                            <div id="e_module_auditorium">
                                <div>
                                    <input id="e_auditorium_blue_hall" name="e_auditorium" type="radio" value="Blue hall"/>
                                    <label for="e_auditorium_blue_hall">Blue hall</label>
                                </div>
                                <div>
                                    <input id="e_auditorium_red_hall" name="e_auditorium" type="radio" value="Red hall"/>
                                    <label for="e_auditorium_red_hall">Red hall</label>
                                </div>
                                <div>
                                    <input id="e_auditorium_yellow_hall" name="e_auditorium" type="radio" value="Yellow hall"/>
                                    <label for="e_auditorium_yellow_hall">Yellow hall</label>
                                </div>
                            </div>
                            <input id="e_submit_get_all_events" name="submit" type="submit"/>
                        </form>

                        <#if del_message??>
                            <div>Event was deleted</div>
                        </#if>
                            <#if n_del_message??>
                            <div>There are not those events</div>
                            </#if>

        </div>
    </body>
</html>