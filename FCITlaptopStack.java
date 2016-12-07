class FCITlaptopStack {
	private int[] laptopSerials;
	private int currentPos;
	private int noOfLaptops;

	FCITlaptopStack(int noOfLaptops) {
		laptopSerials = new int[noOfLaptops];
	}

	void addLaptop(int laptopSerialNumber) {
		laptopSerials[currentPos++] = laptopSerialNumber;
	}

	int removeLaptop() {
		return laptopSerials[--currentPos];
	}

	int laptopsAvailable() {
		return currentPos;
	}

	/**
	 * @return the noOfLaptops
	 */
	public int getNoOfLaptops() {
		return noOfLaptops;
	}

	/**
	 * @param noOfLaptops
	 *            the noOfLaptops to set
	 */
	public void setNoOfLaptops(int noOfLaptops) {
		this.noOfLaptops = noOfLaptops;
	}
}
