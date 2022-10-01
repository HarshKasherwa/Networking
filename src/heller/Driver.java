package heller;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Driver {

    public static int user_server_port;
    public static int miner_server_port;

    public static void main(String[] args) {

        user_server_port = 6000;
        miner_server_port = 5000;

        int miners = 2;
        ArrayList<Miner> minerArr = new ArrayList<>();
        for (int i = 0; i < miners; i++) {
            Miner obj = new Miner();
            minerArr.add(obj);
            obj.connect(miner_server_port, String.valueOf(i));
        }
    }
}
