package priv.dotjabber.plot.generator;

public class IntSeqGenerator extends Generator {
    private Integer start;
    private final Integer step;

    public IntSeqGenerator(Integer start, Integer step) {
        this.start = start;
        this.step = step;
    }

    @Override
    public void next() {
        start += step;
    }

    @Override
    public void previous() {
        start -= step;
    }

    @Override
    public Integer get() {
        return start;
    }
}
