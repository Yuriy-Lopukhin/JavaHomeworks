package Seminar5;

import java.util.*;

public class Book{

    private HashMap<String, TreeSet<String>> phoneBook;

    public Book() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.add(phoneNumber);
        phoneBook.put(name, phones);
    }

    public void removeContact(String name, String phoneNumber) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.remove(phoneNumber);
        if (phones.isEmpty()) {
            phoneBook.remove(name);
        } else {
            phoneBook.put(name, phones);
        }
    }

    public TreeSet<String> getPhones(String name) {
        return phoneBook.get(name);
    }

    public HashMap<String, TreeSet<String>> getAllContacts(String name) {
        return phoneBook;
    }

    public void printBook() {
        for (String name : phoneBook.keySet()) {
            TreeSet<String> phones = phoneBook.get(name);
            System.out.println(name + ": " + phones);
        }
    }

    public List<String> sortContactsbyPhones() {
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().size() - e2.getValue().size());

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        return result;
    }

}


public static void main(String[] args){
   Book phoneBook = new Book();

   phoneBook.addContact("Иван Петров", "2957364");
   phoneBook.addContact("Иван Петров", "7620344");
   phoneBook.addContact("Андрей Павлов", "9764100");
   phoneBook.addContact("Дмитрий Иванов", "0641529");

   phoneBook.printBook();
   System.out.println("==============================================================");

   TreeSet<String> ivanPhones = phoneBook.getPhones("Иван Петров");
   System.out.println("ИванПетров телефоны: " + ivanPhones);
   System.out.println("==============================================================");

   phoneBook.removeContact("Иван Петров", "7620344");
   TreeSet<String> ivanPhonesAfterRemove = phoneBook.getPhones("Иван Петров");
   System.out.println("ИванПетров телефоны: " + ivanPhonesAfterRemove);
   System.out.println("==============================================================");

   List<String> sortedContacts = phoneBook.sortContactsbyPhones();
   System.out.println("Телефонная книга, отсортированная по номерам телефонов: ");
   for (String contact : sortedContacts){
    System.out.println(contact);
   }
}
