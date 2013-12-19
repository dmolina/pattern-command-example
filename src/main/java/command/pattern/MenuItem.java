package command.pattern;

import com.google.common.base.Preconditions;

public class MenuItem {
	private String id;
	private String description;
	private Action action;
	
	public MenuItem(String id, String description, Action action) {
		this.id = Preconditions.checkNotNull(id);
		this.description = Preconditions.checkNotNull(description);
		this.action = Preconditions.checkNotNull(action);
	}
	
	public String getOption() {
		return id;
	}
	
	public String toString() {
		return String.format("%s.- %s", id, description);
	}
	
	public void run() {
		action.run();
	}
	
	public Action getAction() {
		return action;
	}

}