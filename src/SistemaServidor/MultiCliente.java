package SistemaServidor;

/* Librerias a utilizar. */
import java.net.Socket;
import Serializador.SerializadorObjetos;
import SistemaHandler.EventDispacher;
import SistemaHandler.Handler;
import SistemaEventos.Event;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author Equipo 5
 */
public class MultiCliente implements Runnable {

    /* Variable de tipo Socket. */
    private Socket socket;

    /* Constructor que inicializa la variable. */
    public MultiCliente(Socket socket) {
        this.socket = socket;
    }

    /* Metodo run que hace funcionar a la clase de MultiCliente, en caso de 
       que no pueda iniciar correctamente dicho metodo, se lanza una 
       excepcion. */
    @Override
    public void run() {
        SerializadorObjetos SObjeto = new SerializadorObjetos();
        try {
            InputStream is = socket.getInputStream();
            ObjectInputStream obj = new ObjectInputStream(is);

            Event evento = (Event) SObjeto.leerObjeto(obj);

            EventDispacher evDis = new EventDispacher();
            evDis.dispatch(evento);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
