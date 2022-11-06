import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            String pathReadFile = "";
            List<String> list = new ArrayList<>();
            boolean b;
            do {
                b = false;
                System.out.println("ведите путь к файлу имя файла: ");
                pathReadFile = scanner.nextLine();
                if (!pathReadFile.equals("0")) {
                    List<String> list1 = Files.readAllLines(Path.of(pathReadFile));
                    list.addAll(list1);
                    b = true;
                }
            } while (b);
            System.out.println("Укажите путь к созданному файлу для записи файл-отчета:");
            String pathWriteFile = scanner.nextLine();


//        Path path1 = Paths.get("C:\\Users\\bboyClay\\TMS School\\Les13\\src\\file1.txt");
//        Path path2 = Paths.get("C:\\Users\\bboyClay\\TMS School\\Les13\\src\\file2.txt");
//        Path path3 = Paths.get("C:\\Users\\bboyClay\\TMS School\\Les13\\src\\file3.txt");

//
//        String[] list1 = Files.readString(path1).split("\r\n");
//        String[] list2 = Files.readString(path2).split("\r\n");
//        String[] list3 = Files.readString(path3).split("\r\n");
//
//        List<String> list = new ArrayList<>();
//        for (String elem : list1) {
//            list.add(elem);
//        }
//        for (String elem : list2) {
//            list.add(elem);
//        }
//        list.addAll(Arrays.asList(list3));

            Set<String> set = new HashSet<>(list);
            String valid = "(Отлично!)";
            String neValidLength = "(Длинна строки не 15)";
            String neValidName = "(Имя не соответствует)";
            Map<String, String> map = new HashMap<>();


            for (String elem : set) {
                if ((elem.length() == 15) && ((elem.startsWith("docnum")) || (elem.startsWith("contract")))) {
                    map.put(elem, valid);
                } else {
                    map.put(elem, (neValidLength + " " + neValidName));
                    if ((elem.length() == 15) && (!(elem.startsWith("docnum")) || (elem.startsWith("contract")))) {
                        map.put(elem, neValidName);
                    } else if (!(elem.length() == 15) && ((elem.startsWith("docnum")) || (elem.startsWith("contract")))) {
                        map.put(elem, neValidLength);
                    }
                }
            }
            for (Map.Entry<String, String> elem : map.entrySet()) {
                System.out.println(elem.getKey() + " : " + elem.getValue());
            }

//                pathEnter = Paths.get("C:\\Users\\bboyClay\\TMS School\\Les13\\src\\file4.txt");
            Files.writeString(Paths.get(pathWriteFile), "");
            for (Map.Entry<String, String> elem : map.entrySet()) {
                Files.writeString(Paths.get(pathWriteFile), elem.getKey() + " : " + elem.getValue() + "\n", StandardOpenOption.APPEND);
            }
        }
    }
}
