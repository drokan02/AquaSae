
package Controlador;

import DAO.Implemets.ClienteDao;
import Modelo.Cliente;
import Modelo.Connector;
import Modelo.Zona;
import Vista.Principal;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {
         /*Principal view = new Principal();
         MenuController controller = new MenuController(view);
         controller.mostrar();*/
         Zona zona = new Zona();
         zona.setNombre("Pucara Grande");
         Cliente cli = new Cliente();
         cli.setNombre("pedro");
         cli.setApellidos("Paredes Pardo");
         cli.setDireccion("calle isidro");
         cli.setZona(zona);
         
         ClienteDao dao = new ClienteDao();
         String res = dao.insert(cli);
         System.out.println(res);
    }
    
}
