package spring.knight;

import java.io.OutputStream;
import java.io.PrintStream;

public class FakePrintStream extends PrintStream {

    public FakePrintStream(OutputStream out) {
        super(out);
    }
}
