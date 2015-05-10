package edu.example.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import edu.example.client.gui.MainGUI;

public class ExampleServiceClientImpl implements ExampleServiceClientInt{

	private ExampleServiceAsync service;
	private MainGUI maingui;

	public ExampleServiceClientImpl(String url){
		System.out.println(url);
		this.service = GWT.create(ExampleService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);

		this.maingui = new MainGUI(this);
	}

	@Override
	public void sayHello(String name) {
		this.service.sayHello(name, new DefaultCallback());		
	}

	@Override
	public void addTwoNumbers(int num1, int num2) {
		this.service.addTwoNumbers(num1, num2, new DefaultCallback());
	}
	
	@Override
	public void sayGoodnight(String name) {
		this.service.sayGoodnight(name, new DefaultCallback());
	}

	public MainGUI getMainGUI(){
		return this.maingui;
	}
	
	private class DefaultCallback implements AsyncCallback{
		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");			
		}
		
		@Override
		public void onSuccess(Object result) {
			if (result instanceof String){
				String greeting = (String) result;
				maingui.updateLabel(greeting);
			}
			else if (result instanceof Integer){
				int sum = (Integer) result;
				maingui.updateSumLabel(sum);
			}
		}
	}
}