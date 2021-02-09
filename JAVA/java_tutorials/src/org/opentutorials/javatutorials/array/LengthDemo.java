package org.opentutorials.javatutorials.array;

public class LengthDemo {

	public static void main(String[] args) {
		// String[] classGroup = {"최진혁","최유빈","한이람","이고"};
		String[] classGroup = new String[4];
		classGroup[0] = "최진혁";
		System.out.println(classGroup.length);
		classGroup[1] = "최유빈";
		System.out.println(classGroup.length);
		classGroup[2] = "한이람";
		System.out.println(classGroup.length);
		classGroup[3] = "이고";
		System.out.println(classGroup.length);
	}

}
