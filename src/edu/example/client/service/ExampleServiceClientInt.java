package edu.example.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExampleServiceClientInt {
	void sayHello(String name);
	void addTwoNumbers(int num1, int num2);
	void sayGoodnight (String name);
}
