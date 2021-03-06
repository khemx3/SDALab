package lab1;
 
import java.util.ArrayList;


/**
 * An abstract class for all Observable subjects
 */
public abstract class Observable {
	/**
	 * Constructs an Observable object
	 */
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * Attach to this push.Subject
	 * 
	 * @param o
	 *            the push.Observer that wishes to attach
	 */
	public void attach(Observer o) {
		this.observers.add(o);
	}

	/**
	 * Detach from this push.Subject
	 * 
	 * @param o
	 *            the push.Observer that wishes to detach
	 */
	public void detach(Observer o) {
		for (int i = 0; i < observers.size(); i++) {
			if (observers.get(i).equals(o))
				observers.remove(i);
		}
	}

	/**
	 * Notify all Observers that push.Subject has changed
	 */
	public void notifyObservers(CourseRecord record) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(this, record);
		}
	}

	/**
	 * Pull updated data from this push.Subject
	 * 
	 * @return the updated data from the push.Subject
	 */
	public abstract Object getUpdate();

	protected ArrayList<Observer> observers;
}