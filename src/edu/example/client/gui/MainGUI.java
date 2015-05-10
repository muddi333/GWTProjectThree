package edu.example.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.example.client.service.ExampleServiceClientImpl;

public class MainGUI extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private TextBox txt1;
	private Label resultLb1;
	private TextBox txtNum1;
	private TextBox txtNum2;
	private Label sumLbl;

	private ExampleServiceClientImpl serviceImpl;

	public MainGUI(ExampleServiceClientImpl serviceImpl){
		initWidget(this.vPanel);

		this.serviceImpl = serviceImpl;

		this.txt1 = new TextBox();
		this.vPanel.add(txt1);

		Button btn1 = new Button("Say Hello");
		btn1.addClickHandler(new Btn1ClickHandler());
		this.vPanel.add(btn1);

		this.resultLb1 = new Label("Result will be here");
		this.vPanel.add(resultLb1);


		this.txtNum1 = new TextBox();
		this.vPanel.add(txtNum1);

		this.txtNum2 = new TextBox();
		this.vPanel.add(txtNum2);

		Button btn2 = new Button("Add two numbers");
		btn2.addClickHandler(new Btn2ClickHandler());
		this.vPanel.add(btn2);

		this.sumLbl = new Label("Sum will be here");
		this.vPanel.add(sumLbl);
	}


	public void updateLabel(String greeting){
		this.resultLb1.setText(greeting);
	}
	
	private class Btn1ClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			String name = txt1.getText();
			serviceImpl.sayHello(name);		
		}

	}
	public void updateSumLabel(int sum){
		this.sumLbl.setText(""+ sum);
	}
	private class Btn2ClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			int num1 = Integer.valueOf(txtNum1.getText());
			int num2 = Integer.valueOf(txtNum2.getText());

			serviceImpl.addTwoNumbers(num1, num2);
		}
	}
}
