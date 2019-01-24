
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
    }
    
}
