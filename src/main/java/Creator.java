import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class Creator {

    ArrayList<Boolean> enemies;
    ArrayList<Boolean> obstacles;
    ArrayList<Boolean> grounds;
    ArrayList<Boolean> platformsI;
    ArrayList<Boolean> platformsII;

    ArrayList<Boolean> money;
    ArrayList<Boolean> ammo;

    ArrayList<Integer> moneyQty;
    ArrayList<Integer> ammoQty;

    int levels;


    int distanceMax;
    int distance = 0;
    double distanceTmp;

    Writer writer;

    public Creator(int levels, String savePath) {
        this.levels = levels;


        writer = new Writer();

        for (int level = 0; level < levels; level++){
            createLevel(level);
        }



        writer.write(savePath);
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
            random = new Random();
            distanceTmp = 10 + random.nextInt(10);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsI.add(Boolean.FALSE);
            }

            //length
            random = new Random();
            distanceTmp = 2 + random.nextInt(4);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsI.add(Boolean.TRUE);
            }

        }

        //checking that platform starts at at least 10 m
        for (int d = 0; d<10; d++){
            platformsI.add(d, false);
        }


        //randomization of platform II
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = 50 + random.nextInt(50);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsII.add(Boolean.FALSE);
            }

            //length
            distanceTmp = random.nextInt(2) + 1;
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                platformsII.add(Boolean.TRUE);
            }

        }

        //checking that platform starts at at least 10 m
        for (int d = 0; d<10; d++){
            platformsII.add(d, false);
        }

        //checking that under each start of a platformII there is a platform I

        //todo

        //randomization of grounds
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = 5+random.nextInt(10);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                grounds.add(Boolean.FALSE);
            }

            //length
            distanceTmp = 2+random.nextInt(20);
            distance+=distanceTmp;
            for (int d = 0; d<distanceTmp; d++) {
                grounds.add(Boolean.TRUE);
            }


        }

        //checking that there's ground where there isn't any platform

        distance = 0;

        for (int d = 0; d<distanceMax; d++){
            if (!platformsI.get(d)){
                grounds.add(d, Boolean.TRUE);
            }
        }

        //randomization of enemies

        distance = 0;

        for (int d = 0; d<distanceMax; d++){
            if (random.nextDouble()>0.95){
                enemies.add(true);
            }
            else
                enemies.add(false);

        }

        //randomization of obstacles
        for (int d = 0; d<distanceMax; d++){
            if (random.nextDouble()>0.95){
                obstacles.add(true);
            }
            else
                obstacles.add(false);

        }


        //randomization of money

        for (int d = 0; d<distanceMax; d++){
            if (random.nextDouble()>0.97){
                money.add(true);
                moneyQty.add(random.nextInt(2)+1);
            }
            else
                money.add(false);

        }

        //randomization of ammo

        for (int d = 0; d<distanceMax; d++){
            if (random.nextDouble()>0.97){
                ammo.add(true);
                ammoQty.add(random.nextInt(5)+1);
            }
            else
                ammo.add(false);

        }


        System.out.println(level);
        //System.out.println(enemies);
        System.out.println(grounds);
        System.out.println(platformsI);
        //System.out.println(platformsII);

        parsing(level, distanceMax);

    }

    void parsing(int level, int levelLength) {

        ArrayList<Double> listEnemies = new ArrayList<>();
        ArrayList<Double> listObstacles = new ArrayList<>();
        ArrayList<Double> listGrounds = new ArrayList<>();
        ArrayList<Double> listPlatformsI = new ArrayList<>();
        ArrayList<Double> listPlatformsII = new ArrayList<>();

        ArrayList<Double> listGroundsLength = new ArrayList<>();
        ArrayList<Double> listPlatformsILength = new ArrayList<>();
        ArrayList<Double> listPlatformsIILength = new ArrayList<>();

        ArrayList<Double> listMoney = new ArrayList<>();
        ArrayList<Double> listAmmo = new ArrayList<>();

        ArrayList<Double> listMoneyNum = new ArrayList<>();
        ArrayList<Double> listAmmoNum = new ArrayList<>();


        parseArray(enemies, listEnemies);
        parseArray(obstacles, listObstacles);
        parseArray(money, listMoney);
        parseArray(ammo, listAmmo);

        parseArray(grounds, listGrounds, listGroundsLength);
        parseArray(platformsI, listPlatformsI, listPlatformsILength);
        parseArray(platformsII, listPlatformsII, listPlatformsIILength);


        writer.newLevel(String.valueOf(level), listObstacles, listEnemies, listGrounds, listPlatformsI, listPlatformsII, listGroundsLength, listPlatformsILength, listPlatformsIILength, listMoney, listAmmo, listMoneyNum, listAmmoNum, levelLength);

    }

    private void parseArray(ArrayList<Boolean> booleans, ArrayList<Double> positions, ArrayList<Double> lengths) {
        distance = 0;
        double counter = 0.0;
        double position = (double) distance;
        boolean isEmpty = false;

        while (distance<distanceMax){

            if(!isEmpty){
                if (booleans.get(distance)){
                    counter++;
                }else{
                    isEmpty=true;

                    if (counter>0){
                        positions.add(littleRandom(position));

                         lengths.add(littleRandom(counter));
                    }

                    counter=0;

                }
            }else{
                if (booleans.get(distance)){
                    isEmpty = false;
                    counter++;
                    position = (double) distance;
                }
            }

            distance++;

        }

    }

    private void parseArray(ArrayList<Boolean> booleans, ArrayList<Double> positions) {
        distance = 0;

        while (distance<distanceMax){

            if(booleans.get(distance)){
                positions.add(littleRandom(distance));
            }

            distance++;

        }

    }

    private Double littleRandom(double position) {
        Random random = new Random();
        //return (double) Math.round((position - 0.5 + random.nextDouble())*100) / 100;
        return  position;
    }
}
