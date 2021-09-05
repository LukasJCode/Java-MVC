//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> list;

    public ProjectList() {
    	this.list = new ArrayList<>();
    }

    public void setProjectList(ArrayList list) {
        this.list = list;
    }

    public void addProjet(Project proj) throws Exception {
    	loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getProjectID())
					counter++;
			}

			if (counter == 0) {
				
				proj.setProjectID(ID);
				
		 for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getDeadLine().equals(proj.getDeadLine()) && list.get(i).getWinningProposal().equals(proj.getWinningProposal()) && list.get(i).getPaymentOfProject() == proj.getPaymentOfProject())  {
					throw new Exception("Project is already in");
				}
			}
		if (proj.getName().equals("") || proj.getDeadLine().equals("") || proj.getNameOfContractor().equals("") || proj.getWinningProposal().equals("")) {
			throw new Exception("Project can't be added");
		}
		else list.add(proj);
		break loop;
			}
		}
    }
    
	public void addProjectDB(Project proj)
	{
		list.add(proj);
	}

    public int getNumberOfProject() {
        return this.list.size();
    }
    
	public int size() {
		return list.size();
	}


    public Project getProject(int index) {
        return (Project)this.list.get(index);
    }

    public Project getProjectByID(int ID) {
        for(int i = 0; i < this.list.size(); ++i) {
            if (((Project)this.list.get(i)).getProjectID() == ID) {
                return (Project)this.list.get(i);
            }
        }

        return null;
    }
    
	public void removeProjectByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProjectID() == ID) {
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
