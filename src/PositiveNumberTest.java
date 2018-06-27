
public class PositiveNumberTest implements IObjectTest {
	@Override
	public boolean test(Object o) {
		int x = (int) o;
		return x >= 0;
	}
}
