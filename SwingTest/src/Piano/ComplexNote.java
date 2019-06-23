package Piano;

import java.util.ArrayList;

public class ComplexNote extends Symbol{

	private ArrayList<Note> noteList;
	
	//Za sad samo moze da se napravi kad mu se prosledi lisa nota koje cine kompleksnu notu
	public ComplexNote(int duration,ArrayList<Note> list) {
		super(duration);
		noteList=list;
	}

	public int numOfNotes() {
		return noteList.size();
	}
	
	public Note getNote(int index) {
		return noteList.get(index);
	}
	
	public ArrayList<Note> getNoteList(){
		return noteList;
	}
	
	//Override Metode
	@Override
	public boolean isNote() {
		return true;
	}

	@Override
	public boolean isComplex() {
		return true;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		noteList.stream().forEach(e->{
			s.append(e);
			s.append("\n");
		});
		//s.deleteCharAt(s.length()-1);
		return s.toString();
	}

	
}
