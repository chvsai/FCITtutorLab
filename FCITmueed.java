class FCITmueed {
	private String name;
	private String lastName;
	private int[] startTimes;
	private int[] endTimes;
	private FCITstudent studentWithMueed;
	private int minute;

	FCITmueed(String name, int[] startTimes, int[] endTimes) {
		this.setName(name);
		this.setStartTimes(startTimes);
		this.setEndTimes(endTimes);
	}

	/**
	 * @return the startTimes
	 */
	public int[] getStartTimes() {
		return startTimes;
	}

	/**
	 * @param startTimes the startTimes to set
	 */
	public void setStartTimes(int[] startTimes) {
		this.startTimes = startTimes;
	}

	/**
	 * @return the endTimes
	 */
	public int[] getEndTimes() {
		return endTimes;
	}

	/**
	 * @param endTimes the endTimes to set
	 */
	public void setEndTimes(int[] endTimes) {
		this.endTimes = endTimes;
	}

	/**
	 * @return the studentWithMueed
	 */
	public FCITstudent getStudentWithMueed() {
		return studentWithMueed;
	}

	/**
	 * @param studentWithMueed the studentWithMueed to set
	 */
	public void setStudentWithMueed(FCITstudent studentWithMueed) {
		this.studentWithMueed = studentWithMueed;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
