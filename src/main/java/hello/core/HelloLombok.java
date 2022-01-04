package hello.core;

import lombok.Data;

@Data
public class HelloLombok {
	
	private String name;
	private int age;

	public static void main(String[] args) {
		
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setName("ทาบน");
		helloLombok.setAge(0);
		
		System.out.println(helloLombok.getName());
		System.out.println(helloLombok.getAge());
		System.out.println(helloLombok);
	}
}
