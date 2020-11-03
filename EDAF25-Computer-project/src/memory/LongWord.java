package memory;

public class LongWord extends Word {
    private long value;

    public LongWord(long value) {
        this.value = value;
    }

    @Override
    public Word add(Word w1, Word w2) {
        return new LongWord(((LongWord) w1).value + ((LongWord) w2).value);
    }

    @Override
    public Word mul(Word w1, Word w2) {
        return new LongWord(((LongWord) w1).value * ((LongWord) w2).value);
    }

    @Override
    public boolean equals (Object o) {
        return this.value == ((LongWord) o).value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
