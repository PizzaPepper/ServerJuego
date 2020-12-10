/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaServidor;

import dominio.Jugador;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author Citlali Orduño
 */
public class Servidor {

    private ArrayList<Jugador> jugadores;
    private ServerSocket server;
    private final int PUERTO = 3312;

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
