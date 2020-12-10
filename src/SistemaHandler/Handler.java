package SistemaHandler;

import SistemaEventos.Event;

/**
 *
 * @author Equipo 5
 */

/* Clase Handler de tipo interfaz que extiende de Events */
public interface Handler<E extends Event> {

    public void onEvent(Event event);
}
