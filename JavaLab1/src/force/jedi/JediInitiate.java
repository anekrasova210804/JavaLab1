package force.jedi;

import force.forcebase.ForceUser;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class JediInitiate extends JediBase {

    public JediInitiate(String _name, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = "NONE";
        this.experience = _experience;
        this.bodyParts = _bodyParts;
        this.favouriteForm = ThreadLocalRandom.current().nextInt(1, 7);
    }

    @Override
    public void ForceHeal(ForceUser otherUser) {
        System.out.println(this.name + " tried very hard to heal " + otherUser.getName() + "!");
        otherUser.setHealth(Math.min(otherUser.getHealth() + 2 * this.experience, 100));
    }

    @Override
    public void Meditate() {
        System.out.println(this.name + " tried very hard to meditate, but got bored after a while!");
        this.experience += 1;
    }

    @Override
    public void listenToTheForce() {

        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force said that it won't pay child support.");
        }
        else
        {
            System.out.println("The Force told " + this.name + " to eat vegetables!");
        }
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " tried very hard to fight " + otherUser.getName() + " with Form " +
                this.favouriteForm +"!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - 2 * this.experience, 0));
    }

    public void pickOutLightsaber()
    {
        int randNum = ThreadLocalRandom.current().nextInt(0, 6);
        switch(randNum)
        {
            case(0):
                this.setLightsaberColor("blue");
                break;
            case(1):
                this.setLightsaberColor("purple");
                break;
            case(2):
                this.setLightsaberColor("green");
                break;
            case(3):
                this.setLightsaberColor("yellow");
                break;
            case(4):
                this.setLightsaberColor("orange");
                break;
            case(5):
                this.setLightsaberColor("white");
                break;
        }
        System.out.println("Congratulations! " + this.name + "'s lightsaber is " + this.lightsaberColor);
    }
}
