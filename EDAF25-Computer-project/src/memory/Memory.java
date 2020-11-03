package memory;

public abstract class Memory {
    private Word[] words;

    public Memory(int size) {
        this.words = new Word[size];
    }

    public Word getWord(Address a) {
        return words[a.INDEX];
    }

    public void setWord(Address a, Word w) {
        words[a.INDEX] = w;
    }
}
