import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {
    private List<AbstractEventObserver> observers = new ArrayList<>();

    public void attach(AbstractEventObserver observer) {
         this.observers.add(observer);
    }

    public void detach(AbstractEventObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }
}
