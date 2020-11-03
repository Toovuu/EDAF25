package instructions;

import computer.ProgramCounter;
import memory.Address;
import memory.Memory;
import memory.Operand;

public class Copy implements Instruction{
	private Operand o1;
	private Address a1;

	public Copy(Operand o1, Address a1) {
		this.o1 = o1;
		this.a1 = a1;
	}

	@Override
	public void execute(Memory memory, ProgramCounter pc) {
		memory.setWord(a1, o1.getWord(memory));
	    pc.increment();
	}
}
