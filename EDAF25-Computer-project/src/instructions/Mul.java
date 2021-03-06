package instructions;

import computer.ProgramCounter;
import memory.Address;
import memory.Memory;
import memory.Operand;
import memory.Word;

public class Mul implements Instruction{
    private Operand o1, o2;
    private Address a1;

    public Mul(Operand o1, Operand o2, Address a1) {
        this.o1 = o1;
        this.o2 = o2;
        this.a1 = a1;
    }

    @Override
    public void execute(Memory memory, ProgramCounter pc) {
        Word w1 = o1.getWord(memory);
        Word w2 = o2.getWord(memory);
        Word sum = w1.mul(w1, w2);
        memory.setWord(a1, sum);
        pc.increment();
    }
}
