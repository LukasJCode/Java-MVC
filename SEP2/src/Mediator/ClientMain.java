package Mediator;

import Controller.ClientController;

public class ClientMain {
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		SystemClient client = new SystemClient(host);
//		SysModel model = new ModelManager();
		ClientController controler = new ClientController(client);
	}
}