import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class Creator {

    ArrayList<Boolean> enemies;

    ArrayList<Boolean> grounds;
    ArrayList<Boolean> platformsI;
    ArrayList<Boolean> platformsII;

    ArrayList<Boolean> money;
    ArrayList<Boolean> ammo;

    ArrayList<Integer> moneyQty;
    ArrayList<Integer> ammoQty;

    int levels;


    double distanceMax;
    double distance = 0;
    double distanceTmp;

    Writer writer;

    public Creator(int levels) {
        this.levels = levels;


        writer = new Writer();

        for (int level = 0; level < levels; level++){
            createLevel(level);
        }




    }

    private void createLevel(int level) {
        enemies = new ArrayList<>();

        grounds = new ArrayList<>();
        platformsI = new ArrayList<>();
        platformsII = new ArrayList<>();

        money = new ArrayList<>();
        ammo = new ArrayList<>();

        moneyQty = new ArrayList<>();
        ammoQty = new ArrayList<>();



        distanceMax = 300+50*level;

        Random random = new Random();


        //randomization of platform I
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsI.add(Boolean.FALSE);
            }

            //length
            distanceTmp = random.nextInt(30);
            for (int d = 0; d<distanceTmp; d++) {
                platformsI.add(Boolean.TRUE);
            }

        }


        //randomization of platform II
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsII.add(Boolean.FALSE);
            }

            //length
            distanceTmp = random.nextInt(30);


            for (int d = 0; d<distanceTmp; d++) {
                platformsII.add(Boolean.TRUE);
            }

        }

        //checking that under each start of a platformII there is a platform I

        //todo

        //randomization of grounds
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                grounds.add(Boolean.FALSE);
            }

            //length
            distanceTmp = random.nextInt(30);


            for (int d = 0; d<distanceTmp; d++) {
                grounds.add(Boolean.TRUE);
            }


        }

        //checking that there's ground where there isn't any platform

        distance = 0;

        for (int d = 0; d<distanceMax; d++){
            if (!platformsI.get(d) && !platformsII.get(d)){
                grounds.add(d, Boolean.TRUE);
            }
        }

        //randomization of enemies

        distance = 0;

        for (int d = 0; d<distanceMax; d++){
            if (!enemies.get(d) && !enemies.get(d)){
                grounds.add(d, Boolean.TRUE);
            }
        }







        System.out.println(level);
        System.out.println(grounds);
        System.out.println(platformsI);
        System.out.println(platformsII);

        parsing(level);

    }

    void parsing(int level) {
    }
}
