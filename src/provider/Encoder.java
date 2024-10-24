package provider;

import java.nio.charset.Charset;

public class Encoder implements IEncoder{

    @Override
    public String encode(byte[] data, String charset) {
        if (data == null || charset == null || charset.isEmpty()) {
            throw new IllegalArgumentException("Dane lub zestaw znaków nie mogą być puste.");
        }
        return new String(data, Charset.forName(charset));
    }
}
