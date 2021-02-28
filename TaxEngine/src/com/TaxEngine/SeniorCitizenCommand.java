package com.TaxEngine;

public class SeniorCitizenCommand implements ComputationCommand {
    @Override
    public boolean Execute(COMPUTATION_CONTEXT ctx) {
        System.out.println("SENIOR CITIZEN COMMAND EXECUATION");
        TaxDTO taxDTO = (TaxDTO) ctx.get("tax_cargo");
        //---- Instead of computation, we are assigning
        // ---- constant tax for each archetypes
        taxDTO.taxParams.taxLiability = 1000;
        taxDTO.taxParams.computed = true;
        return true;
    }
}

