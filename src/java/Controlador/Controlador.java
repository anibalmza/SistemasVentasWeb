package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();    
    int ide;    // capturar el id de la fila seleccionada
    
    Empleado usuario=new Empleado();
    
    Cliente cli=new Cliente();
    ClienteDAO cdao=new ClienteDAO();    
    int idc;    // capturar el id de la fila seleccionada
    
    Producto pro=new Producto();
    ProductoDAO pdao=new ProductoDAO();    
    int idp;    // capturar el id de la fila seleccionada
    
    Venta ven=new Venta();
    VentaDAO vdao=new VentaDAO();
    List<Venta> lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    Double precio;
    int cantidad;
    Double subtotal;
    Double totalPagar;
    String numeroserie;
        
    Boolean clicEditar=false;    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            String accion=request.getParameter("accion");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
//           ########## Empleado ###########
//           ###############################
            if(menu.equals("Empleado")){
                switch (accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        em.setDni(request.getParameter("txtDni"));
                        em.setNom(request.getParameter("txtNombres"));
                        em.setTel(request.getParameter("txtTelefono"));
                        em.setEstado(request.getParameter("txtEstado"));
                        em.setUser(request.getParameter("txtUsuario"));
                        edao.agregar(em);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                        break;
                    case "Editar":
                        clicEditar=true;
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);                      
                        break;
                    case "Actualizar":
                        if(clicEditar){
                            clicEditar=false;
                            em.setDni(request.getParameter("txtDni"));
                            em.setNom(request.getParameter("txtNombres"));
                            em.setTel(request.getParameter("txtTelefono"));
                            em.setEstado(request.getParameter("txtEstado"));
                            em.setUser(request.getParameter("txtUsuario"));
                            em.setId(ide);
                            edao.actualizar(em); 
                        }
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                        break;                        
                    case "Eliminar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.eliminar(ide);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
//          ########## Cliente ############
//          ###############################
            if(menu.equals("Cliente")){
                switch (accion){
                    case "Listar":
                        List lista=cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        cli.setDni(request.getParameter("txtDni"));
                        cli.setNom(request.getParameter("txtNombres"));
                        cli.setDire(request.getParameter("txtDireccion"));
                        cli.setEstado(request.getParameter("txtEstado"));                        
                        cdao.agregar(cli);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                        break;
                    case "Editar":
                        clicEditar=true;
                        idc=Integer.parseInt(request.getParameter("id"));
                        Cliente c=cdao.listarId(idc);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                        break;
                    case "Actualizar":
                        if(clicEditar){
                            clicEditar=false;
                            cli.setDni(request.getParameter("txtDni"));
                            cli.setNom(request.getParameter("txtNombres"));
                            cli.setDire(request.getParameter("txtDireccion"));
                            cli.setEstado(request.getParameter("txtEstado"));
                            cli.setId(idc);
                            cdao.actualizar(cli);
                        }
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                        break;                        
                    case "Eliminar":
                        idc=Integer.parseInt(request.getParameter("id"));
                        cdao.eliminar(idc);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Cliente.jsp").forward(request, response);
            }
//          ########## Producto ###########
//          ###############################
            if(menu.equals("Producto")){
                switch (accion){
                    case "Listar":
                        List lista=pdao.listar();
                        request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                        pro.setNom(request.getParameter("txtNombres"));
                        pro.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
                        pro.setStock(Integer.parseInt(request.getParameter("txtStock")));
                        pro.setEstado(request.getParameter("txtEstado"));                        
                        pdao.agregar(pro);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                        break;
                    case "Editar":
                        clicEditar=true;
                        idp=Integer.parseInt(request.getParameter("id"));
                        Producto p=pdao.listarId(idp);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                        break;
                    case "Actualizar":
                        if(clicEditar){
                            clicEditar=false;
                            pro.setNom(request.getParameter("txtNombres"));
                            pro.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
                            pro.setStock(Integer.parseInt(request.getParameter("txtStock")));
                            pro.setEstado(request.getParameter("txtEstado"));
                            pro.setId(idp);
                            pdao.actualizar(pro);
                        }
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                        break;                        
                    case "Eliminar":
                        idp=Integer.parseInt(request.getParameter("id"));
                        pdao.eliminar(idp);
                        //actualizar la tabla
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }               
//          ######### NuevaVenta ##########
//          ###############################
            if(menu.equals("NuevaVenta")){
                switch (accion){
                    case "BuscarCliente":
                        String dni=request.getParameter("codigocliente");
                        cli.setDni(dni);
                        cli=cdao.buscar(dni);
                        request.setAttribute("cliente", cli);
                        request.setAttribute("nserie", numeroserie);
                        break;
                    case "BuscarProducto":
                        int id=Integer.parseInt(request.getParameter("codigoproducto")); //recibe datos del formulario
                        pro=pdao.listarId(id);
                        request.setAttribute("cliente", cli); 
                        request.setAttribute("producto", pro); //enviar los datos al formulario
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("nserie", numeroserie);
                        break;
                    case "Agregar":
                        request.setAttribute("cliente", cli);
//                        totalPagar=0.0;
                        item=item+1;
                        cod=pro.getId();
                        descripcion=request.getParameter("nombreproducto");
                        precio=Double.parseDouble(request.getParameter("precio"));
                        cantidad=Integer.parseInt(request.getParameter("cantidad"));
                        subtotal=precio*cantidad;
                        ven=new Venta();
                        ven.setItem(item);
                        ven.setIdproducto(cod);
                        ven.setDescripcionP(descripcion);
                        ven.setPrecio(precio);
                        ven.setCantidad(cantidad);
                        ven.setSubtotal(subtotal);
                        lista.add(ven);
                        totalPagar=0.0;
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar=totalPagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                        request.setAttribute("nserie", numeroserie);
                        break;
                    case "GenerarVenta":
                        // Actualizar stock
                        for (int i = 0; i < lista.size(); i++) {
                            Producto pr=new Producto();
                            int cantidad=lista.get(i).getCantidad();
                            int idproducto=lista.get(i).getIdproducto();
                            ProductoDAO ao=new ProductoDAO();
                            pr=ao.buscar(idproducto);
                            int sac=pr.getStock()-cantidad;
                            ao.actualizarStock(idproducto, sac);
                        }                        
                        // Guardar Venta
                        ven.setIdcliente(cli.getId());
                        ven.setIdempleado(3);
                        ven.setNumserie(numeroserie);
                        ven.setFecha("2022-06-19");
                        ven.setMonto(totalPagar);
                        ven.setEstado("1");
                        vdao.guardarVenta(ven);
                        // Guardar Detalle Venta
                        int idv=Integer.parseInt(vdao.IdVentas());
                        for (int i = 0; i < lista.size(); i++) {
                            ven=new Venta();
                            ven.setId(idv);
                            ven.setIdproducto(lista.get(i).getIdproducto());
                            ven.setCantidad(lista.get(i).getCantidad());
                            ven.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleVentas(ven);
                        }
                        request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request,response); 
//                        request.getRequestDispatcher("Principal.jsp").forward(request, response);
//                        menu="NuevaVenta";
//                        accion="default";
                        break;
                    default:
                        numeroserie=vdao.GenerarSerie();
                        if(numeroserie==null){
                            numeroserie="00000001";                         
                        }else{
                            int incrementar=Integer.parseInt(numeroserie);
                            GenerarSerie gs=new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                        }
                        request.setAttribute("nserie", numeroserie);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
//                request.setAttribute("nserie", numeroserie);
//                menu="NuevaVenta";
//                accion="default";
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    // Metodo para activar y desactivar Controles
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }
    
    public void enableButton(){
        System.out.print("enableButton");
        enable=true;
    }
    
    public void disableButton(){
        enable=false;
    }
}
