package pvm.assembler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pvm.vm.instructions.Instruction;
import pvm.vm.instructions.IntInstruction;
import pvm.vm.instructions.VoidInstruction;
import pvm.vm.instructions.IntInstruction.IntInstruction_t;
import pvm.vm.instructions.VoidInstruction.VoidInstruction_t;

public class PAssembler {
	private int row;
	private final BufferedReader file;

	public PAssembler(BufferedReader file) {
		this.row = 0;
		this.file = file;
	}

	public List<Instruction> assemble() throws IOException {
		String line = "";
		ArrayList<Instruction> instrs = new ArrayList<Instruction>();

		try {
			while ((line = file.readLine()) != null) {
				++row;
				line = line.toUpperCase();

				if (line.equals("") || line.startsWith("//"))
					continue;

				String[] sline = line.split("[(, )]");

				if (sline.length == 0)
					sline[0] = line;
				
				try {
					instrs.add(new IntInstruction(IntInstruction_t.valueOf(sline[0]), Integer.valueOf(sline[1])));
					continue;
				} catch (Exception e) { }
				
				try {
					instrs.add(new VoidInstruction(VoidInstruction_t.valueOf(sline[0])));
					continue;
				} catch (Exception e) { }

				throw new IOException();
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la línea " + row + ": " + line);
		}

		return instrs;
	}
}