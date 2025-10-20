package com.example.planet.entity;
// -- お問い合わせの補助クラス --
public enum InquiryStatus {
	UNANSWERED("未対応"),
	IN_PGRESS("対応中"),
	COMPLETED("対応完了");
	
	private final String label;
	
	InquiryStatus (String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}