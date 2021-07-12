public class Core {

    public static int difficulty;

    public static void main(String[] args) {


        LevelCreatorWriter levelCreatorWriter = new LevelCreatorWriter();

        for (int level = 0; level < Integer.parseInt(args[0]); level++){
            LevelCreator creator = new LevelCreator(level);
            levelCreatorWriter.newLevel(String.valueOf(level),
                    creator.getListEnemies(),
                    creator.getListObstacles(),
                    creator.getListGrounds(),
                    creator.getListPlatformsI(),
                    creator.getListPlatformsII(),

                    creator.getListGroundsLength(),
                    creator.getListPlatformsILength(),
                    creator.getListPlatformsIILength(),

                    creator.getListMoney(),
                    creator.getListAmmo(),

                    creator.getListMoneyNum(),
                    creator.getListAmmoNum(),

                    creator.getDistanceMax());

        }

        levelCreatorWriter.write(args[1]);




    }
}
