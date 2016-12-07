class FCITqueue {
	private FCITstudent first;
	private FCITstudent last;
	private int noOfStudentsInQueue;

	boolean isEmpty() {
		return this.getNoOfStudentsInQueue()==0;//return getFirst() == null;
	}

	void enqueue(FCITstudent student) {
		FCITstudent oldlast = last;
		last = student;
		if (isEmpty())
			setFirst(last);
		else
			oldlast.setNext(last);
		setNoOfStudentsInQueue(getNoOfStudentsInQueue() + 1);
	}

	FCITstudent dequeue() {
		FCITstudent student = getFirst();
		setFirst(getFirst().getNext());
		if (isEmpty())
			last = null;
		setNoOfStudentsInQueue(getNoOfStudentsInQueue() - 1);
		student.setNext(null);
		return student;
	}

	/**
	 * @return the first
	 */
	public FCITstudent getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(FCITstudent first) {
		this.first = first;
	}

	/**
	 * @return the noOfStudentsInQueue
	 */
	public int getNoOfStudentsInQueue() {
		return noOfStudentsInQueue;
	}

	/**
	 * @param noOfStudentsInQueue the noOfStudentsInQueue to set
	 */
	public void setNoOfStudentsInQueue(int noOfStudentsInQueue) {
		this.noOfStudentsInQueue = noOfStudentsInQueue;
	}

}
