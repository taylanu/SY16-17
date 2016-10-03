import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodingEx {
    public static void main(String... args) throws Exception {
        final String s = "old crow medicine show";
        final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        System.out.println(s + " => " + encoded);
    }
}