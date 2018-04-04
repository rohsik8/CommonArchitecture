
package com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultQuery implements Serializable
{

    @SerializedName("TRACKING_ID")
    @Expose
    private String tRACKINGID;
    @SerializedName("TRACK_DATE")
    @Expose
    private String tRACKDATE;
    @SerializedName("BILL_NO")
    @Expose
    private String bILLNO;
    @SerializedName("REFERENCE_NO")
    @Expose
    private String rEFERENCENO;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("ACTIVITY")
    @Expose
    private String aCTIVITY;
    @SerializedName("LOCATION")
    @Expose
    private String lOCATION;
    @SerializedName("EMPLOYEE_ID")
    @Expose
    private String eMPLOYEEID;
    @SerializedName("TIMESTAMP")
    @Expose
    private String tIMESTAMP;
    @SerializedName("TAG")
    @Expose
    private String tAG;
    @SerializedName("BRANCH_CODE")
    @Expose
    private String bRANCHCODE;
    @SerializedName("CROSSING_NO")
    @Expose
    private String cROSSINGNO;
    private final static long serialVersionUID = -296216968974675532L;

    public String getTRACKINGID() {
        return tRACKINGID;
    }

    public void setTRACKINGID(String tRACKINGID) {
        this.tRACKINGID = tRACKINGID;
    }

    public String getTRACKDATE() {
        return tRACKDATE;
    }

    public void setTRACKDATE(String tRACKDATE) {
        this.tRACKDATE = tRACKDATE;
    }

    public String getBILLNO() {
        return bILLNO;
    }

    public void setBILLNO(String bILLNO) {
        this.bILLNO = bILLNO;
    }

    public String getREFERENCENO() {
        return rEFERENCENO;
    }

    public void setREFERENCENO(String rEFERENCENO) {
        this.rEFERENCENO = rEFERENCENO;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getACTIVITY() {
        return aCTIVITY;
    }

    public void setACTIVITY(String aCTIVITY) {
        this.aCTIVITY = aCTIVITY;
    }

    public String getLOCATION() {
        return lOCATION;
    }

    public void setLOCATION(String lOCATION) {
        this.lOCATION = lOCATION;
    }

    public String getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(String eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public String getTIMESTAMP() {
        return tIMESTAMP;
    }

    public void setTIMESTAMP(String tIMESTAMP) {
        this.tIMESTAMP = tIMESTAMP;
    }

    public String getTAG() {
        return tAG;
    }

    public void setTAG(String tAG) {
        this.tAG = tAG;
    }

    public String getBRANCHCODE() {
        return bRANCHCODE;
    }

    public void setBRANCHCODE(String bRANCHCODE) {
        this.bRANCHCODE = bRANCHCODE;
    }

    public String getCROSSINGNO() {
        return cROSSINGNO;
    }

    public void setCROSSINGNO(String cROSSINGNO) {
        this.cROSSINGNO = cROSSINGNO;
    }

}
