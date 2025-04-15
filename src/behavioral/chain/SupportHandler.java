package behavioral.chain;

public abstract class SupportHandler {
    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public void handle(String issue) {
        System.out.println("[" + this.getClass().getSimpleName() + "] Received issue: " + issue);
        if (!process(issue) && next != null) {
            System.out.println("[" + this.getClass().getSimpleName() + "] Passing to next handler...");
            next.handle(issue);
        } else if (!canHandle(issue) && next == null) {
            System.out.println("[" + this.getClass().getSimpleName() + "] No handler found for: " + issue);

        }
    }
    protected abstract boolean canHandle(String issue);
    protected boolean process(String issue) {
        if (canHandle(issue)) {
            System.out.println("[" + this.getClass().getSimpleName() + "] Handled issue: " + issue);
            return true;
        }
        return false;
    }
}