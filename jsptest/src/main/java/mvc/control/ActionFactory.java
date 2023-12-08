package mvc.control;

import mvc.action.Action;
import mvc.action.indexAction;

public class ActionFactory {
	private static ActionFactory factory = new ActionFactory(); // 싱글톤1

	private ActionFactory() {
	} // 싱글톤2

	public static synchronized ActionFactory getInstance() { // 싱글톤3
		return factory;
	}

	// 어떤 action을 진핼할지 결정하는 함수
	public Action getAction(String cmd) {
		Action action = null;
		switch (cmd) {
		case "index":
			action = new indexAction();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + cmd);
		}
		return action;
	}
}
