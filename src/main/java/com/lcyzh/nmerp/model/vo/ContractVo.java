package com.lcyzh.nmerp.model.vo;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/19  5:07 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/19    create
 */
public class ContractVo {

    private String contCode;
    private String contManager;
    private String contSignDate;
    private String contAttach;
    private Character contStatus;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContManager() {
        return contManager;
    }

    public void setContManager(String contManager) {
        this.contManager = contManager;
    }

    public String getContSignDate() {
        return contSignDate;
    }

    public void setContSignDate(String contSignDate) {
        this.contSignDate = contSignDate;
    }

    public String getContAttach() {
        return contAttach;
    }

    public void setContAttach(String contAttach) {
        this.contAttach = contAttach;
    }

    public Character getContStatus() {
        return contStatus;
    }

    public void setContStatus(Character contStatus) {
        this.contStatus = contStatus;
    }
}