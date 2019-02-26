<html lang="en">
    <head>
        <title>SpringMVC</title>
        <link href="/css/springmvc.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
         <div id="linkHomePage">
             <ul>
                <li class="li-style"><a href="/">Home Page</a></li>
                <li class="li-style"><a href="/users">Users</a></li>
                <li class="li-style">UserByName</li>
             </ul>
         </div>
         </br>
         </br>
         <div>
            <table border="1">
                <thead>
                     <tr>
                         <th>name</th>
                         <th>email</th>
                         <th>birthday</th>
                     </tr>
                </thead>
                <tbody>
                    <#list users as user>
                       <tr>
                           <td>${user.name}</td>
                           <td>${user.email}</td>
                           <td>${user.birthday}</td>
                       </tr>
                    </#list>
                </tbody>
            </table>
         </div>
    </body>
</html>