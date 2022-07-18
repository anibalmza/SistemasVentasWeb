<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Sistema Ventas Web</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="btn btn-outline-light" style="margin-left: 10px; border:none" href="#">Inicio</a>
              </li>
              <li class="nav-item">
                  <a class="btn btn-outline-light" style="margin-left: 10px; border:none" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
              </li>
              <li class="nav-item">
                <a class="btn btn-outline-light" style="margin-left: 10px; border:none" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
              </li>
              <li class="nav-item">
                <a class="btn btn-outline-light" style="margin-left: 10px; border:none" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
              </li>
              <li class="nav-item">
                <a class="btn btn-outline-light" style="margin-left: 10px; border:none" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
              </li>
            </ul>
            <div class="dropdown ml-auto">
              <button class="btn btn-outline-light dropdown-toggle" style="border: none" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${usuario.getNom()}
              </button>
              <div class="dropdown-menu text-center">
                <a class="dropdown-item" href="#">
                    <img src="img/user.jpg" alt="60" width="60"/>
                </a>
                <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                <a class="dropdown-item" href="#">usuario@gmail.com</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button class="btn btn-info" name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                </form>                
            </div>  
          </div>
        </nav>
        <div class="m-4" style="height:520px">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
