//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

import java.util.ArrayList;

public class PaymentList {
    private ArrayList<Payment> list ;

    public PaymentList() {
    	this.list = new ArrayList<>();
    }

    public void addPayment(Payment paym) throws Exception {
    	loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getPaymentID())
					counter++;
			}

			if (counter == 0) {
				
				paym.setPaymentID(ID);
				
	if (paym.getGrossSalary() == null) {
		throw new Exception("Payment can't be added");
		//TODO finish this with IDs ^^
	}
	else list.add(paym);
	break loop;
			}
		}
    }
    
	public void addPaymentDB(Payment paym)
	{
		list.add(paym);
	}

    public int getNumberOfPayments() {
        return this.list.size();
    }

    public Payment getPayment(int index) {
        return (Payment)this.list.get(index);
    }
    
	public Payment getPaymentByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPaymentID() == ID) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public void removePaymentByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPaymentID() == ID) {
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

	public int size() {
		return list.size();
	}
}
