package computer;

import memory.LongMemory;

public class Main {

    public static void main(String[] args) {
        Computer c = new Computer(new LongMemory(100));
        c.load(new Factorial());
        c.run();
    }
}
