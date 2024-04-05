package Tools;

public class TupleKeyValue<KEY, VALUE> {
	public final KEY key;
	public final VALUE value;

	public TupleKeyValue(KEY key, VALUE value) {
		this.key = key;
		this.value = value;
	}

	public final KEY getKey() {
		return key;
	}

	public final VALUE getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		else if (!(obj instanceof TupleKeyValue<?, ?>)) {
			return false;
		}

		TupleKeyValue<?, ?> other = (TupleKeyValue<?, ?>)obj;
		return Tuple.equals(key, other.key) && Tuple.equals(value, other.value);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + (this.key != null ? this.key.hashCode() : 0);
		hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", key, value);
	}

}
