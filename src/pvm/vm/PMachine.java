package pvm.vm;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import pvm.vm.exceptions.InvalidMemoryPosException;
import pvm.vm.exceptions.InvalidValueTypeException;
import pvm.vm.instructions.Instruction;
import pvm.vm.values.Value;

public class PMachine {
	private Stack<Value> stack;

	private Map<Integer, Value> mem;

	private List<Instruction> prog;
	private int p_prog;

	private boolean run;

	public PMachine(List<Instruction> prog) {
		this.stack = new Stack<Value>();

		this.mem = new HashMap<Integer, Value>();

		this.prog = new ArrayList<Instruction>(prog);
		this.p_prog = 0;

		this.run = true;
	}

	public Map<Integer, Value> getMem() {
		return mem;
	}

	public int getP_prog() {
		return p_prog;
	}

	public Stack<Value> getStack() {
		return stack;
	}

	public void incP_prog() {
		++p_prog;
	}

	public boolean isRunnning() {
		return run;
	}

	public void run() throws EmptyStackException, InvalidValueTypeException, InvalidMemoryPosException {
		while (run && (p_prog < prog.size()))
			prog.get(p_prog).execute(this);
	}

	public void setP_prog(int p_prog) {
		this.p_prog = p_prog;
	}

	public void setRunnning(boolean run) {
		this.run = run;
	}
}