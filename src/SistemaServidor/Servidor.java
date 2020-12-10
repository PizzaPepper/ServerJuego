package SistemaServidor;

/* Librerias a utilizar. */
import dominio.Jugador;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class Servidor {

    /* Variables a utilizar. */
    private ArrayList<Jugador> jugadores;
    private ServerSocket server;
    private final int PUERTO = 3312;

    /* Metodo que realiza la conexion entre el cliente y el servidor. */
    public void loop() throws IOException {
        server= new ServerSocket(PUERTO);
        
        try{
            while(true){
                new Thread(new MultiCliente(server.accept())).start();                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
