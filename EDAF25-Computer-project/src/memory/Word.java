package memory;

public abstract class Word implements Operand {

    @Override
    public Word getWord(Memory memory) {
        return this;
    }

    public abstract Word add(Word w1, Word w2);
    public abstract Word mul(Word w1, Word w2);
}
