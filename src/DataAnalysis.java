import java.util.HashMap;

public class DataAnalysis {
    int maxHumid = 100;
    int maxTemp = 40;
    int maxSalt = 1000;

    public static class PlantRec {
        double idealTemperature; /* Normalised from 40 deg or lower */
        double humidity; /* normalised from 0 to 100 percent */
        double salinity; /* normalised from 0 to 1000 mg per liter */

        public PlantRec(int t, int h, int s) {
            this.idealTemperature = t;
            this.humidity = h;
            this.salinity = s;
        }
    }

    public HashMap<String, PlantRec> database = new HashMap<String, PlantRec>();

    public DataAnalysis() {
        database.put("Oranges", new DataAnalysis.PlantRec(18, 45,350));
    }

    public PlantRec plantIndex(int temperature, int humidity, int salinity) {
        double leastVal = Integer.MAX_VALUE;
        PlantRec leastPlant = null;
        for (String j : database.keySet()) {
            PlantRec record = database.get(j);
            double currVal = Math.pow(record.humidity / maxHumid, 2)
                    + Math.pow(record.idealTemperature / maxTemp, 2) + Math.pow(record.salinity / maxSalt, 2);
            if (leastVal > currVal) {
                leastVal = currVal;
                leastPlant = record;
            }
        }
        return leastPlant;
    }
}
