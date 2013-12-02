import com.algorithms.fpgrowth.AlgoFPGrowth_Strings;

import java.io.FileNotFoundException;
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
        runAlgo.runAlgorithm(".\\data\\testdata1.txt","output.txt",.5);
    }
}
