package mvcMem.control;

import mvcMem.action.*;

public class ActionFactory {
	private static ActionFactory factory = new ActionFactory();

	private ActionFactory() {
	}

	public static synchronized ActionFactory getInstance() {
		return factory;
	}
	
	public Action getAction(String cmd) {
		System.out.println("Action.getAction");
		Action action = null;
		switch (cmd) {
		case "index":
			System.out.println(cmd);
			action = new IndexAction();
			break;
		case "login":
			System.out.println(cmd);
//			action = new LoginFormAction();
			break;
		case "loginProc":
			System.out.println(cmd);
//			action = new LoginProcAction();
			break;
		case "logout":
			System.out.println(cmd);
//			action = new LogoutAction();
			break;
		case "regForm":
			System.out.println(cmd);
//			action = new RegFormAction();
			
			break;
		case "regProc":
			System.out.println(cmd);
//			action = new RegProcAction();
			break;
		case "modifyForm":
			System.out.println(cmd);
//			action = new ModifyFormAction();
			break;
		case "modifyProc":
			System.out.println(cmd);
//			action = new ModifyProcAction();
			break;
		case "deleteForm":
			System.out.println(cmd);
//			action = new DeleteFormAction();
			break;
		case "deleteProc":
			System.out.println(cmd);
//			action = new DeleteProcAction();
			break;
		case "idCheck":
			System.out.println(cmd);
//			action = new IdCheckAction();
			break;
		case "zipCheck":
			System.out.println(cmd);
//			action = new ZipCheckAction();
			break;
		default:
			System.out.println(cmd);
			action = new IndexAction();
			break;
		}
		return action;
	}
}
