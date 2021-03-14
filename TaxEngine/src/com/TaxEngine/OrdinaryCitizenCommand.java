package com.TaxEngine;

public class OrdinaryCitizenCommand implements ComputationCommand {
    @Override
    public boolean PreExecute(COMPUTATION_CONTEXT ctx) {
        return true;
    }

    @Override
    public boolean Execute(COMPUTATION_CONTEXT ctx) {
        System.out.println("ORDINARY CITIZEN COMMAND EXECUATION");
        TaxDTO taxDTO = (TaxDTO) ctx.get("tax_cargo");
        //---- Instead of computation, we are assigning
        // ---- constant tax for each archetypes
        taxDTO.taxParams.taxLiability = 1500;
        taxDTO.taxParams.computed = true;
        return true;
    }

    @Override
    public boolean PostExecute(COMPUTATION_CONTEXT ctx) {
        return true;
    }
}
