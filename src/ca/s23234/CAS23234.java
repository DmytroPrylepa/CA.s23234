/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.s23234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author upgra
 */
public class CAS23234 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
            // Создаем объект BufferedReader для чтения из файла "students.txt"
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            // Создаем объект BufferedWriter для записи в файл "status.txt"
            BufferedWriter writer = new BufferedWriter(new FileWriter("status.txt"));
            String line;
            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {
                // Разделяем строку на имя и фамилию
                String[] nameParts = line.split(" ");
                String firstName = nameParts[0];
                String secondName = nameParts[1];
                // Читаем количество классов и номер студента
                int classes = Integer.parseInt(reader.readLine());
                String studentNumber = reader.readLine();

                // Проверяем валидность данных
                if (!firstName.matches("[a-zA-Z]+") || !secondName.matches("[a-zA-Z0-9]+") || classes < 1 || classes > 8 || !studentNumber.matches("\\d{2}[a-zA-Z]+\\d+")) {
                    // Выводим сообщение об ошибке, если данные невалидны
                    System.out.println("Invalid data for student " + firstName + " " + secondName);
                    continue;
                }

                // Определяем нагрузку студента в зависимости от количества классов
                String workload;
                if (classes == 1) {
                    workload = "very light";
                } else if (classes == 2) {
                    workload = "light";
                } else if (classes >= 3 && classes <= 5) {
                    workload = "part time";
                } else {
                    workload = "full time";
                }

                // Записываем данные в файл "status.txt"
                writer.write(studentNumber + " - " + secondName + "\n" + workload + "\n\n");
            }
            // Закрываем потоки чтения и записи
            reader.close();
            writer.close();
        } catch (IOException e) {
            // Обрабатываем исключение ввода-вывода
            e.printStackTrace();
        }
    }
}
