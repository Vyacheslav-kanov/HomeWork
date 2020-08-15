import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONoperator {
    protected static List parseCSV(String[] column, String filename){
        try(CSVReader reader = new CSVReader(new FileReader(filename));){
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(new String[]{"id", "firstName", "lastName", "country", "age"});
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader).
                    withMappingStrategy(strategy).
                    build();
            List<Employee> list = csv.parse();
            return list;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    protected static String listToJson(List list){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(list, list.getClass());
    }

    protected static void writeString(String textJson, String resultFileNmae){
        try(FileWriter file = new FileWriter(resultFileNmae)){
            file.write(textJson);
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

