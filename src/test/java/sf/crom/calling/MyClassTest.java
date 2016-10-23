package sf.crom.calling;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyClassTest {
String key="100";
String value="200";
	@Test
	public void testAdd(){
		MyClass myclass = new MyClass();
		myclass.add(key, value);
	}
	public void testGet(){
		MyClass myclass = new MyClass();
		String result = myclass.getValue(key);
		Assert.assertEquals(value, result);
	}
}
