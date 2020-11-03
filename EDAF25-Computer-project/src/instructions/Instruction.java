package instructions;

import computer.ProgramCounter;
import memory.Memory;

public interface Instruction {
    void execute(Memory memory, ProgramCounter pc);
}
