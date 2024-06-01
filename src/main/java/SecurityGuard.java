package main.java;

public class SecurityGuard extends Person {
    private String guardId;

    public SecurityGuard(String name, String email, String guardId) {
        super(name, email);
        this.guardId = guardId;
    }

    public String getGuardId() {
        return guardId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Guard ID: " + guardId);
    }
}
