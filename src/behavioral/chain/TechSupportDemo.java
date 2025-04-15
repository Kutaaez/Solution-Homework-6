package behavioral.chain;

public class TechSupportDemo {
    public static void main(String[] args) {
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        faq.setNext(junior).setNext(senior);

        String[] issues = {
                "password_reset",
                "refund_request",
                "account_ban",
                "unknown_bug"
        };

        for (String issue : issues) {
            System.out.println("=== New Issue ===");
            faq.handle(issue);
            System.out.println();
        }
    }
}
