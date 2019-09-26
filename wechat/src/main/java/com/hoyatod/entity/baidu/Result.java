package com.hoyatod.entity.baidu;

import java.util.List;
import java.util.Date;

public class Result {

   private int total;
   private List<List<List<String>>> items;
   private Date timeSpan;
   private List<List<Integer>> sum;
   private int offset;
   private List<List<Integer>> pageSum;
   private List<String> fields;
   
   public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

   public void setItems(List<List<List<String>>> items) {
        this.items = items;
    }
    public List<List<List<String>>> getItems() {
        return items;
    }

   public void setTimeSpan(Date timeSpan) {
        this.timeSpan = timeSpan;
    }
    public Date getTimeSpan() {
        return timeSpan;
    }

   public void setSum(List<List<Integer>> sum) {
        this.sum = sum;
    }
    public List<List<Integer>> getSum() {
        return sum;
    }

   public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getOffset() {
        return offset;
    }

   public void setPageSum(List<List<Integer>> pageSum) {
        this.pageSum = pageSum;
    }
    public List<List<Integer>> getPageSum() {
        return pageSum;
    }

   public void setFields(List<String> fields) {
        this.fields = fields;
    }
    public List<String> getFields() {
        return fields;
    }

}
