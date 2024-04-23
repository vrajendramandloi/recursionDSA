package com.projects.ideas.sharemarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareMarketObject {
    Date txnDate;
    String exchange;
    String contractName;
    String side;
    double qty;
    double price;
    double mktVal;
    double charges;

    private String pattern = "dd-MMM-yy";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public ShareMarketObject(String line) throws ParseException {
        String[] arr = line.split(",");

        this.txnDate = simpleDateFormat.parse(arr[0]);
        this.exchange = arr[1];
        this.contractName = arr[2];
        this.side = arr[3];
        this.qty = Double.parseDouble(arr[4]);
        this.price = Double.parseDouble(arr[5]);
        this.mktVal = Double.parseDouble(arr[6]);
        this.charges = Double.parseDouble(arr[7]);
    }

    private SimpleDateFormat getDateFormat = new SimpleDateFormat("dd-MMM-yyyy");


    public String getTxnDate() {
        return getDateFormat.format(txnDate);
    }
}
