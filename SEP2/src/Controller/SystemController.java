package Controller;

import java.io.Serializable;

import Mediator.ModelManager;
import Mediator.SysModel;
import utility.observer.RemoteObserver;
import view.Console;
import view.SystemView;

public class SystemController implements Serializable {
	private SysModel model;
	private SystemView view;

	public SystemController(SysModel model) {
		this.model = model;
		this.view = new Console(this);
		
	}

	public void addObserver(RemoteObserver remoteObserver) {
		this.model.addObserver(remoteObserver);
	}
	public String execute() {
		String msg = "";
		int input = 0;
		int menuSelection;
		do {
			menuSelection = view.menu();
			switch (menuSelection) {
			case 1:
				String result = "" + model.getAllEmployees();
				view.show(result);
				break;
			case 2:
				result = "" + model.getAllProjects();
				view.show(result);
				break;
			case 3:
				result = "" + model.getAllPayments();
				view.show(result);
				break;
			case 4:

				input = Integer.parseInt(view.get("ID"));

				result = "" + model.getEmployeeById(input);

				if (result != null && result.isEmpty())
					result = "No Employee with given ID";
				view.show(result);
				break;
			case 5:

				input = Integer.parseInt(view.get("ID"));
				result = "" + model.getProjectById(input);
				
				if (result != null && result.isEmpty())
					result = "No Project with given ID";
				view.show(result);
				break;
			case 6:
				input = Integer.parseInt(view.get("ID"));
				result = "" + model.getPaymentById(input);
				if (result != null && result.isEmpty())
					result = "No Payments with given ID";
				view.show(result);
				break;
			case 7:
				input = Integer.parseInt(view.get("ID"));
				result = "" + model.getMilestoneById(input);
				if (result != null && result.isEmpty())
					result = "No Milestone with given ID";
				view.show(result);
				break;
			case 8:
				view.show("not done");
				break;
			case 9:
				view.show("not done");
				break;
			case 10:
				view.show("not done");
				break;
			case 11:
				view.show("not done");
				break;
			case 12:
				input = Integer.parseInt(view.get("ID"));

				result = "";
				for (int j = 0; j < model.getAllEmployees().size(); j++) {
					if (model.getAllEmployees().getEmployee(j).getEmployeeID() == input) {
						result = "employee is deleted";
						model.removeEmployeeById(input);
						view.show(result);
						break;
					}
				}

				if (result != null && result.isEmpty()) {
					result = "No Employee with given ID";
					view.show(result);
				}

				break;

			case 13:
				input = Integer.parseInt(view.get("ID"));
				
				result = "";
				for (int j = 0; j < model.getAllProjects().size(); j++) {
					if (model.getAllProjects().getProject(j).getProjectID() == input) {
						result = "project is deleted";
						model.removeProjectById(input);
						view.show(result);
						break;
					}
				}
				if (result != null && result.isEmpty()) {
					result = "No Project with given ID";
					view.show(result);
				}
				break;
			case 14:
				input = Integer.parseInt(view.get("ID"));
				result = "";
				for (int j = 0; j < model.getAllPayments().size(); j++) {
					if (model.getAllPayments().getPayment(j).getPaymentID() == input) {
						result = "payment is deleted";
						model.removePaymentById(input);
						view.show(result);
						break;
					}
				}
				if (result != null && result.isEmpty()) {
					result = "No Payment with given ID";
					view.show(result);
				}
				break;
			case 15:
				input = Integer.parseInt(view.get("ID"));
		
				result = "";
				for (int j = 0; j < model.getAllMilestones().size(); j++) {
					if (model.getAllMilestones().getMilestone(j).getMilestoneID() == input) {
						result = "Milestone is deleted";
						model.removeMilestoneById(input);
					}
				}
				if (result != null && result.isEmpty()) {
					result = "No Milestone with given ID";
					view.show(result);

			}
				break;
			}
		} while (menuSelection != 16);
		return null;
	}
	
}