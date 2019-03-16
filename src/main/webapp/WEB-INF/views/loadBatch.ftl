<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/resources/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <div id="linkHomePage">
                 <ul>
                    <li class="li-style"><a href="/">Home Page</a></li>
                    <li class="li-style">Load</li>
                 </ul>
        </div>
             </br>
             </br>
             <div>
                <form method="post" action="/load/fileUsers" enctype="multipart/form-data" onclick = "return true">
                               <label>Load users batch</label>
                                <input id="file" name="file" type="file"/>
                                <input id="submit" name="submit" type="submit" placeholder="submit"/>
                           </form>
                  <#if success_u??>
                        <div>File was loaded</div>
                  </#if>
             </div>
             </br>
             </br>
             <div>
                <form method="post" action="/load/fileEvents" enctype="multipart/form-data" onclick = "return true">
                   <label>Load events batch</label>
                        <input id="file" name="file" type="file"/>
                                <input id="submit" name="submit" type="submit" placeholder="submit"/>
                           </form>
                           <#if success_e??>
                                                   <div>File was loaded</div>
                                             </#if>
             </div>
    </body>
</html>