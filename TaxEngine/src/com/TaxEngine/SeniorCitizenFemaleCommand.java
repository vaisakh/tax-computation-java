package com.TaxEngine;

public class SeniorCitizenFemaleCommand implements ComputationCommand {

    @Override
    public boolean PreExecute(COMPUTATION_CONTEXT ctx) {
        // Do Some Sanity Checks
        // Return false if some problem
        return true;
    }

    @Override
    public boolean Execute(COMPUTATION_CONTEXT ctx) {
        TaxDTO taxDTO = (TaxDTO) ctx.get("tax_cargo");
        double accum = taxDTO.taxParams.basic + taxDTO.taxParams.da + taxDTO.taxParams.allowance + taxDTO.taxParams.hra;
        double net = accum - taxDTO.taxParams.deductions - taxDTO.taxParams.surCharge;
        //---- Flat 10% Tax
        taxDTO.taxParams.taxLiability = net*0.1;
        taxDTO.taxParams.computed = true;
        return true;
    }

    @Override
    public boolean PostExecute(COMPUTATION_CONTEXT ctx) {
        // Do the Check on Invariants
        // Return false if there is a violation
        return true;
    }
}
