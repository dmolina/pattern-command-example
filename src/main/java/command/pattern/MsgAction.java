package command.pattern;

import command.Terminal;

public class MsgAction implements Action {
	private static Terminal term;
	private String msg;
	
	public static void setTerminal(Terminal term) {
		MsgAction.term = term;
	}
	
	public MsgAction(String msg) {
		term.lines(3);
		this.msg = msg;
	}

	public void run() {
		term.out(msg);
	}

}
