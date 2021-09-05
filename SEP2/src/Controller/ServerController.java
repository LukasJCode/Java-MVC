package Controller;

import Mediator.ModelManager;
import Mediator.SysModel;
import view.Console;
import view.SystemView;

public class ServerController extends SystemController{

	public ServerController(SysModel model) {
		super(model);
		SystemView view = new Console(this);
		view.start(this);
	}
	
}
