package Controller;

import Mediator.ModelManager;
import Mediator.SysModel;
import view.Console;
import view.SystemView;

public class ClientController extends SystemController{

	public ClientController(SysModel model) {
		super(model);
		SystemView view = new Console(this);
		view.start(this);
	}
	

}
