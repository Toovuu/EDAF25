package instructions;

import computer.ProgramCounter;
import memory.Memory;

public class Jump implements Instruction {
	private int pl;

	public Jump(int pl) {
		this.pl = pl;
	}

	@Override
	public void execute(Memory memory, ProgramCounter pc) {
		pc.setPc(pl);	
	}

}
