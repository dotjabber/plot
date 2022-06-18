package priv.dotjabber.plot.generator;

public class ConstGenerator extends Generator {
    private final Number c;
    public ConstGenerator(Number c) {
        this.c = c;
    }

    @Override
    public void next() {
    }

    @Override
    public void previous() {
    }

    @Override
    public Number get() {
        return c;
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean hasMore() {
        return true;
    }
}
