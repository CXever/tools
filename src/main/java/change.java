import java.io.*;
import java.nio.charset.StandardCharsets;

public class change {

    public static void main(String[] args) {
        String local = "D:\\test\\Report\\";
        String in = local + "WEB扫描-正式-HTTP-cloud.easipass.com[2021-11-10 16_32_50]Report.html";
        String out = local + "WEB扫描-正式-cloud.easipass.com.html";
        File fileIn = new File(in);
        File fileOut = new File(out);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn), StandardCharsets.UTF_8));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("plus")) {
                    str = str.replace("plus", "minus");
                }
                if (str.contains(" hide ")) {
                    str = str.replace(" hide ", " ");
                }
                stringBuilder.append(System.lineSeparator()).append(str);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(fileOut))));
            bufferedWriter.write(String.valueOf(stringBuilder));
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("wkhtmltopdf --enable-local-file-access ");
    }

}
