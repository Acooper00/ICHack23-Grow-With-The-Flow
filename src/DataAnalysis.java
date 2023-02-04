import java.util.HashMap;

public class DataAnalysis {
    double maxHumid = 77.5;
    int maxTemp = 30;
    int maxSalt = 450;

    public static class PlantRec {
        String plantName;
        double idealTemperature; /* Normalised from 40 deg or lower */
        double humidity; /* normalised from 0 to 100 percent */
        double salinity; /* normalised from 0 to 1000 mg per liter */

        public PlantRec(String p, double t, double h, double s) {
            this.plantName = p;
            this.idealTemperature = t;
            this.humidity = h;
            this.salinity = s;
        }
    }

    public HashMap<String, PlantRec> database = new HashMap<String, PlantRec>();

    public DataAnalysis() {
        database.put("Oranges", new DataAnalysis.PlantRec("Oranges", 18, 45,350));
        database.put("Corn", new DataAnalysis.PlantRec("Corn", 24, 65,250));
        database.put("Potatoes", new DataAnalysis.PlantRec("Potatoes", 12.5, 85,250));
        database.put("Wheat", new DataAnalysis.PlantRec("Wheat", 15, 65,450));
        database.put("Rice", new DataAnalysis.PlantRec("Rice", 30, 75,350));
        database.put("Maize", new DataAnalysis.PlantRec("Maize",12, 60,200));
        database.put("Soybeans", new DataAnalysis.PlantRec("Soybeans",21, 72.5,150));
        database.put("Tomatoes", new DataAnalysis.PlantRec("Tomatoes",22, 77.5,300));
        database.put("Sugarcane", new DataAnalysis.PlantRec("Sugarcane",30, 60,100));
        database.put("Grapes", new DataAnalysis.PlantRec("Grapes",16, 65,200));

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
