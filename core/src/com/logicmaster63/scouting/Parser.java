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

/**
 * Created by dmpri on 10/23/2017.
 */

public class Parser {

    public void write(String path) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
            writer.write("#");
            writer.write(inputMethod.CHECK_BOX.name());
            writer.write("Can Climb");
            writer.write("#");
            writer.write(inputMethod.TEXT_FIELD.name());
            writer.write("Balls Scored");
        } catch(IOException e) {

        }
    }

    public ArrayList<LayoutObject> read(String path) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader((new File(path))));
            ArrayList<LayoutObject> layoutObjects = new ArrayList<LayoutObject>();
            String line;
            while((line = reader.readLine()) != null){
                if (line.equals("#")) {
                    layoutObjects.add(new LayoutObject(inputMethod.valueOf(reader.readLine()), reader.readLine()));
                }
            }
            return layoutObjects;
        } catch(IOException e) {
            return null;
        }
    }

}
