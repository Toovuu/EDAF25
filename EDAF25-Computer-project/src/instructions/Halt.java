package instructions;

import computer.ProgramCounter;
import memory.Memory;

public class Halt implements Instruction {
	
	@Override
	public void execute(Memory memory, ProgramCounter pc) {
		pc.setPc(-1);	
	}
}
