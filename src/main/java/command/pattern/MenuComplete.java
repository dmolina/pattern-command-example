package command.pattern;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import command.Key;
import command.Terminal;

public class MenuComplete {
	private Terminal term;
	
	public MenuComplete(Terminal terminal) {
		this.term = terminal;
	}
	public void newMenu(String title, List<MenuItem> items) {
		Map<String, Action> actions = Maps.newHashMap();
		List<String> options = Lists.newArrayList();
		Key option;
		
		term.clear();
		term.title(title);		
		
		for (MenuItem item : items) {
			options.add(item.getOption());
			actions.put(item.getOption(), item.getAction());
		}
		
		
		do {
			for (MenuItem item : items) {
				term.out(item.toString());
			}
			MenuItem quit = new MenuItem("Q", "Salir", new MsgAction(""));
			term.out(quit.toString());
			term.lines(3);
			do {
				option = term.leeOpcion();
			} while (!option.isQuit() && !options.contains(option.toString()));
			if (!option.isQuit()) {
				Action action = actions.get(option.toString());
				action.run();
				term.lines(3);
				term.pause();				
			}
			
		} while(!option.isQuit());
		
	}
}
