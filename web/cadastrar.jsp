<%-- 
    Document   : cadastrar
    Created on : 28/04/2016, 21:11:56
    Author     : Maicon
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de contato</title>
    </head>
    <body>
        <h1>Cadastro de contato</h1>
        <div>
            <form action="cadastrarContato" method="post">
                Nome: <input type="text" name="nome"/><br>
                Telefone:<input type="text" name="telefone"/><br>
                <input type="submit" value="Adicionar"/>
            </form>
        </div>
    </body>
</html>
