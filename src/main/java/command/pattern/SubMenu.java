package command.pattern;

import java.util.List;

import com.google.common.collect.Lists;

public class SubMenu implements Action {
	private MenuComplete menu;
	
	public SubMenu(MenuComplete menu) {
		this.menu = menu;
	}

	public void run() {
		List<MenuItem> options = Lists.newArrayList();
		options.add(new MenuItem("A", "Nombre", 
				new MsgAction("Daniel")));
		options.add(new MenuItem("B", "Apellido", 
				new MsgAction("Molina")));
		menu.newMenu("Submenu", options);
	}

}
