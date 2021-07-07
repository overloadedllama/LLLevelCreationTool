import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Writer {
    static JSONObject object;

    JSONArray main;
    JSONObject levels;
    JSONObject levelInfo;



    public Writer() {
        object =  new JSONObject();
        levels = new JSONObject();
    }

    public void newLevel(String levelNumber,
                         ArrayList<Double> enemies,
                         ArrayList<Double> grounds,
                         ArrayList<Double> platformsI,
                         ArrayList<Double> platformsII,

                         ArrayList<Double> groundsLength,
                         ArrayList<Double> platformsILength,
                         ArrayList<Double> platformsIILength

                         //ArrayList<Double> money,
                         //ArrayList<Double> ammo,

                         //ArrayList<Double> moneyQty,
                         //ArrayList<Double> ammoQty
                        ){


        levelInfo = new JSONObject();

        levelInfo.put("enemies",(Object)enemies );

        levelInfo.put("grounds", (Object)grounds);
        levelInfo.put("groundsLength", (Object)groundsLength);

        levelInfo.put("platformI", (Object)platformsI);
        levelInfo.put("platformILength", (Object)platformsILength);


        levelInfo.put("platformII", (Object)platformsII);
        levelInfo.put("platformIILength", (Object)platformsIILength);


        levels.put(String.valueOf(levelNumber), levelInfo);
    }









    public void  write(){


        object.put("levels", levels);

        try (FileWriter file = new FileWriter("C:\\Users\\Giacomo\\OneDrive\\LeapingLlama\\android\\assets\\game.json")){
            file.write(object.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.print(object);



    }
}

