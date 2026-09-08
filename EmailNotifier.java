package notification;

import model.Member;

public class EmailNotifier implements Notifier {

    @Override
    public void notifyMember(Member member, String message) {
        System.out.println("Email sent to " + member.getName() + ": " + message);
    }

}