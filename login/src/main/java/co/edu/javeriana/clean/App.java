package co.edu.javeriana.clean;

import co.edu.javeriana.clean.interfaces.main.MenuIngreso;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MenuIngreso menuIngreso = new MenuIngreso();
        menuIngreso.mostrarMenu();
    }
}
