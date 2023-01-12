package com.springboot.learn.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CommodityIndexMonitor implements Serializable {
    private int id;
    private long itemId;
    private String title;
    private String mainImage;
    private long visitUv;
    private long visitPv;
    private int haveVisitedPv;
    private int collectUv;
    private int addPurchaseNum;
    private int addPurchaseUv;
    private int paidBuyerNum;
    private int paidItemNum;
    private int havePaidNum;
    private BigDecimal payment = BigDecimal.ZERO;
    private int closedBuyerNum;
    private int closedItemNum;
    private BigDecimal closedPayment = BigDecimal.ZERO;
    private int closedNewBuyer;
    private BigDecimal closedNewPayment = BigDecimal.ZERO;
    private int closedOlderBuyer;
    private BigDecimal closedOlderPayment = BigDecimal.ZERO;
    private int refundNum;
    private BigDecimal refundAmount = BigDecimal.ZERO;
    private Date created;
    private int week;
    private int year;
    private int month;


    // 转化率
    private double AccessCollectionCR;
    private double AccessPlusPurchaseCR;
    private double PaidCR;
    private double AccessClosedCR;
    private BigDecimal perCustomerTransactionCR=BigDecimal.ZERO;
    private BigDecimal refundRate=BigDecimal.ZERO;
    private List<CommodityIndexMonitor> trend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public long getVisitUv() {
        return visitUv;
    }

    public void setVisitUv(long visitUv) {
        this.visitUv = visitUv;
    }

    public long getVisitPv() {
        return visitPv;
    }

    public void setVisitPv(long visitPv) {
        this.visitPv = visitPv;
    }

    public int getHaveVisitedPv() {
        return haveVisitedPv;
    }

    public void setHaveVisitedPv(int haveVisitedPv) {
        this.haveVisitedPv = haveVisitedPv;
    }

    public int getCollectUv() {
        return collectUv;
    }

    public void setCollectUv(int collectUv) {
        this.collectUv = collectUv;
    }

    public int getAddPurchaseNum() {
        return addPurchaseNum;
    }

    public void setAddPurchaseNum(int addPurchaseNum) {
        this.addPurchaseNum = addPurchaseNum;
    }

    public int getAddPurchaseUv() {
        return addPurchaseUv;
    }

    public void setAddPurchaseUv(int addPurchaseUv) {
        this.addPurchaseUv = addPurchaseUv;
    }

    public int getPaidBuyerNum() {
        return paidBuyerNum;
    }

    public void setPaidBuyerNum(int paidBuyerNum) {
        this.paidBuyerNum = paidBuyerNum;
    }

    public int getPaidItemNum() {
        return paidItemNum;
    }

    public void setPaidItemNum(int paidItemNum) {
        this.paidItemNum = paidItemNum;
    }

    public int getHavePaidNum() {
        return havePaidNum;
    }

    public void setHavePaidNum(int havePaidNum) {
        this.havePaidNum = havePaidNum;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public int getClosedBuyerNum() {
        return closedBuyerNum;
    }

    public void setClosedBuyerNum(int closedBuyerNum) {
        this.closedBuyerNum = closedBuyerNum;
    }

    public int getClosedItemNum() {
        return closedItemNum;
    }

    public void setClosedItemNum(int closedItemNum) {
        this.closedItemNum = closedItemNum;
    }

    public BigDecimal getClosedPayment() {
        return closedPayment;
    }

    public void setClosedPayment(BigDecimal closedPayment) {
        this.closedPayment = closedPayment;
    }

    public int getClosedNewBuyer() {
        return closedNewBuyer;
    }

    public void setClosedNewBuyer(int closedNewBuyer) {
        this.closedNewBuyer = closedNewBuyer;
    }

    public BigDecimal getClosedNewPayment() {
        return closedNewPayment;
    }

    public void setClosedNewPayment(BigDecimal closedNewPayment) {
        this.closedNewPayment = closedNewPayment;
    }

    public int getClosedOlderBuyer() {
        return closedOlderBuyer;
    }

    public void setClosedOlderBuyer(int closedOlderBuyer) {
        this.closedOlderBuyer = closedOlderBuyer;
    }

    public BigDecimal getClosedOlderPayment() {
        return closedOlderPayment;
    }

    public void setClosedOlderPayment(BigDecimal closedOlderPayment) {
        this.closedOlderPayment = closedOlderPayment;
    }

    public int getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(int refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getAccessCollectionCR() {
        return AccessCollectionCR;
    }

    public void setAccessCollectionCR(double accessCollectionCR) {
        AccessCollectionCR = accessCollectionCR;
    }

    public double getAccessPlusPurchaseCR() {
        return AccessPlusPurchaseCR;
    }

    public void setAccessPlusPurchaseCR(double accessPlusPurchaseCR) {
        AccessPlusPurchaseCR = accessPlusPurchaseCR;
    }

    public double getPaidCR() {
        return PaidCR;
    }

    public void setPaidCR(double paidCR) {
        PaidCR = paidCR;
    }

    public double getAccessClosedCR() {
        return AccessClosedCR;
    }

    public void setAccessClosedCR(double accessClosedCR) {
        AccessClosedCR = accessClosedCR;
    }

    public BigDecimal getPerCustomerTransactionCR() {
        return perCustomerTransactionCR;
    }

    public void setPerCustomerTransactionCR(BigDecimal perCustomerTransactionCR) {
        this.perCustomerTransactionCR = perCustomerTransactionCR;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
    }

    public List<CommodityIndexMonitor> getTrend() {
        return trend;
    }

    public void setTrend(List<CommodityIndexMonitor> trend) {
        this.trend = trend;
    }

    @Override
    public String toString() {
        return "CommodityIndexMonitor{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", title='" + title + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", visitUv=" + visitUv +
                ", visitPv=" + visitPv +
                ", haveVisitedPv=" + haveVisitedPv +
                ", collectUv=" + collectUv +
                ", addPurchaseNum=" + addPurchaseNum +
                ", addPurchaseUv=" + addPurchaseUv +
                ", paidBuyerNum=" + paidBuyerNum +
                ", paidItemNum=" + paidItemNum +
                ", havePaidNum=" + havePaidNum +
                ", payment=" + payment +
                ", closedBuyerNum=" + closedBuyerNum +
                ", closedItemNum=" + closedItemNum +
                ", closedPayment=" + closedPayment +
                ", closedNewBuyer=" + closedNewBuyer +
                ", closedNewPayment=" + closedNewPayment +
                ", closedOlderBuyer=" + closedOlderBuyer +
                ", closedOlderPayment=" + closedOlderPayment +
                ", refundNum=" + refundNum +
                ", refundAmount=" + refundAmount +
                ", created=" + created +
                ", week=" + week +
                ", year=" + year +
                ", month=" + month +
                ", AccessCollectionCR=" + AccessCollectionCR +
                ", AccessPlusPurchaseCR=" + AccessPlusPurchaseCR +
                ", PaidCR=" + PaidCR +
                ", AccessClosedCR=" + AccessClosedCR +
                ", perCustomerTransactionCR=" + perCustomerTransactionCR +
                ", refundRate=" + refundRate +
                ", trend=" + trend +
                '}';
    }
}
