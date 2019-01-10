
package Controlador;

import DAO.Implemets.ClienteDao;
import Modelo.Cliente;
import Modelo.Connector;
import Modelo.Zona;
import Vista.Principal;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {
         Principal view = new Principal();
         MenuController controller = new MenuController(view);
         controller.mostrar();
        
    }
    
}
