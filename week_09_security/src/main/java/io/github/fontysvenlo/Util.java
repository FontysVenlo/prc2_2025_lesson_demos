package io.github.fontysvenlo;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        var inBytes = new byte[blockSize];
        var outBytes = new byte[outputSize];

        int inLength = 0;
        while (true) {
            inLength = in.read(inBytes);
            if(inLength == blockSize) {
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            }else{
                break;
            }
        }
        if (inLength > 0) {
            outBytes = cipher.doFinal(inBytes, 0 , inLength);
        }else{
            outBytes = cipher.doFinal();
        }
        out.write(outBytes);
    }
}
