package com.logicmaster63.scouting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.logicmaster63.scouting.LayoutObject.INPUT_METHOD;

public class Parser {

    public static void write(String path, List<LayoutObject> objects) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
        try {
            for(LayoutObject object: objects) {
                writer.write("#");
                writer.newLine();
                writer.write(object.inputmethod.name());
                writer.newLine();
                writer.write(object.name);
                writer.newLine();
            }
            writer.flush();
        } catch(IOException e) {
            System.err.println(e);
        } finally {
            writer.close();
        }
    }

    public static List<LayoutObject> read(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader((new File(path))));
            ArrayList<LayoutObject> layoutObjects = new ArrayList<LayoutObject>();
            String line;
            while((line = reader.readLine()) != null){
                if (line.equals("#")) {
                    layoutObjects.add(new LayoutObject(INPUT_METHOD.valueOf(reader.readLine()), reader.readLine()));
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
