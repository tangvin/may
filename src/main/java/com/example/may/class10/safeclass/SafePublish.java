package com.example.may.class10.safeclass;

/**
 * 安全的发布
 */
public class SafePublish {
	private int i;

    public SafePublish() {
    	i = 2;
    }
	
	public int getI() {
		return i;
	}

	public static void main(String[] args) {
		SafePublish safePublish = new SafePublish();
		int j = safePublish.getI();
		System.out.println("before j="+j);
		j = 3;
		System.out.println("after j="+j);
		System.out.println("getI = "+safePublish.getI());
	}
}
