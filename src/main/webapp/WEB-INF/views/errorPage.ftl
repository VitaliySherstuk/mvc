<html lang="en">
<head>

</head>
<body>
     <div id="linkHomePage">
        <ul>
           <li class="li-style"><a href="/">Home Page</a></li>
           <li class="li-style">Error page</li>
        </ul>
     </div>
</br>
</br>
<div>Exception: </div>
<#if message??>
<div>${message}</div>
</#if>
<br>
<br>
<#if stackTrace??>
<div>stackTrace: ${stackTrace}</div>
</#if>
</body>
</html>
