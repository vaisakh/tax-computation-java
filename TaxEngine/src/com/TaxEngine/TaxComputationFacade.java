package com.TaxEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TaxComputationFacade {
    private static String computeArchetype(TaxableEntity taxableEntity)
    {
        if ((taxableEntity.sex == 'F') && (taxableEntity.age > 59))
        {
            return "SeniorCitizenFemale";
        }
        else if (taxableEntity.age<18) {
            return "JuevenileCitizen";
        }

        return (taxableEntity.age > 60) ? "SeniorCitizen" : "OrdinaryCitizen";
    }

    public static boolean compute(TaxableEntity taxableEntity) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String archetype = computeArchetype(taxableEntity);
        COMPUTATION_CONTEXT ctx = new COMPUTATION_CONTEXT();
        TaxDTO dto = new TaxDTO();
        dto.id = taxableEntity.id;
        dto.taxParams = taxableEntity.taxParams;
        ctx.put("tax_cargo", dto);

        return CommandDispatcher.dispatch(archetype, ctx);
    }
}
