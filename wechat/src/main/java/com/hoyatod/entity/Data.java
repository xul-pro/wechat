package com.hoyatod.entity;

public class Data {

	private String agencycode;
	private String agencyname;
	private String agencystr;

	public String getAgencycode() {
		return agencycode;
	}

	public void setAgencycode(String agencycode) {
		this.agencycode = agencycode;
	}

	public String getAgencyname() {
		return agencyname;
	}

	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}

	public String getAgencystr() {
		return agencystr;
	}

	public void setAgencystr(String agencystr) {
		this.agencystr = agencystr;
	}

	@Override
	public String toString() {
		return "Data [agencycode=" + agencycode + ", agencyname=" + agencyname + ", agencystr=" + agencystr + "]";
	}

}
