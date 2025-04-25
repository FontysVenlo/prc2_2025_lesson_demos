package fontys.exceptionslambda;

import java.io.IOException;

/**
 *
 * @author hvd
 */
public class JustSomeInterfaceImpl implements JustSomeInterface {

    @Override
    public void doSomething() throws IOException{ //throws Exception{  --> This would not be allowed... Since super type of IOException in interface
       
         throw new IOException("bla");
        
    }


    
}
