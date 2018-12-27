
package Controlador;

import Vista.Principal;

public class NewMain {

    public static void main(String[] args) {
          Principal view = new Principal();
          MenuController controller = new MenuController(view);
          controller.mostrar();
    }
    
}
