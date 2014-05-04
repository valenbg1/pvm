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

				if (line.equals("") || line.startsWith("//"))
					continue;

				String[] sline = line.split("[(, )]");
				boolean match = false;

				if (sline.length == 0)
					sline[0] = line;
				

				IntInstruction_t[] int_intrs = IntInstruction_t.values();

				for (int i = 0; !match && (i < int_intrs.length); ++i) {
					if (int_intrs[i].name().equalsIgnoreCase(sline[0])) {
						match = true;
						instrs.add(new IntInstruction(int_intrs[i], Integer
								.valueOf(sline[1])));
					}
				}
				

				VoidInstruction_t[] void_intrs = VoidInstruction_t.values();

				for (int i = 0; !match && (i < void_intrs.length); ++i) {
					if (void_intrs[i].name().equalsIgnoreCase(sline[0])) {
						match = true;
						instrs.add(new VoidInstruction(void_intrs[i]));
					}
				}
				

				if (!match)
					throw new IOException();
			}
		} catch (Exception e) {
			throw new IOException("Error al leer la línea " + row + ": " + line);
		}

		return instrs;
	}
}