package Seminar4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class TaskSeminar4 {
    class User{
        private String fullName;
        private int age;
        private String gender;
    
        public User(String fullName, int age, String gender){
            this.fullName = fullName;
            this.age = age;
            this.gender = gender;
        }
    

        public String getFullName(){
           return fullName;
        }

        public int getAge(){
           return age;
        }

        public String getGender(){
           return gender;
        }

        public String toString(){
           String[] names = fullName.split(" ");
           StringBuilder initials  = new StringBuilder();
           for(String name : names){
                initials.append(name.charAt(0)).append(" "); 
           }
           return names[names.length-1] + " " + initials.toString() + " " + age + " " + gender;
        }
    
    }
    
    class AgeComparator implements Comparator<User>{
          public int compare(User user1, User user2){
                return Integer.compare(user1.getAge(), user2.getAge());
          }
    }





    
    
         public static void main(String[] args){
            List<User> users = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);

            boolean exit = false;

            while (!exit) {
                System.out.println("Выберите действие: ");
                System.out.println("1. Ввод данных пользователя.");
                System.out.println("2. Сортировать по возрасту.");
                System.out.println("3. Сортировать по возрасту и полу.");
                System.out.println("4. Выход.");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Введите ФИО пользователя: ");
                        String fullName = scanner.nextLine();

                        System.out.println("Введите возраст пользователя: ");
                        int age = scanner.nextInt();

                        System.out.println("Введите пол пользователя: ");
                        String gender = scanner.nextLine();

                        users.add(new User(fullName, age, gender));
                        break;
                    case 2:
                        Collections.sort(users, new AgeComparator());
                        for(User user: users){
                        System.out.println(user);
                        }
                        break;
                    case 3:
                        Collections.sort(users, new AgeComparator());
                        Collections.sort(users, Comparator.comparing(User::getGender));
                        for(User user: users){
                            System.out.println(user);
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
            }
            
         }
    scanner.close();      
    }  
}
