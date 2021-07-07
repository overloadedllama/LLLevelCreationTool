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
    int distance = 0;
    double distanceTmp;

    Writer writer;

    public Creator(int levels) {
        this.levels = levels;


        writer = new Writer();

        for (int level = 0; level < levels; level++){
            createLevel(level);
        }



        writer.write();
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
            if (random.nextDouble()>0.95){
                enemies.add(true);
            }
            else
                enemies.add(false);

        }







        System.out.println(level);
        System.out.println(enemies);
        System.out.println(grounds);
        System.out.println(platformsI);
        System.out.println(platformsII);

        parsing(level);

    }

    void parsing(int level) {

        ArrayList<Double> listEnemies = new ArrayList<>();

        ArrayList<Double> listGrounds = new ArrayList<>();
        ArrayList<Double> listPlatformsI = new ArrayList<>();
        ArrayList<Double> listPlatformsII = new ArrayList<>();

        ArrayList<Double> listGroundsLength = new ArrayList<>();
        ArrayList<Double> listPlatformsILength = new ArrayList<>();
        ArrayList<Double> listPlatformsIILength = new ArrayList<>();

       /* ArrayList<Double> listMoney = new ArrayList<>();
        ArrayList<Double> listAmmo = new ArrayList<>();

        ArrayList<Double> listMoneyQty = new ArrayList<>();
        ArrayList<Double> listAmmoQty = new ArrayList<>();
*/

        parseArray(enemies, listEnemies);
        parseArray(grounds, listGrounds, listGroundsLength);
        parseArray(platformsI, listPlatformsI, listPlatformsILength);
        parseArray(platformsII, listPlatformsII, listPlatformsIILength);

        writer.newLevel(String.valueOf(level), listEnemies, listGrounds, listPlatformsI, listPlatformsII, listGroundsLength, listPlatformsILength, listPlatformsIILength);

    }

    private void parseArray(ArrayList<Boolean> booleans, ArrayList<Double> positions, ArrayList<Double> lengths) {
        distance = 0;
        double counter = 0.0;
        double position = (double) distance;
        boolean space = false;

        while (distance<distanceMax){

            if(!space){
                if (booleans.get(distance)){
                    counter++;
                }else{
                    space=true;

                    positions.add(littleRandom(position));
                    lengths.add(littleRandom(counter));

                    counter=0;

                }
            }else{
                if (grounds.get(distance)){
                    space = false;
                    counter++;
                    position = (double) distance;
                }
            }

            distance++;

        }

    }

    private void parseArray(ArrayList<Boolean> booleans, ArrayList<Double> positions) {
        distance = 0;
        double position = (double) distance;

        while (distance<distanceMax){

            if(booleans.get(distance)){
                positions.add(littleRandom(position));
            }

            distance++;

        }

    }

    private Double littleRandom(double position) {
        Random random = new Random();
        return position - 0.5 + random.nextDouble();
    }
}
