
package Controlador;

import DAO.Implemets.ClienteDao;
import DAO.Implemets.PedidoDao;
import DAO.Implemets.ProductoDao;
import DAO.Implemets.ZonaDao;
import Modelo.Cliente;
import Modelo.Connector;
import Modelo.Producto;
import Modelo.Zona;
import Modelo.Pedido;
import Vista.Principal;
import java.util.ArrayList;
import java.util.Date;

public class NewMain {

    public static void main(String[] args) {
         Principal view = new Principal();
         MenuController controller = new MenuController(view);
         controller.mostrar();
         
//         Zona zona = new Zona();
//         zona.setId(7);
//         zona.setNombre("Prado");
//         ZonaDao d = new ZonaDao();
//         String res = d.delete(zona);
//         String res = d.edit(zona);
//         String res = d.insert(zona);
//         ArrayList<Zona> res = d.list("T");
//         for(int i = 0; i<res.size(); i++){
//             System.out.println(res.get(i).getNombre());
//         }
//         Zona res = d.search(zona);
//         System.out.println(res.getId()+"  "+ res.getNombre());
           
            
//         Cliente cli = new Cliente();
//         cli.setId(2);
//         cli.setNombre("Pedro");
//         cli.setApellidos("Paredes Pardo");
//         cli.setDireccion("Calle Ballivián");
//         cli.setZona(zona);
         
         Producto producto = new Producto();
         producto.setId(1);
         producto.setDescripcion("Prob Insert pedidos");
         producto.setNombre("Agua con gas");
         producto.setPrecio(15.5);
         producto.setStock(6);
//         
//         ClienteDao dao = new ClienteDao();
//         String res = dao.insert(cli);
//         System.out.println(res);
//            Date fecha = new Date();
//            
//            System.out.println(fecha.getTime());



//           PedidoDao p = new PedidoDao();
//           Pedido pedido = new Pedido();
//           pedido.setId(3);
//           pedido.setCliente(cli);
//           pedido.setProducto(producto);
//           pedido.setCantidad(10);
//           pedido.setTotal(350.555555);
//           pedido.setEntregado(0);
           
//           p.delete(pedido);
           
//           System.out.println(p.search(pedido).getId()+""+p.search(pedido).getFecha_pedido());
//           ArrayList<Pedido> res = p.list("");
//           for(int i = 0; i<=res.size(); i++){
//             System.out.println("ID:"+res.get(i).getId()+"-Cantidad"+ res.get(i).getCantidad()+
//                     "-Fecha:"+res.get(i).getFecha_pedido()+"-Total"+res.get(i).getTotal());
//         }
//         Zona res = d.search(zona);
        
    }
    
}
