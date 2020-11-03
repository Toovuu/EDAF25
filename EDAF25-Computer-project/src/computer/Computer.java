package computer;

import memory.Memory;

public class Computer {
    private Memory memory;
    private Program program;
    public ProgramCounter pc;

    public Computer(Memory memory) {
        this.memory = memory;
        this.pc = new ProgramCounter();
    }

    public void load(Program program) {
        this.program = program;
    }

    public void run() {
        pc.setPc(0);
        program.run(memory, pc);
        pc.setPc(0);
    }
}
