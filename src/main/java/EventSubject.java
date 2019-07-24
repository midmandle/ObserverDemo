public class EventSubject extends AbstractSubject{
    private final ConsoleOut consoleOut;
    private int data;

    public EventSubject(ConsoleOut consoleOut, int data) {
        this.consoleOut = consoleOut;
        this.data = data;
        this.consoleOut.updateStatus("Subject: current data: " + data);
    }

    public void setData(int data) {
        this.data = data;
        this.consoleOut.updateStatus("Subject: updating with data: " + data);
        this.consoleOut.updateStatus("Subject: notifying observers");
        this.notifyObservers();
    }

    public int getData() {
        return this.data;
    }

    @Override
    public void detach(EventObserver observer) {
        consoleOut.updateStatus("Subject: removing observer");
        super.detach(observer);
    }
}
