package pvm.vm.heap;

public class Segment {
	public final int ini_dir;
	public final int size;

	public Segment(int ini_dir, int size) {
		this.ini_dir = ini_dir;
		this.size = size;
	}
	
	public Segment join(Segment s){
		if(s.ini_dir < this.ini_dir){
			if(s.ini_dir + s.size == this.ini_dir)
				return new Segment(s.ini_dir, s.size + this.size);
			else
				return null;
		}else{
			if(this.ini_dir + this.size == s.ini_dir)
				return new Segment(this.ini_dir, this.size + s.size);
			else
				return null;
		}
	}
	
	@Override
	public String toString() {
		return "(" + ini_dir + ", " + size + ")";
	}
}