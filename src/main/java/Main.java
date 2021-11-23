import java.util.Optional;

public class Main {
    
    public static void main(String[] args) {
    
        Optional<String> hello = Optional.ofNullable(null);
    
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());
    
        String orElse = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    return "world | elseGet";
                });
        System.out.println(orElse);
        
        hello.ifPresent(System.out::println);
        
        hello.ifPresentOrElse(System.out::println, () -> System.out.println("world | ifPresentOrElse"));
        
        Person person = new Person("james", "JAMES@gmail.com");
        String email = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("email not provided");
        
        System.out.println(email);
                      
        
    }
}

class Person{
    private final String name;
    private final String email;
    
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
