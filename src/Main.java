import com.algorithms.eclat.AlgoEclat;
import com.algorithms.eclat.TransactionDatabase;
import com.algorithms.fpgrowth.AlgoFPGrowth_Strings;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Justin
 * Date: 12/1/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AlgoFPGrowth_Strings runAlgo = new AlgoFPGrowth_Strings();
        runAlgo.runAlgorithm(".\\data\\testdata2.txt", "output_fpgrowth.txt", .2);

        TransactionDatabase database = new TransactionDatabase();
        try {
            database.loadFile(".\\data\\testdata1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlgoEclat algo = new AlgoEclat();
        algo.runAlgorithm("output_eclat.txt", database, .2);
        algo.printStats();
    }
}
