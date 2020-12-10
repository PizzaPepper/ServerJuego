/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaHandler;

import SistemaEventos.Event;
import SistemaHandler.Handler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Citlali Orduño
 */
public class EventDispacher {

    private final Map<Class<? extends Event>, Handler> handlers;

    public EventDispacher() {
        this.handlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        handlers.put(eventType, handler);
    }

    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());
        if (handler != null) {
            handler.onEvent(event);
        }
    }

}
