import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};

        String fileName = "data.csv";

        List<Employee> list = parseCSV(columnMapping, fileName);
        String json = listToJson(list);
        writeString(json, "new_data.json");

        String fileNameXml = "data.xml";

        List<Employee> listFromXml = parseXML(fileNameXml);
        String jsonFromXml = listToJson(listFromXml);
        writeString(jsonFromXml, "data2.json");

        String json2 = readString("new_data.json");

        List<Employee> list2 = jsonToList(json2);

        for (Employee employee : list2) {
            System.out.println(employee.toString());
        }
    }

    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {

        List<Employee> list = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {

            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();

            list = csv.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String listToJson(List<Employee> list) {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();

        String json = gson.toJson(list, listType);

        return json;

    }

    public static void writeString(String json, String fileName) {

        try (FileWriter file = new
                FileWriter(fileName)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static List<Employee> parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        Node root = doc.getDocumentElement();

        NodeList nodeList = root.getChildNodes();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node_ = nodeList.item(i);

            if (Node.ELEMENT_NODE == node_.getNodeType()) {

                Element element = (Element) node_;

                long id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
                String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                String country = element.getElementsByTagName("country").item(0).getTextContent();
                int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());

                Employee employee = new Employee(id, firstName, lastName, country, age);

                employees.add(employee);
            }
        }

        return employees;
    }

    public static String readString(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = br.readLine()) != null) {
                stringBuilder.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return stringBuilder.toString();

    }

    public static List<Employee> jsonToList(String json) {

        List<Employee> employees = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            JSONArray jsonArray = (JSONArray) obj;

            for (Object jsonText : jsonArray) {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Employee employee = gson.fromJson(jsonText.toString(), Employee.class);

                employees.add(employee);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return employees;


    }
}
