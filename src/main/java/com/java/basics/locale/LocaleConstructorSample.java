package com.java.basics.locale;

import java.util.Locale;

public class LocaleConstructorSample {

	public static void main(String[] args) {
		// String codes for language and country are case insensitive. Internally
		// language is lower cased and country is uppercased.
		Locale localeEnglish = new Locale("en");
		Locale localeUkranian = new Locale("UK");
		// Note that the code above does not generate a locale with country as United
		// Kingdom. It is perceived as a language which is Ukrainian.
		Locale localeGB = new Locale("en", "GB");
		Locale localeNotExisting = new Locale("not existing code");
		LocaleHelper.show(localeEnglish);
		LocaleHelper.show(localeUkranian);
		LocaleHelper.show(localeGB);
		LocaleHelper.show(localeNotExisting);
	}

}
