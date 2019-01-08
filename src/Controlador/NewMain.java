
package Controlador;

import DAO.Implemets.ClienteDao;
import DAO.Implemets.ZonaDao;
import Modelo.Cliente;
import Modelo.Connector;
import Modelo.Zona;
import Vista.Principal;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {
//         Principal view = new Principal();
//         MenuController controller = new MenuController(view);
//         controller.mostrar();
         Zona zona = new Zona();
         zona.setId(3);
         zona.setNombre("asd");
         ZonaDao d = new ZonaDao();
//         String res = d.delete(zona);
//         String res = d.edit(zona);
//         String res = d.insert(zona);
//         ArrayList<Zona> res = d.list("T");
//         for(int i = 0; i<res.size(); i++){
//             System.out.println(res.get(i).getNombre());
//         }
         Zona res = d.search(zona);
         System.out.println(res.getId()+"  "+ res.getNombre());
           
            
//         Cliente cli = new Cliente();
//         cli.setNombre("pedro");
//         cli.setApellidos("Paredes Pardo");
//         cli.setDireccion("calle isidro");
//         cli.setZona(zona);
//         
//         ClienteDao dao = new ClienteDao();
//         String res = dao.insert(cli);
//         System.out.println(res);

    }
    
}
