package command.pattern;

import java.util.List;

import com.google.common.collect.Lists;

import command.Terminal;

public class MenuCompleteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Terminal terminal = new Terminal();
		MsgAction.setTerminal(terminal);
		MenuComplete menu = new MenuComplete(terminal);
		
		List<MenuItem> options = Lists.newLinkedList();
		options.add(new MenuItem("1", "Hello World", 
				new MsgAction("Hello, World")));
		options.add(new MenuItem("2", "2+2?", 
				new MsgAction(String.format("2+2 son %d", 2+2))));
		options.add(new MenuItem("3", "Answer to the most important question", 
				new MsgAction("42")));
		
		options.add(new MenuItem("4", "Submenu", 
				new SubMenu(menu)));
		
		menu.newMenu("Opciones chorras", options);
	}

}
