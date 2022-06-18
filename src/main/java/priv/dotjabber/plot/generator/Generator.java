package priv.dotjabber.plot.generator;

public abstract class Generator {
    public abstract void next();
    public abstract void previous();
    public abstract Object get();
    public abstract void reset();
    public abstract boolean hasMore();
}
