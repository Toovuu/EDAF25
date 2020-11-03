package memory;

public class LongMemory extends Memory {

    public LongMemory(int size) {
        super(size);
    }

    @Override
    public void setWord(Address a, Word w) {
        if (w instanceof LongWord) {
            super.setWord(a, w);
        } else {
            throw new RuntimeException("LongMemory can only contain LongWords");
        }
    }
}
