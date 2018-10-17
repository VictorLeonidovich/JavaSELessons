package gtn.readerapinew;

public enum ObjectToRead implements IObjectToReadSettable, IObjectToReadGettable {
	RANGE_OF_NUMBERS(new RangeOfNumbers()) {
		@Override
		public void setObjectToRead(IListOfObjectsGettable objectToRead) {
			((ObjectToRead) super.objectToRead).setObjectToRead(objectToRead);
		}
	},
	ALPHABET(new Alphabet()) {
		@Override
		public void setObjectToRead(IListOfObjectsGettable objectToRead) {
			((ObjectToRead) super.objectToRead).setObjectToRead(objectToRead);
		}
	};

	private IListOfObjectsGettable objectToRead;

	private ObjectToRead(IListOfObjectsGettable objectToRead) {
		this.objectToRead = objectToRead;
	}

	public IListOfObjectsGettable getObjectToRead() {
		return objectToRead;
	}

	@Override
	abstract public void setObjectToRead(IListOfObjectsGettable objectToRead);

}
