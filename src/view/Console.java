package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Console {
	ObservableList<String> consoleList = FXCollections.observableArrayList();
	public Console() {
		
	}

	public void log(String message) {
		consoleList.add(message);
	}
	
	public ObservableList<String> getList(){
		return consoleList;
	}
}
