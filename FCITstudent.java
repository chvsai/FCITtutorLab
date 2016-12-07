class FCITstudent {
	private String firstName;
	private String lastName;
	private int enterTime;
	private int numQuestions;
	private int numAnswered;
	private int laptopSerialNumber;
	private FCITstudent next;
	
	FCITstudent(){
		
	}
	FCITstudent(int enterTime, String firstName, String lastName,
			int numQuestions) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEnterTime(enterTime);
		this.setNumQuestions(numQuestions);
	}

	private void setNumQuestions(int numQuestions) {
		// TODO Auto-generated method stub
		this.numQuestions=numQuestions;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the next
	 */
	public FCITstudent getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(FCITstudent next) {
		this.next = next;
	}
	/**
	 * @return the enterTime
	 */
	public int getEnterTime() {
		return enterTime;
	}
	/**
	 * @param enterTime the enterTime to set
	 */
	public void setEnterTime(int enterTime) {
		this.enterTime = enterTime;
	}
	/**
	 * @return the laptopSerialNumber
	 */
	public int getLaptopSerialNumber() {
		return laptopSerialNumber;
	}
	/**
	 * @param laptopSerialNumber the laptopSerialNumber to set
	 */
	public void setLaptopSerialNumber(int laptopSerialNumber) {
		this.laptopSerialNumber = laptopSerialNumber;
	}
	/**
	 * @return the numAnswered
	 */
	public int getNumAnswered() {
		return numAnswered;
	}
	/**
	 * @param numAnswered the numAnswered to set
	 */
	public void setNumAnswered(int numAnswered) {
		this.numAnswered = numAnswered;
	}
	/**
	 * @return the numQuestions
	 */
	public int getNumQuestions() {
		return numQuestions;
	}
	/**
	 * @param numQuestions the numQuestions to set
	 */
	public void decrementNumQuestions(int numQuestions) {
		this.numQuestions = --numQuestions;
	}

}
