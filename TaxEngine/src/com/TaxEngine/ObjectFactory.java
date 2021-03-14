package com.TaxEngine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private HashMap<String, String> plugins = new HashMap<String, String>();
    private HashMap<String, ComputationCommand> commands = new HashMap<String, ComputationCommand>();

    public ObjectFactory(String xmlFile) {
        plugins = loadData(xmlFile);
        for (Map.Entry<String, String> set : plugins.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

    private HashMap<String, String> loadData(String xmlFile) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        HashMap<String, String> xmlData = new HashMap<String, String>();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            NodeList pluginList = document.getElementsByTagName("plugin");

            for(int i = 0; i < pluginList.getLength(); i++) {
                Node p = pluginList.item(i);
                if(p.getNodeType() == Node.ELEMENT_NODE) {
                    Element plugin = (Element) p;
                    String archetype = ((Element) p).getAttribute("archetype");
                    String command = ((Element) p).getAttribute("command");
                    xmlData.put(archetype, command);
                }
            }
            return xmlData;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlData;
    }

    public ComputationCommand get(String archetype, String mode) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            if (mode != "singleton" && mode != "prototype") return null;

            ComputationCommand cmd = null;
            cmd = commands.get(archetype);
            if(cmd != null) {
                return (mode == "singleton")? cmd: CloneHelpers.deepClone(cmd);
            }

            String className = plugins.get(archetype);
            if(className == null)
                return null;

            Class<?> clazz = Class.forName(className);
            if(clazz == null)
                return null;
            Constructor<?> ctor = clazz.getConstructor();
            ComputationCommand newCmd = (ComputationCommand) ctor.newInstance();
            commands.put(archetype, newCmd);
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return commands.get(archetype);
    }
}
