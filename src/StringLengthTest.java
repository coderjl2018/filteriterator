
public class StringLengthTest implements IObjectTest {

	@Override
	public boolean test(Object o) {
		// must have at least 3 characters in the string object
		String x = (String) o;
		return x.length() >= 3;
	}
	
}
