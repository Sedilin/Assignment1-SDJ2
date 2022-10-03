package util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    void addListener(String propertyName, PropertyChangeListener listener);
    void removeListener(String propertyName, PropertyChangeListener listener);
}
