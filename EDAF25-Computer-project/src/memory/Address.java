package memory;

public class Address implements Operand {
    public final int INDEX;

    public Address(int INDEX) {
        this.INDEX = INDEX;
    }

    @Override
    public Word getWord(Memory memory) {
        return memory.getWord(this);
    }
}
