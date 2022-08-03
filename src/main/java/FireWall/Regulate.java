package FireWall;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Regulate {

    public static void main(String[] args) throws IOException {
        List<String> existed = null;
        String existedFilename = "D:\\firewall\\existed.txt";
        existed = FireWall.read(existedFilename);

        Collections.sort(existed);

        existed = removeDuplicate(existed);

        write(existed);

    }

    public static void write(List<String> list) throws IOException {
        int count = 0;
        String filename = "D:\\firewall\\out.txt";
        FileWriter writer = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (String s : list) {
            bufferedWriter.write(s + " ");
            count++;
            if (count == 256) {
                bufferedWriter.write("\n" + count + "\n");
                count = 0;
            }
        }
        bufferedWriter.write("\n" + count + "\n");
        bufferedWriter.close();
    }

    public static List<String> removeDuplicate(List<String> list) {
        List<String> listTemp = new ArrayList<>();
        for (String o : list) {
            if (!listTemp.contains(o)) {
                listTemp.add(o);
            }
        }
        return listTemp;
    }
}
