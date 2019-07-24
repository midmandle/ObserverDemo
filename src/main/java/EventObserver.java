public class EventObserver extends AbstractEventObserver{
    private ConsoleOut consoleOut;
    private String observerName;
    private EventSubject subject;

    public EventObserver(String observerName, EventSubject subject, ConsoleOut consoleOut) {
        this.consoleOut = consoleOut;
        this.observerName = observerName;
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    void update() {
        consoleOut.updateStatus(observerName + ": event occurred.");
        consoleOut.updateStatus(observerName + " getData: " + subject.getData());
    }
}
