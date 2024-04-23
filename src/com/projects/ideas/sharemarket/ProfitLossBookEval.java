package com.projects.ideas.sharemarket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

public class ProfitLossBookEval {

    public static void main(String[] args) {
        ProfitLossBookEval evalBook = new ProfitLossBookEval();
        String fnoBookDetails = "C:\\Users\\imvra\\Desktop\\FNOProfitLossBook.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fnoBookDetails))) {
            stream.forEach(line -> evalBook.parseAndRefactor(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        double totalProfit = 0;
        double totalCharges = 0;
        for(Map.Entry<String, List<ShareMarketObject>> entry : posList.entrySet()) {
            String contractName = entry.getKey();
            List<ShareMarketObject> ordersList = entry.getValue();
            int moneyInvolved = 0;
            int chargesInvolved = 0;
            String buyDateLotsDetails = "";
            String sellDateLotsDetails = "";
            for(int i=0; i<ordersList.size(); i++) {
                ShareMarketObject o = ordersList.get(i);
                if("B".equalsIgnoreCase(o.side)) {
                    moneyInvolved -= o.mktVal;
                    buyDateLotsDetails += "("+o.getTxnDate()+"-"+o.qty+")-";
                } else if("S".equalsIgnoreCase(o.side)) {
                    moneyInvolved += o.mktVal;
                    sellDateLotsDetails += "("+o.getTxnDate()+"-"+o.qty+")-";
                }
                chargesInvolved += o.charges;
            }
            System.out.println(contractName+","+buyDateLotsDetails+","+sellDateLotsDetails+","+moneyInvolved+","+chargesInvolved);
            totalProfit += moneyInvolved;
            totalCharges += chargesInvolved;
        }
        System.out.println(totalProfit+","+totalCharges);
    }

    private static Map<String, List<ShareMarketObject>> posList = new HashMap<>();
    public void parseAndRefactor(String line) {
        //System.out.println(line);
        try {
            ShareMarketObject obj = new ShareMarketObject(line);
            //System.out.println(obj);
            if(obj != null) {
                List<ShareMarketObject> objList = posList.get(obj.contractName);
                if(objList == null) {
                    objList = new ArrayList<>();
                }
                objList.add(obj);
                posList.put(obj.contractName, objList);
            }
        } catch (ParseException e) {
            //e.printStackTrace();
        }
    }
}
