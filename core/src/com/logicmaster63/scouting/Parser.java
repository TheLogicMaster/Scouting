package com.logicmaster63.scouting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.logicmaster63.scouting.LayoutObject;
import com.logicmaster63.scouting.LayoutObject.inputMethod;

public class Parser {

    public static void write(String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
        try {
            writer.write("#");
            writer.write(inputMethod.CHECK_BOX.name());
            writer.write("Can Climb");
            writer.write("#");
            writer.write(inputMethod.TEXT_FIELD.name());
            writer.write("Balls Scored");
            writer.flush();
        } catch(IOException e) {
            System.err.println(e);
        } finally {
            writer.close();
        }
    }

    public static ArrayList<LayoutObject> read(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader((new File(path))));
            ArrayList<LayoutObject> layoutObjects = new ArrayList<LayoutObject>();
            String line;
            while((line = reader.readLine()) != null){
                if (line.equals("#")) {
                    layoutObjects.add(new LayoutObject(inputMethod.valueOf(reader.readLine()), reader.readLine()));
                }
            }
            reader.close();
            return layoutObjects;
        } catch(IOException e) {
            System.err.println(e);
        }
        return null;
    }
}
