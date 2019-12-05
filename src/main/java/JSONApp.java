import domain.BasicStudent;
import domain.Student;
import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

//                "{'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'exams': [" +
//                        "{'course': 'OOP', 'mark': 3, 'passed': true}," +
//                        "{'course': 'English', 'mark': 5, 'passed': true}," +
//                        "{'course': 'Math', 'mark': 2, 'passed': false}" +
//                        "]}";

    public static JsonObject sessionResult() {
        Json jYear = new JsonNumber(2);

        JsonPair first1 = new JsonPair("course", new JsonString("OOP"));
        JsonPair first2 = new JsonPair("mark", new JsonNumber(3));
        JsonPair first3 = new JsonPair("passed", new JsonBoolean(true));
        Json firstExam = new JsonObject(first1, first2, first3);

        JsonPair first21 = new JsonPair("course", new JsonString("English"));
        JsonPair first22 = new JsonPair("mark", new JsonNumber(5));
        JsonPair first23 = new JsonPair("passed", new JsonBoolean(true));
        Json secondExam = new JsonObject(first21, first22, first23);

        JsonPair first31 = new JsonPair("course", new JsonString("Math"));
        JsonPair first32 = new JsonPair("mark", new JsonNumber(2));
        JsonPair first33 = new JsonPair("passed", new JsonBoolean(false));
        Json thirdExam = new JsonObject(first31, first32, first33);

        Json jExams = new JsonArray(firstExam, secondExam, thirdExam);

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair exams = new JsonPair("exams", jExams);
        JsonPair year = new JsonPair("year", jYear);

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        JsonObject jsonObject = new JsonObject(name, surname, year, exams);
        return jsonObject;
    }


//    {
//        'name': 'Andrii',
//            'surname': 'Rodionov',
//            'year': 2,
//            'exams': [
//        {
//            'course': 'OOP',
//                'mark': 3,
//                'passed': true
//        },
//        {
//            'course': 'English',
//                'mark': 5,
//                'passed': true
//        },
//        {
//            'course': 'Math','mark': 2,
//                'passed': false
//        }
//]
//    }
}
