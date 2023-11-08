package pl.rekrutacja.empik.users;

public class Calculator {

    private final int followers;
    private final int publicRepos;


    public Calculator(int followers, int publicRepos) {
        this.followers = followers;
        this.publicRepos = publicRepos;
    }

    public double calculate() {
        return (double) 6 / followers * (2 + publicRepos);
    }
}
