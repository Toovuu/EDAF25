package computer;

public class ProgramCounter {
    private int pc = 0;

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void increment() {
        pc++;
    }
}
