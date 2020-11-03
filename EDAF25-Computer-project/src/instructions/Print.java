package instructions;

import computer.ProgramCounter;
import memory.Memory;
import memory.Operand;

public class Print implements Instruction {
    private Operand o1;

    public Print(Operand o1){
        this.o1 = o1;
    }

    @Override
    public void execute(Memory memory, ProgramCounter pc) {
        System.out.println(o1.getWord(memory));
        pc.increment();
    }
}
