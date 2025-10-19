package Observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Service de notification simple implémentant SujetObservable.
 * Utilise CopyOnWriteArrayList pour être safe dans un contexte multi-thread.
 */
public class NotificationService implements SujetObservable {
    private final List<Observateur> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(Observateur o) {
        if (o != null) observers.add(o);
    }

    @Override
    public void removeObserver(Observateur o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observateur o : observers) {
            try {
                o.update(message);
            } catch (Exception ex) {
                // ignorer une erreur sur un observateur pour ne pas bloquer les autres
            }
        }
    }
}
