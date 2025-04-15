package behavioral.chain;

public class JuniorSupportHandler extends SupportHandler {
    @Override
    protected boolean canHandle(String issue) {
        return issue.equals("refund_request") || issue.equals("billing_issue");
    }
}
