package com.hoyatod.entity.baidu;

import java.util.List;

public class Header {

   private String desc;
   private List<String> failures;
   private int oprs;
   private int succ;
   private int oprtime;
   private int quota;
   private int rquota;
   private int status;
   
   public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

   public void setFailures(List<String> failures) {
        this.failures = failures;
    }
    public List<String> getFailures() {
        return failures;
    }

   public void setOprs(int oprs) {
        this.oprs = oprs;
    }
    public int getOprs() {
        return oprs;
    }

   public void setSucc(int succ) {
        this.succ = succ;
    }
    public int getSucc() {
        return succ;
    }

   public void setOprtime(int oprtime) {
        this.oprtime = oprtime;
    }
    public int getOprtime() {
        return oprtime;
    }

   public void setQuota(int quota) {
        this.quota = quota;
    }
    public int getQuota() {
        return quota;
    }

   public void setRquota(int rquota) {
        this.rquota = rquota;
    }
    public int getRquota() {
        return rquota;
    }

   public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

}
