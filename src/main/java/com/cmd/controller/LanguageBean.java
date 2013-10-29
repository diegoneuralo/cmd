package com.cmd.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LanguageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String language = "";
	private String country = "";
	private Locale locale = new Locale("en", "US");

	public Locale changeLanguage() {
		if (!"".equals(country)) {
			return this.changeLocale(new Locale(language, country));
		} else {
			return this.changeLocale(new Locale(language));
		}
	}

	public Locale changeLocale(Locale locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		this.locale = locale;
		return this.locale;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	

}
