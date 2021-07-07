import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


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

        levelInfo.put("enemies", new JSONArray().addAll(enemies));

        levelInfo.put("grounds", new JSONArray().addAll(grounds));
        levelInfo.put("platformI", new JSONArray().addAll(platformsI));
        levelInfo.put("platformII", new JSONArray().addAll(platformsII));

        levelInfo.put("groundsLength", new JSONArray().addAll(groundsLength));
        levelInfo.put("platformILength", new JSONArray().addAll(platformsILength));
        levelInfo.put("platformIILength", new JSONArray().addAll(platformsIILength));


        levels.put(String.valueOf(levelNumber), levelInfo);
    }









    public void  write(){
        try (FileWriter file = new FileWriter("game.json")){
            file.write(object.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
        }

        object.put("levels", levels);





    }
}

