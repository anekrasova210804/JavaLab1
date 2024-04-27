package force.sith;
import force.forcebase.ForceUser;
import force.jedi.*;

import java.util.ArrayList;
import java.util.List;

public class SithApprentice extends SithBase {

    SithMaster master;
    public SithApprentice(String _name, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = "red";
        this.experience = _experience;
        this.bodyParts = _bodyParts;
    }


    public SithApprentice(JediInitiate initiate)
    {
        System.out.println(initiate.getName() + " turned to the Dark Side!");
        this.name = initiate.getName();
        this.lightsaberColor = "red";
        this.experience = initiate.getExperience() * 2;
        this.bodyParts = initiate.getBodyParts();
    }

    public SithApprentice(JediPadawan padawan)
    {
        System.out.println(padawan.getName() + " turned to the Dark Side!");
        this.name = padawan.getName();
        this.lightsaberColor = "red";
        this.experience = padawan.getExperience() * 4;
        this.bodyParts = padawan.getBodyParts();
    }

    public SithApprentice(JediKnight knight)
    {
        System.out.println(knight.getName() + " turned to the Dark Side!");
        this.name = knight.getName();
        this.lightsaberColor = "red";
        this.experience = knight.getExperience() * 8;
        this.bodyParts = knight.getBodyParts();
    }

    public SithApprentice(JediMaster _master)
    {
        System.out.println(_master.getName() + " turned to the Dark Side!");
        this.name = _master.getName();
        this.lightsaberColor = "red";
        this.experience = _master.getExperience() * 16;
        this.bodyParts = _master.getBodyParts();
    }

    public void assignMaster(SithMaster _master)
    {
        this.master = _master;
    }

    @Override
    public void listenToTheForce() {
        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force weeps for its child.");
        }
        else
        {System.out.println("The Force begs " + this.name + " to turn back to the light, while " +
                this.name + " still can.");}
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " decided to fight " + otherUser.getName() + " with hate!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - this.experience, 0));
    }

    @Override
    public void forceChoke(ForceUser otherUser) {
        System.out.println(this.name + " decided to choke " + otherUser.getName() + ", then let go.");
    }


    @Override
    public void forceLightning(ForceUser otherUser) {
        System.out.println(this.name + " decided to use Force Lightning on " + otherUser.getName() + "!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - this.experience, 0));
    }

}
