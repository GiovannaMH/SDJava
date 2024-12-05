Here are more examples of Java programs with methods that you can test using JUnit:

---

### **1. URL Validator**

**Program**:
```java
public class URLValidator {
    public boolean isValidURL(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }
        return url.matches("^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/.*)?$");
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class URLValidatorTest {
    @Test
    void testIsValidURL() {
        URLValidator validator = new URLValidator();

        assertTrue(validator.isValidURL("http://example.com"));
        assertTrue(validator.isValidURL("https://subdomain.example.com/path"));
        assertFalse(validator.isValidURL("ftp://example.com"));
        assertFalse(validator.isValidURL(null));
        assertFalse(validator.isValidURL(""));
    }
}
```

---

### **2. Temperature Converter**

**Program**:
```java
public class TemperatureConverter {
    public double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    @Test
    void testConvertCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(32, converter.convertCelsiusToFahrenheit(0), 0.01);
        assertEquals(212, converter.convertCelsiusToFahrenheit(100), 0.01);
    }

    @Test
    void testConvertFahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();

        assertEquals(0, converter.convertFahrenheitToCelsius(32), 0.01);
        assertEquals(100, converter.convertFahrenheitToCelsius(212), 0.01);
    }
}
```

---

### **3. Email Validator**

**Program**:
```java
public class EmailValidator {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
    @Test
    void testIsValidEmail() {
        EmailValidator validator = new EmailValidator();

        assertTrue(validator.isValidEmail("test@example.com"));
        assertTrue(validator.isValidEmail("user.name+tag@sub.example.co.uk"));
        assertFalse(validator.isValidEmail("plainaddress"));
        assertFalse(validator.isValidEmail("missing@domain"));
        assertFalse(validator.isValidEmail(null));
    }
}
```

---

### **4. Password Strength Checker**

**Program**:
```java
public class PasswordStrengthChecker {
    public String checkPasswordStrength(String password) {
        if (password == null || password.length() < 6) {
            return "Weak";
        }
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$")) {
            return "Strong";
        }
        return "Moderate";
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthCheckerTest {
    @Test
    void testCheckPasswordStrength() {
        PasswordStrengthChecker checker = new PasswordStrengthChecker();

        assertEquals("Weak", checker.checkPasswordStrength("12345"));
        assertEquals("Moderate", checker.checkPasswordStrength("abcdef"));
        assertEquals("Strong", checker.checkPasswordStrength("Abc123@1"));
        assertEquals("Weak", checker.checkPasswordStrength(null));
    }
}
```

---

### **5. Vowel Counter**

**Program**:
```java
public class VowelCounter {
    public int countVowels(String input) {
        if (input == null) {
            return 0;
        }
        return input.replaceAll("[^aeiouAEIOU]", "").length();
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VowelCounterTest {
    @Test
    void testCountVowels() {
        VowelCounter counter = new VowelCounter();

        assertEquals(5, counter.countVowels("This is a test sentence"));
        assertEquals(0, counter.countVowels("bcdfg"));
        assertEquals(0, counter.countVowels(null));
    }
}
```

---

### **6. Discount Calculator**

**Program**:
```java
public class DiscountCalculator {
    public double calculateDiscount(double price, double discountRate) {
        if (price < 0 || discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Invalid input");
        }
        return price - (price * discountRate / 100);
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {
    @Test
    void testCalculateDiscount() {
        DiscountCalculator calculator = new DiscountCalculator();

        assertEquals(90, calculator.calculateDiscount(100, 10), 0.01);
        assertEquals(75, calculator.calculateDiscount(100, 25), 0.01);
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(-100, 10));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(100, -10));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(100, 110));
    }
}
```

---

### **7. Character Frequency Counter**

**Program**:
```java
import java.util.HashMap;
import java.util.Map;

public class CharFrequencyCounter {
    public Map<Character, Integer> countFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        if (input == null) {
            return frequencyMap;
        }
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CharFrequencyCounterTest {
    @Test
    void testCountFrequency() {
        CharFrequencyCounter counter = new CharFrequencyCounter();

        Map<Character, Integer> result = counter.countFrequency("hello");
        assertEquals(1, result.get('h'));
        assertEquals(2, result.get('l'));
        assertEquals(1, result.get('o'));
        assertEquals(0, result.getOrDefault('z', 0));
    }
}
```

---

These examples span various domains, including validation, text processing, and logical operations, providing diverse scenarios for writing meaningful unit tests with JUnit.
