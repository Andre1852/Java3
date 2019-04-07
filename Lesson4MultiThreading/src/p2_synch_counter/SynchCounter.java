package p2_synch_counter;

public class SynchCounter {//используется синхронизация
    int c;

    public int value() { return c; }

    public SynchCounter() {
        c = 0;
    }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec() {
        c--;
    }
}
