package Tools;

public class TupleKeyValueValue<T1, T2, T3> {

	public final T1 key;
	public final T2 value;
	public final T3 value2;

	public TupleKeyValueValue(T1 key, T2 value, T3 value2) {
		this.key = key;
		this.value = value;
		this.value2 = value2;
	}

	public final T1 getkey() {
		return key;
	}

	public final T2 getvalue() {
		return value;
	}

	public final T3 getvalue2() {
		return value2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		else if (!(obj instanceof TupleKeyValueValue<?, ?, ?>)) {
			return false;
		}

		TupleKeyValueValue<?, ?, ?> other = (TupleKeyValueValue<?, ?, ?>)obj;
		return Tuple.equals(this.key, other.key)
			&& Tuple.equals(this.value, other.value)
			&& Tuple.equals(this.value2, other.value2);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + (this.key != null ? this.key.hashCode() : 0);
		hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
		hash = 79 * hash + (this.value2 != null ? this.value2.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s, %s)", key, value, value2);
	}

}