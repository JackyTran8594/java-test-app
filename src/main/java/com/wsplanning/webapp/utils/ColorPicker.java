package com.wsplanning.webapp.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.springframework.stereotype.Component;

@Component
public class ColorPicker {

    public String jsonFileColorThemes(colorPickerDTO obj) throws IOException {

        String pathFile = "C:/Users/JACKYTRAN/Desktop/WSPlanerSuperDev/webapp/src/main/resources/colorPickerData.json";
        Path file = Paths.get(pathFile);
        Gson gson = new Gson();
        int tempCount = 0;
        boolean ex = file.toFile().exists();
        
        if (ex == false) {

            // convert object to json
            String jObject = gson.toJson(obj);
            FileWriter jsonfile = new FileWriter(pathFile);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(jsonfile);
                bufferedWriter.write(jObject);
                bufferedWriter.close();
            } catch (Exception e) {
                //TODO: handle exception
            }         
            // jsonfile.write(jObject);        
            return jObject;
        } else {           
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString()));
            // using arrays
            // colorPickerDTO[] colorArray = gson.fromJson(bufferedReader.toString(),
            // colorPickerDTO[].class);
          
            // using lists
            // In order for Gson to understand the List structure correctly. You've to
            // figure out its type.
            Type colorPickerListType = new TypeToken<ArrayList<colorPickerDTO>>() {
            }.getType();
            List<colorPickerDTO> colorList = gson.fromJson(bufferedReader.toString(), colorPickerListType);
            String jObject = gson.toJson(colorList);
            colorList.forEach(item -> {
                if (item.username == obj.username && item.siteId == obj.siteId) {
                    item.colorCode = obj.colorCode;
                } else {
                    int i = tempCount + 1;
                    i = tempCount;
                }
            });

            if (tempCount > 0) {
             gson.toJson(obj, new FileWriter(file.toString()));                
            };
            return jObject;
        }

    }
}
