package org.opentutorials.javatutorials.interfaces.example2;

class Calculator {
	 int first, second, third;
	 public void setOprands(int first, int second, int third) {
		 this.first = first;
		 this.second = second;
		 this.third = third;
	 }
	 public void sum() {
		 System.out.println(this.first+this.second+this.third);
	 }
	 public void avg() {
		 System.out.println((this.first+this.second+this.third)/3);
	 }
}
