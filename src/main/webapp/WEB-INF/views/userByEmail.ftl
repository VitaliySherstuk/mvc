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
                <li class="li-style">UserByEmail</li>
             </ul>
         </div>
         </br>
         </br>
         <#if present??>
             <div>
                <table border="1">
                    <thead>
                         <tr>
                             <th>email</th>
                             <th>name</th>
                             <th>birthday</th>
                         </tr>
                    </thead>
                    <tbody>
                           <tr>
                               <td>${user.email}</td>
                               <td>${user.name}</td>
                               <td>${user.birthday}</td>
                           </tr>
                    </tbody>
                </table>
             </div>
         </#if>

    </body>
</html>