package Controlador;

import Vista.frmusuariologin;

/**
 *
 * @author Leonardo
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        frmusuariologin form=new frmusuariologin();
        form.toFront();
        form.setVisible(true);  
        
    }
    
}
