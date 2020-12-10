package SistemaHandler;

/* Imports de librerias a utilizar. */
import SistemaEventos.Event;
import SistemaHandler.Handler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Equipo 5
 */
public class EventDispacher {

    /* Variable final de tipo privado llamada handlers que hace el mapeo, 
       extendiendo de Event. */
    private final Map<Class<? extends Event>, Handler> handlers;

    /* Constructor que inicializa handlers como un nuevo Hashmap. */
    public EventDispacher() {
        this.handlers = new HashMap<>();
    }

    /* Metodo que extiende de Event que registar en el Hanlder los 
       tipos de eventos. */
    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        handlers.put(eventType, handler);
    }

    /* Metodo que contiene al evento, mientras que handler ejecuta dicho
       evento, siempre y cuando handler sea diferente de nulo. */
    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());
        if (handler != null) {
            handler.onEvent(event);
        }
    }
}
