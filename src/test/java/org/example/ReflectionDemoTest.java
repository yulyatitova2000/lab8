package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
class Animal{};
public class ReflectionDemoTest {

    @Test
    void getMethodName() {
        Human human = new Human("Иван", "Иванов", "Иванович", 34);
        List<String> result = ReflectionDemo.getMethodName(human);
        List<String> test = new ArrayList<>();
        test.add("getFirstName");
        test.add("setFirstName");
        test.add("getLastName");
        test.add("setLastName");
        test.add("getSurName");
        test.add("setSurName");
        test.add("getAge");
        test.add("setAge");
        test.add("equals");
        test.add("toString");
        test.add("hashCode");
        test.add("copy");
        for(String str : test){
            assertTrue(result.contains(str));
        }
    }

    @Test
    void getListSuperClass() {
        Student student = new Student("Иван", "Петров", "Иванович", 56, "математический");
        List<String> stringList = ReflectionDemo.getListSuperClass(student);
        List<String> testList = new ArrayList<>();
        testList.add("org.example.Human");
        testList.add("java.lang.Object");

        assertTrue(stringList.containsAll(testList));
    }

    @Test
    void getCountHuman() {
            List<Object> testList = new ArrayList<>();

            testList.add(new Human("Иван", "Иванов", "Иванович", 34));
            testList.add(new Animal());
            testList.add(new Human("Иван", "Иванов", "Иванович", 34));

            int count = ReflectionDemo.getCountHuman(testList);

            assertEquals(2, count);
    }
}


