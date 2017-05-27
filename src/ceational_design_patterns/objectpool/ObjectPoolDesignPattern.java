package ceational_design_patterns.objectpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Performance can be sometimes the key issue during the software development and the
 *  object creation(class instantiation) is a costly step. While the Prototype pattern 
 *  helps in improving the performance by cloning the objects, the Object Pool pattern
 *  offer a mechanism to reuse objects that are expensive to create. 
 *
 */


interface Parser<E, T> {
   
    public void parse(E elementToBeParsed, T result) throws Exception;
    public boolean isValid();
    public void reset();
}
	

class XmlParser<E, T> implements Parser<E, T> {
    private Exception exception;
    @Override
    public void parse(E elementToBeParsed, T result) throws Exception {
        try {
            System.out.println("[" + Thread.currentThread().getName()+ "]: Parser Instance:" + this);
            // Do some real parsing stuff.
        } catch(Exception e) {
            this.exception = e;
            e.printStackTrace(System.err);
            throw e;
        }
    }
    @Override
    public boolean isValid() {
        return this.exception == null;
    }
    @Override
    public void reset() {
        this.exception = null;
    }
}
	
class ParserPool{
	private BlockingQueue<XmlParser<String, String>> pool;
	private static ParserPool parserPool= null;
	private static  int size = 10;;
	
	public ParserPool(){
		pool = new ArrayBlockingQueue<XmlParser<String, String>>(size);
	}
	
	public static  ParserPool getInstance(){
		if(parserPool == null){
			synchronized (ParserPool.class) {
				if(parserPool == null){
					parserPool = new ParserPool();
				}
			}
		}
		return parserPool;
	} 
	
	public XmlParser<String, String> acquire(){
		if(pool.size() == 0 ){
			pool.add(new XmlParser<String, String>());
		}
		return pool.poll();
	}
	
	public void release(XmlParser<String, String> parser ){
	 pool.add(parser);	
	}
}

	
public class ObjectPoolDesignPattern {
	public static void main(String[] args) throws Exception {
		
		ParserPool pool = ParserPool.getInstance();
		XmlParser<String, String> xmlParser = pool.acquire();
		
		String xml = "<node> data<node>";
		String result = new String();
		
		xmlParser.parse(xml, result);
		xmlParser.reset();
		
		pool.release(xmlParser);		
	}
}