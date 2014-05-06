package pvm.vm.heap;

public class Segment {
	public final int ini_dir;
	public final int size;

	public Segment(int ini_dir, int size) {
		this.ini_dir = ini_dir;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "(" + ini_dir + ", " + size + ")";
	}
}