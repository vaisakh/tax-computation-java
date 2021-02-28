package com.TaxEngine;

public class TaxParamVO {
    public double basic;
    public double da;
    public double hra;
    public double allowance;
    public double deductions;
    public double cess;
    public double taxLiability;
    public boolean computed;

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getCess() {
        return cess;
    }

    public void setCess(double cess) {
        this.cess = cess;
    }

    public double getTaxLiability() {
        return taxLiability;
    }

    public void setTaxLiability(double taxLiability) {
        this.taxLiability = taxLiability;
    }

    public boolean getComputed() {
        return computed;
    }

    public void setComputed(boolean computed) {
        this.computed = computed;
    }
}
