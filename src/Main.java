
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input amount:");
        int i = scanner.nextInt();
        System.out.print("Input length:");
        int j = scanner.nextInt();
        File file = new File("./output.json");
        if (!file.exists())
            file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write('[');
        while ((--i) > 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", UUID.randomUUID().toString());
            jsonObject.put("description", randomString(j));
            jsonObject.put("button1", "修改");
            jsonObject.put("button2", "删除");
            writer.append(jsonObject.toJSONString());
            if (i != 1) writer.append(',');
        }
        writer.append(']');
        writer.close();
    }

    public static String randomString(int length) {
        char[] charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Character> target = new ArrayList<>();
        while ((--length) > 0) {
            target.add(charset[(int) Math.floor(Math.random() * charset.length)]);
        }
        Character[] c = target.toArray(new Character[target.size()]);
        char[] q = new char[c.length];
        for (int i = 0; i < c.length; ++i) {
            q[i] = c[i].charValue();
        }
        return String.valueOf(q);
    }
}