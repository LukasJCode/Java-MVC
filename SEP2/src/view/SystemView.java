package view;

import Controller.SystemController;

public interface SystemView {
	public void start(SystemController controller);
	public void show(String value);
	public String get(String what);
	public int menu();
}
