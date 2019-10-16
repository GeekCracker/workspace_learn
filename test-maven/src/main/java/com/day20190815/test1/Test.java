package com.day20190815.test1;

import java.io.*;
import java.math.BigDecimal;
import java.util.Date;

public class Test {
    private static final String SAVE_INFO_FILE = "F://火币/火币投资.txt";

    public static void main(String[] args) {
        BigDecimal sum = sumInvestMoney();
        System.out.println();
        System.out.println("              合计："+sum+"元");
    }

    /**
     * 投资金额总和
     * @return
     */
    public static BigDecimal sumInvestMoney(){
        BigDecimal result = BigDecimal.ZERO;
        File file = new File(SAVE_INFO_FILE);
        if(!file.exists() || !file.isFile()){
            return result;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

            String line = null;
            int jump = 0;
            while((line = br.readLine())!=null){
                if(jump==0){
                    jump ++;
                    System.out.println(line);
                    continue;
                }
                String [] arr = line.split(" ");
                String str = arr[2];
                str = str.replaceAll("元","");
                result = result.add(new BigDecimal(str));
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
