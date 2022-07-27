package FireWall;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FireWall {
    public static void main(String[] args) throws IOException {

        List<String> existed = null;
        String existedFilename = "D:\\firewall\\existed.txt";
        existed = read(existedFilename);

        List<String> ioc = null;
        String falseFilename = "D:\\firewall\\ioc.txt";
        ioc = read(falseFilename);

        List<String> first = null;
        String newFileName = "D:\\firewall\\input.txt";
        first = readFile(newFileName);

        writeFile(existed, ioc, first);
    }

    public static List<String> read(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> temp = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(" ");
            temp.addAll(Arrays.asList(parts));
        }
        return temp;
    }

    public static List<String> readFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> temp = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            temp.add(getIp(line));
        }
        return temp;
    }

    public static String getIp(String line) {
        String[] parts = line.split("\"");
        return parts[parts.length - 2];
    }

    public static void writeFile(List<String> existed, List<String> ioc, List<String> first) throws IOException {
        int count = 0;
        String filename = "D:\\firewall\\out.txt";
        FileWriter writer = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (String s : first) {
            if (!existed.contains(s) && !ioc.contains(s)){
                bufferedWriter.write(s + " ");
                count++;
                if (count == 256){
                    bufferedWriter.write("\n" + count + "\n");
                    count = 0;
                }
            }
        }
        bufferedWriter.write("\n" + count + "\n");
        bufferedWriter.close();
    }
}
