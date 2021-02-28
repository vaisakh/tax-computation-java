package com.TaxEngine;

public class CommandDispatcher {
    public static boolean dispatch(String archetype, COMPUTATION_CONTEXT ctx) {
        if(archetype == "SeniorCitizen") {
            SeniorCitizenCommand cmd = new SeniorCitizenCommand();
            return cmd.Execute(ctx);
        } else if(archetype == "OrdinaryCitizen") {
            OrdinaryCitizenCommand cmd = new OrdinaryCitizenCommand();
            return cmd.Execute(ctx);
        } else {
            return false;
        }
    }
}
