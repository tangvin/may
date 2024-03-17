package com.example.may.class5.readwirtelock;

/**
 * @description:商品的实体类
 * @author: Bruce_T
 * @date: 2022/05/25   14:34
 * @version: 1.0
 * @modified:
 */
public class GoodsInfo {

    private final String name;
    private double totalMoney;//总销售额
    private int storeNumber;//库存数

    public GoodsInfo(String name, int totalMoney, int storeNumber) {
        this.name = name;
        this.totalMoney = totalMoney;
        this.storeNumber = storeNumber;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void changeNumber(int sellNumber){
        this.totalMoney += sellNumber*25;
        this.storeNumber -= sellNumber;
    }
}
