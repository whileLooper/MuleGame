
public class Game {

	private Drive drive;
	
	public Game(Drive d){
		drive = d;
		Start start = new Start(this);
		d.add(start);
	}
}
