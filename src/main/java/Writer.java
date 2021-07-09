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
                         ArrayList<Double> obstacles,
                         ArrayList<Double> grounds,
                         ArrayList<Double> platformsI,
                         ArrayList<Double> platformsII,

                         ArrayList<Double> groundsLength,
                         ArrayList<Double> platformsILength,
                         ArrayList<Double> platformsIILength,

                         ArrayList<Double> coins,
                         ArrayList<Double> ammo,

                         ArrayList<Integer> coinsNum,
                         ArrayList<Integer> ammoNum,

                         int levelLength
                        ){


        levelInfo = new JSONObject();

        levelInfo.put("enemies",(Object)enemies );
        levelInfo.put("obstacles", (Object)obstacles);

        levelInfo.put("grounds", (Object)grounds);
        levelInfo.put("groundsLength", (Object)groundsLength);

        levelInfo.put("platformI", (Object)platformsI);
        levelInfo.put("platformILength", (Object)platformsILength);


        levelInfo.put("platformII", (Object)platformsII);
        levelInfo.put("platformIILength", (Object)platformsIILength);
        levelInfo.put("levelLength", levelLength);



        levelInfo.put("coins", (Object)coins);
        levelInfo.put("coinsNum", (Object)coinsNum);

        levelInfo.put("ammo", (Object)ammo);
        levelInfo.put("ammoNum", (Object)ammoNum);



        levels.put(String.valueOf(levelNumber), levelInfo);
    }









    public void  write(String savePath){


        object.put("levels", levels);

        /*try (FileWriter file = new FileWriter(savePath)){
            file.write(object.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error during the opening of the json");
        }
*/
        System.out.print(object);



    }
}

