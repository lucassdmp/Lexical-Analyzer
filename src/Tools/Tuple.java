package Tools;

public final class Tuple {

	public static <KEY, VALUE> TupleKeyValue<KEY, VALUE> create(KEY item1, VALUE item2) {
		return new TupleKeyValue<KEY, VALUE>(item1, item2);
	}

	public static <KEY, VALUE, VALUE2> TupleKeyValueValue<KEY, VALUE, VALUE2> create(KEY item1, VALUE item2, VALUE2 item3) {
		return new TupleKeyValueValue<KEY, VALUE, VALUE2>(item1, item2, item3);
	}

	public static boolean equals(Object x, Object y) {
		return x == y || (x != null && x.equals(y));
	}
	private Tuple() {}

}