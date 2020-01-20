package lab1;

//import java.util.Vector;

import java.util.ArrayList;
import javax.swing.JOptionPane;

//import observer.CourseRecord;

/**
 * Represents a vector of CourseRecords.
 */
public class CourseData extends Observable {

	/**
	 * Constructs a CourseData object
	 */
	public CourseData() {
		this.courseData = new ArrayList<CourseRecord>();
	}

	/**
	 * Add a new CourseRecord object
	 * 
	 * @param courseRecord
	 *            the CourseRecord to be added
	 */
	public void addCourseRecord(CourseRecord courseRecord) {
		boolean alreadyExists = false;
		for (int i = 0; i < courseData.size(); i++) {
			CourseRecord record = courseData.get(i);
			if (record.getName().equals(courseRecord.getName())) {
				alreadyExists = true;
				JOptionPane
						.showMessageDialog(
								null,
								"Warning: Attempt to add new course with an already existing name",
								"alert", JOptionPane.ERROR_MESSAGE);
				i = courseData.size(); // exit the loop
			}
		}
		if (!alreadyExists)
			this.courseData.add(courseRecord);
		this.notifyObservers(courseRecord);
	}

	/**
	 * Update an existing CourseRecord object
	 * 
	 * @param subjectName
	 *            the name CourseRecord to be updated
	 * @param numOfStudents
	 *            the new number of students for this course
	 */
	public void changeCourseRecord(String subjectName, int numOfStudents) {
		CourseRecord record = null;
		for (int i = 0; i < courseData.size(); i++) {
			record = courseData.get(i);
			if (record.getName().equals(subjectName)) {
				record.setNumOfStudents(numOfStudents);
				i = courseData.size();
			}
		}
		this.notifyObservers(record);
	}

	/**
	 * Return a copy of the vector of course data. Used by Observers to pull
	 * data.
	 * 
	 * @return vector of course data
	 */
	public ArrayList<CourseRecord> getUpdate() {
		return (ArrayList<CourseRecord>) courseData.clone();
	}

	private ArrayList<CourseRecord> courseData;

     
}