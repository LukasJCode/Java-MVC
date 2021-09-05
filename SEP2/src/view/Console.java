package view;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Observer;
import java.util.Scanner;


import Controller.SystemController;
import Controller.SystemControllerInterface;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class Console implements SystemView,RemoteObserver<String>, Serializable{
	private Scanner input;
	private SystemController controller;
	
	 public Console(SystemController controller) {
		 input = new Scanner(System.in);
		 
		 this.controller = controller;
//		 try {
			 this.controller.addObserver(this);
//			((RemoteSubject) controller).addObserver(this);
//		} catch (RemoteException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Override
	public void start(SystemController controller) {
		controller.execute();
	}

	@Override
	public void show(String value) {
		System.out.println(value);
	}

	@Override
	public String get(String what) {
		System.out.println("enter " + what + ": ");
		String in = input.nextLine();
		return in;
	}


	
	   public int menu()
	   {
	      System.out.println("RiseTheory MENU");
	      System.out.println("1)  getEmployees");
	      System.out.println("2)  getProjects");
	      System.out.println("3)  getPayments");
	      System.out.println("4)  getEmployeeById");
	      System.out.println("5)  getProjectsById");
	      System.out.println("6)  getPaymentsById");
	      System.out.println("7)  getMilestoneById");
	      System.out.println("8)  addEmployee");
	      System.out.println("9)  addProject");
	      System.out.println("10)  addPayment");
	      System.out.println("11)  addMilestone");
	      System.out.println("12)  removeEmployee");
	      System.out.println("13)  removeProject");
	      System.out.println("14)  removePayment");
	      System.out.println("15)  removeMilestone");
	      System.out.println("16) quit");
	      System.out.print("Select an item 1-16: ");
	      int selection = input.nextInt();
	      input.nextLine();
	      return selection;
	   }

	@Override
	public void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println(updateMsg);
	}

}
