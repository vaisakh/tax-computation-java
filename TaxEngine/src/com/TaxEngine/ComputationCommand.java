package com.TaxEngine;

public interface ComputationCommand {
    boolean PreExecute(COMPUTATION_CONTEXT ctx);
    boolean Execute(COMPUTATION_CONTEXT ctx);
    boolean PostExecute(COMPUTATION_CONTEXT ctx);
}
