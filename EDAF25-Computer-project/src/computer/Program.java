package computer;

import instructions.Instruction;
import memory.Memory;

import java.util.ArrayList;

public class Program extends ArrayList<Instruction> {

    public void run(Memory memory, ProgramCounter pc) {
        while (pc.getPc() != -1) {
            this.get(pc.getPc()).execute(memory, pc);
        }
    }
}
