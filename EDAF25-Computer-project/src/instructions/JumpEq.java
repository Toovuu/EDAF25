package instructions;

import computer.ProgramCounter;
import memory.Memory;
import memory.Operand;

public class JumpEq implements Instruction {
	private int pl;
	private Operand o1, o2;
	
	public JumpEq(int pl, Operand o1, Operand o2) {
		this.pl = pl;
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void execute(Memory memory, ProgramCounter pc) {
		if (o1.getWord(memory).equals(o2.getWord(memory))) {
			pc.setPc(pl);
		}
		else pc.increment();
	}
}
