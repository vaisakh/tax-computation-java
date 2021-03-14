package com.TaxEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CommandDispatcher {
    private static ObjectFactory obj = new ObjectFactory("plugins.xml");

    public static boolean dispatch(String archetype, COMPUTATION_CONTEXT ctx) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        try {
            ComputationCommand cmd = obj.get(archetype, "singleton");
            if(cmd == null)
                return false;

            if(cmd.PreExecute(ctx)) {
                boolean result = cmd.Execute(ctx);
                cmd.PostExecute(ctx);
                return result;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }
}