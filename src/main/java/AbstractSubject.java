import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {
    private List<EventObserver> observers = new ArrayList<EventObserver>();

    public void attach(EventObserver observer) {
         this.observers.add(observer);
    }

    protected void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }

    public void detach(EventObserver observer) {
        observers.remove(observer);
    }
}
