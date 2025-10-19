package Observer;

/**
 * Interface Sujet (Observable).
 */
public interface SujetObservable {
    void addObserver(Observateur o);
    void removeObserver(Observateur o);
    void notifyObservers(String message);
}
