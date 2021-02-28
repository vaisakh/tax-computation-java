package com.TaxEngine;

public interface ComputationCommand {
    boolean Execute(COMPUTATION_CONTEXT ctx);
}
