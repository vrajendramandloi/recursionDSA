package com.interview.hsbc.brokerageSystem;

import java.math.BigDecimal;

public class ReqTrade {
	private String uid; // user Placing the order
	private String tradeId; // Optional 
	private String productName; // product Details 
	private int qty; // quantity to buy
	private BigDecimal price; // price of trade
	private String side; // buy or sell for the order
	
	// for New Trade only
	public ReqTrade(String uid, String productName, int qty, BigDecimal price, String side) {
		super();
		this.uid = uid;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.side = side;
	}
	
	// for Existing booking
	public ReqTrade(String tradeId, String uid, String productName, int qty, BigDecimal price, String side) {
		super();
		this.uid = uid;
		this.tradeId = tradeId;
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.side = side;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
}
