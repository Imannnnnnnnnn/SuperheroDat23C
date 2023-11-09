public class ChangeTracker {
    private boolean dataChanged;

    public boolean trackChanges(Superhelt oldData, Superhelt newData) {
        if (!oldData.equals(newData)) {
            dataChanged = true;
        }

        return false;
    }

    public boolean hasDataChanged() {
        return dataChanged;
    }
}
