package force.sith;
import force.forcebase.ForceUser;

import java.util.ArrayList;

public class SithMaster extends SithBase {

    public SithMaster(String _name, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = "red";
        this.experience = _experience;
        this.bodyParts = _bodyParts;
    }

    public SithMaster(SithApprentice apprentice)
    {
        System.out.println(apprentice.getName() + " became a Sith Master!");
        this.name = apprentice.getName();
        this.lightsaberColor = "red";
        this.experience = apprentice.getExperience() * 2;
        this.bodyParts = apprentice.getBodyParts();
    }

    @Override
    public void listenToTheForce() {
        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force said that its grandchildren are alive!");
        }
        else
        {System.out.println("The force is very sad around " + this.name +" for some reason...");}
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " decided to destroy " + otherUser.getName() + "!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - this.experience, 0));
    }

    @Override
    public void forceChoke(ForceUser otherUser) {
        System.out.println(this.name + " choked " + otherUser.getName() + ", then let go.");
    }


    public void forceDrain(ForceUser otherUser) {
        System.out.println(this.name + " drained the Force out of  " + otherUser.getName() + "!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - this.experience, 0));
        otherUser.setExperience(Math.max(otherUser.getExperience() - this.experience, 0));
    }

    @Override
    public void forceLightning(ForceUser otherUser) {
        System.out.println(this.name + " used Force Lightning on " + otherUser.getName() + "!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - this.experience, 0));
    }
}
