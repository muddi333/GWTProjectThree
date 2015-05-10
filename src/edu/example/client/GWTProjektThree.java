package edu.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import edu.example.client.service.ExampleServiceClientImpl;

public class GWTProjektThree implements EntryPoint {

	public void onModuleLoad() {
		ExampleServiceClientImpl clientImpl = new ExampleServiceClientImpl(GWT.getModuleBaseURL() + "exampleservice");
		RootPanel.get().add(clientImpl.getMainGUI());
	}
}
