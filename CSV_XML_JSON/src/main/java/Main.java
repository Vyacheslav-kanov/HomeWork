import java.util.*;

public class Main {

    private static JSONoperator jsonOperator = new JSONoperator();
    private static XMLoperator xmlOperator = new XMLoperator();

    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = jsonOperator.parseCSV(columnMapping, fileName);
        String json = jsonOperator.listToJson(list);
        jsonOperator.writeString(json, "data.json");

        list = xmlOperator.parseXML();
        json = jsonOperator.listToJson(list);
        jsonOperator.writeString(json, "data2.json");
    }
}
