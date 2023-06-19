package saturdayConsultation.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/*
java script object notation
основан на джава скрипте

JSON (JavaScript Object Notation) - это текстовый формат обмена данными, основанный на синтаксисе объектов JavaScript. Файлы JSON (JSON-файлы)
используются для хранения и передачи структурированных данных между различными программами.

JSON-файл представляет собой текстовый файл, состоящий из пар "ключ-значение". Ключи представляют собой строки, заключенные в двойные кавычки,
за которыми следует символ двоеточия. Значения могут быть строками, числами, логическими значениями (true или false), массивами, объектами или null.

Для парсинга файлов используются разные подходы:
дом поход, сакс подход, стакс подход


 */
public class JSONEx {
    public static void main(String[] args) {

        try {
            InputStream inputStream = JSONEx.class.getResourceAsStream("src/main/resources/ex.json");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("1234");

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            JSONObject json = new JSONObject(stringBuilder.toString());
            Map<String, Object> map = json.toMap();

            for (String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }

        } catch (Exception e) {
            System.out.println("Error reading or parsing JSON: " + e.getMessage());
        }
    }
}
