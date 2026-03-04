package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//SuppressWarnings({"java:S1186", "java:S1135", "java:S1172"}) // при выполнении ДЗ эту аннотацию надо удалить
public class CustomerService {

    private TreeMap<Customer, String> customerMap;

    public CustomerService() {
        customerMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
    }

    public Map.Entry<Customer, String> copyMapEntry(Map.Entry<Customer, String> originalEntry) {
        Map.Entry<Customer, String> copy = null;
        if(originalEntry != null) {
            copy = Map.entry(new Customer(originalEntry.getKey()), originalEntry.getValue());
        }
        return copy;
    }

    public Map.Entry<Customer, String> getSmallest() {
        // Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> firstEntry = customerMap.firstEntry();
        return copyMapEntry(firstEntry);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> found = customerMap.higherEntry(customer);
        return copyMapEntry(found);
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }
}
