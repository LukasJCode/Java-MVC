package Model;

import java.util.ArrayList;

public class MilestoneList {

	private ArrayList<Milestone> list;

	public MilestoneList() {
		this.list = new ArrayList<Milestone>();
	}
	
	public void setMilestoneList(ArrayList<Milestone> list) {
		this.list = list;
	}

	public void addMilestone(Milestone mil) throws Exception{
    	loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getMilestoneID())
					counter++;
			}

			if (counter == 0) {

				mil.setMilestoneID(ID);

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getDescription().equals(mil.getDescription()) && list.get(i).getPrice().equals(mil.getPrice()) && list.get(i).getDeadline().equals(mil.getDeadline()))  {
						throw new Exception("Employee is already in");
					}
				}
				if (mil.getDescription().equals("") || mil.getPrice() == null  || mil.getProjectID() == null) {
					throw new Exception("Give at least description, price, and project id");
				} else

					list.add(mil);

				break loop;
			}

		}
	}

	public void addMilestoneDB(Milestone mil)
	{
		list.add(mil);
	}

	public Milestone getByID(int id) {
		return list.get(id);
	}
	
	public int getNumberOfMilestones() {
		return list.size();
	}
	
	public int size() {
		return list.size();
	}
	
	public Milestone getMilestone(int index) {
		return list.get(index);
	}
	
	public Milestone getMilestoneByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMilestoneID() == ID) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public void removeMilestoneByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMilestoneID() == ID) {
				list.remove(i);
			}
		}
	}
	
	public String toString() {
		String all="";
		for (int i = 0; i < list.size(); i++) {
			all+= i +1 + ". " + list.get(i) + "\n";
		}
		return all;
	}
}
