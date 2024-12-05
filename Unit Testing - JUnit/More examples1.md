Here are four simple Java program examples with methods that can be tested using JUnit:

---

### **1. String Utility: Palindrome Checker**

**Program**:
```java
public class StringUtils {
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void testIsPalindrome() {
        StringUtils utils = new StringUtils();

        assertTrue(utils.isPalindrome("madam"));
        assertTrue(utils.isPalindrome("Racecar"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
    }
}
```

---

### **2. File Validator: File Extension Checker**

**Program**:
```java
public class FileValidator {
    public boolean isValidFileExtension(String filename, String extension) {
        if (filename == null || extension == null) {
            return false;
        }
        return filename.toLowerCase().endsWith("." + extension.toLowerCase());
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileValidatorTest {
    @Test
    void testIsValidFileExtension() {
        FileValidator validator = new FileValidator();

        assertTrue(validator.isValidFileExtension("document.pdf", "pdf"));
        assertTrue(validator.isValidFileExtension("photo.JPG", "jpg"));
        assertFalse(validator.isValidFileExtension("video.mp4", "avi"));
        assertFalse(validator.isValidFileExtension(null, "jpg"));
        assertFalse(validator.isValidFileExtension("file.txt", null));
    }
}
```

---

### **3. Word Counter**

**Program**:
```java
public class WordCounter {
    public int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        return sentence.trim().split("\\s+").length;
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    @Test
    void testCountWords() {
        WordCounter counter = new WordCounter();

        assertEquals(5, counter.countWords("This is a simple test"));
        assertEquals(0, counter.countWords(""));
        assertEquals(0, counter.countWords(null));
        assertEquals(1, counter.countWords("Hello"));
    }
}
```

---

### **4. Traffic Light Simulator**

**Program**:
```java
public class TrafficLight {
    public String getNextLight(String currentLight) {
        if (currentLight == null) {
            return "Invalid";
        }
        switch (currentLight.toLowerCase()) {
            case "red":
                return "Green";
            case "green":
                return "Yellow";
            case "yellow":
                return "Red";
            default:
                return "Invalid";
        }
    }
}
```

**JUnit Test**:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {
    @Test
    void testGetNextLight() {
        TrafficLight light = new TrafficLight();

        assertEquals("Green", light.getNextLight("Red"));
        assertEquals("Yellow", light.getNextLight("Green"));
        assertEquals("Red", light.getNextLight("Yellow"));
        assertEquals("Invalid", light.getNextLight("Blue"));
        assertEquals("Invalid", light.getNextLight(null));
    }
}
```

---

These examples cover various domains:
1. **String manipulation** (Palindrome checker).
2. **File handling** (File extension checker).
3. **Text processing** (Word counter).
4. **Simulation** (Traffic light system).

Each example can be tested using JUnit to validate the expected behaviour. 
