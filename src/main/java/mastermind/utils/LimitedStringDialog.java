package mastermind.utils;

public class LimitedStringDialog {

	private String title;
	
	private ClosedInterval limits;
	
	private ClosedIntervalView limitsView;
	
	public LimitedStringDialog(String title, String characters){
		assert title != null;
		this.limits = new ClosedInterval(characters);
		limitsView = new ClosedIntervalView("Solo podrá ingresar los caracteres ", limits);
		this.title = title + " " + limitsView + ": ";
	}
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = true;
			if (!ok) {
				limitsView.writeln();
			}
		} while (!ok);
		return value;
	}
}
