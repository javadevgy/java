package com.java.basics.locale;

import java.util.ListResourceBundle;

public class SRBundel_de_CH extends ListResourceBundle {// It is necessary for the class to be public. Also be careful
														// to return resource array without null keys.
	protected Object[][] getContents() {
		Object[][] resources = new Object[1][2];
		resources[0][0] = "Hello";
		resources[0][1] = "Guten Tag";
		return resources;
	}
}