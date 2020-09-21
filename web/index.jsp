<%-- 
    Document   : index.jsp
    Author     : María del Carmen Reyes Rocha

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
         <form action="LoginServlet" method="post">
            <h1> Acceso al sistema Alumnos </h1>
            Usuario : <input type="text" name="uname"><br><br>
            Contraseña : <input type="password" name="pass"><br><br>
            <input type="submit" value="Iniciar sesion">
        </form>
    </body>
</html>
