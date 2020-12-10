/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaServidor;
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
 * @author Citlali Orduño
 */
public class MultiCliente implements Runnable {

    private Socket socket;

    public MultiCliente(Socket socket) {
        this.socket= socket;
        
    }
    
    
    @Override
    public void run() {
      SerializadorObjetos SObjeto= new SerializadorObjetos();
        try {
            InputStream is= socket.getInputStream();
            ObjectInputStream obj= new ObjectInputStream(is);
            
            Event evento = (Event) SObjeto.leerObjeto(obj);
            
           EventDispacher evDis = new EventDispacher();
           evDis.dispatch(evento);
            
        } catch (IOException ex) {
            System.out.println("Vale pedo"+ ex);
        }
        
        
    }
    
}
