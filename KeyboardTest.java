import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.Attributes;

public class KeyboardTest {
    public static void main(String[] args) throws Exception {

        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            
            Attributes original = terminal.enterRawMode();

            try {
                System.out.println("Press WASD to test. Q to quit.");

                int key;
                
                while ((key = terminal.reader().read()) != -1) {
                    if (key == 'q') break;

                    System.out.println("Key pressed: " + (char) key);
                }
            } finally {
                terminal.setAttributes(original);
            }
        }
    }
}