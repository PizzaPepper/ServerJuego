package SistemaHandler;

import SistemaEventos.Event;

/**
 *
 * @author Citlali Orduño
 */

/* Clase Handler de tipo interfaz que extiende de Events */
public interface Handler<E extends Event> {

    public void onEvent(Event event);
}
