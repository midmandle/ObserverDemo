import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class ObserverPatternDemos {

    private ConsoleOut consoleMock;

    @BeforeEach
    void setUp() {
        consoleMock = mock(ConsoleOut.class);
    }

    @Test
    void observer_pattern_using_pull_model() {
        EventSubject subject = new EventSubject(consoleMock, 0);
        EventObserver observer1 = new EventObserver("Observer1", subject, consoleMock);
        EventObserver observer2 = new EventObserver("Observer2", subject, consoleMock);

        subject.setData(1);
        subject.detach(observer1);
        subject.setData(2);

        InOrder inOrder = inOrder(consoleMock);

        inOrder.verify(consoleMock).updateStatus("Subject: current data: 0");
        inOrder.verify(consoleMock).updateStatus("Subject: updating with data: 1");
        inOrder.verify(consoleMock).updateStatus("Subject: notifying observers");
        inOrder.verify(consoleMock).updateStatus("Observer1: event occurred.");
        inOrder.verify(consoleMock).updateStatus("Observer1 getData: 1");
        inOrder.verify(consoleMock).updateStatus("Observer2: event occurred.");
        inOrder.verify(consoleMock).updateStatus("Observer2 getData: 1");

        inOrder.verify(consoleMock).updateStatus("Subject: removing observer");
        inOrder.verify(consoleMock).updateStatus("Subject: updating with data: 2");
        inOrder.verify(consoleMock).updateStatus("Subject: notifying observers");
        inOrder.verify(consoleMock).updateStatus("Observer2: event occurred.");
        inOrder.verify(consoleMock).updateStatus("Observer2 getData: 2");
    }
}
