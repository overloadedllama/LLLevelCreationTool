import java.util.ArrayList;
import java.util.Random;

public class Creator {

    ArrayList<Double> enemies = new ArrayList<>();

    ArrayList<Double> grounds = new ArrayList<>();
    ArrayList<Double> platformsI = new ArrayList<>();
    ArrayList<Double> platformsII = new ArrayList<>();

    ArrayList<Double> groundsLength = new ArrayList<>();
    ArrayList<Double> platformsILength = new ArrayList<>();
    ArrayList<Double> platformsIILength = new ArrayList<>();

    ArrayList<Double> money = new ArrayList<>();
    ArrayList<Double> ammo = new ArrayList<>();

    ArrayList<Double> moneyQty = new ArrayList<>();
    ArrayList<Double> ammoQty = new ArrayList<>();

    int levels;


    double distanceMax;
    double distance = 0;
    double distanceTmp;

    public Creator(int levels) {
        this.levels = levels;

        for (int level = 0; level < levels; level++){
            createLevel(level);
        }
    }

    private void createLevel(int level) {
        distanceMax = 200+50*level;

        Random random = new Random();


        //platform I
        distance = 0;
        while (distance<distanceMax){
            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            platformsI.add(distance);

            //length
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            platformsILength.add(distanceTmp);

        }


        //platform II
        distance = 0;
        while (distance<distanceMax){


            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            platformsII.add(distance);

            //length
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            platformsIILength.add(distanceTmp);

        }

        //grounds
        distance = 0;
        while (distance<distanceMax){


            //space
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            grounds.add(distance);

            //length
            distanceTmp = random.nextInt(30);
            distance+=distanceTmp;
            groundsLength.add(distanceTmp);

        }





    }
}
