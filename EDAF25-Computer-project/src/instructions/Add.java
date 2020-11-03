package instructions;

import memory.Address;
import memory.Operand;
import memory.Word;

public class Add extends Arithmetic {

	public Add(Operand o1, Operand o2, Address a1) {
		super(o1, o2, a1);
	}

	@Override
	public Word performArithmetic(Word w1, Word w2) {
		return w1.add(w1, w2);
	}
}
