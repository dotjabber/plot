package priv.dotjabber.plot.generator;

public class IntSeqGenerator extends Generator {
    private final int start;
    private final int step;
    private final int end;
    private int current;

    public IntSeqGenerator(int start, int step, int end) {
        this.start = start;
        this.step = step;
        this.end = end;
        this.current = start;
    }

    @Override
    public void next() {
        if(current < end) current += step;
    }

    @Override
    public void previous() {
        if(current > start) current -= step;
    }

    @Override
    public Integer get() {
        return current;
    }

    @Override
    public void reset() {
        current = start;
    }

    @Override
    public boolean hasMore() {
        return current != end;
    }
}
