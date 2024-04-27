package force.forcebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ForceUser {
    protected String name;
    protected String lightsaberColor;
    protected int experience;
    protected int health = 100;
    protected ArrayList<String> bodyParts = new ArrayList<>();

    public abstract void listenToTheForce();

    public abstract void Fight(ForceUser otherUser);

    public String getName()
    {
        return this.name;
    }

    public String getLightsaberColor() {
        return lightsaberColor;
    }

    public void setLightsaberColor(String lightsaberColor) {
        this.lightsaberColor = lightsaberColor;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<String> getBodyParts() {
        return bodyParts;
    }

    public void speak()
    {
        System.out.print(this.name + ": ");
        switch (this.name)
        {
            case ("Anakin Skywalker"):
                System.out.println("I don't like sand. It's course and rough and irritating, and it gets everywhere...");
                break;
            case ("Obi-wan Kenobi"):
                System.out.println("Hello there!! :D");
                break;
            case ("Luke Skywalker"):
                System.out.println("Hi, I'm Luke Skywalker. I'm here to resque you!! :D");
                break;
            case("Firmus Piett"):
                System.out.println("As you wish, my Lord...");
                break;
            case("General Grievous"):
                System.out.println("Your lightsabers will make a fine addition to my collection!");
                break;
            case("Ashoka Tano"):
                System.out.println("I am no Jedi!");
                break;
            case("Count Dooku"):
                System.out.println("Twice the pride, double the fall!");
                break;
            case("Poe Dameron"):
                System.out.println("... Is that my jacket?");
                break;
            case("Padme Amidala"):
                System.out.println("So this is how liberty dies - to a thunderous applause...");
                break;
            case("Qui-Gon Jinn"):
                System.out.println("The ability to speak does not make you intelligent. Now get out of here.");
                break;
            case("Grogu"):
                System.out.println("Patu!! Uaaaa!!");
                break;
            case("Maul"):
                System.out.println("KENOBIIIIIII!");
                break;
            case("Sheev Palpatine"):
                System.out.println("I AM the Senate!");
                break;
            default:
                System.out.println("Hi, my name is" + this.name + " and I am force-sensitive!");
                break;
        }

    }


    public void chopUpBodyPart(ForceUser otherUser) {
        if (otherUser.experience < this.experience)
        {
            System.out.println(this.name + " doesn't succeed in chopping up " +
                    otherUser.name + "'s body parts, because " + this.name +
                    " is too inexperienced!");
        }
        else
        {
            int randNum = ThreadLocalRandom.current().nextInt(0, otherUser.getBodyParts().size());
            if (Objects.equals(otherUser.getBodyParts().get(randNum), "head"))
            {
                System.out.println("Congrats! " + this.name + " killed " + otherUser.name
                + " because " + this.name + " cut off " + otherUser.name + "'s head!!!");
                otherUser.health = 0;
                System.out.println(otherUser.name + "'s health is at " + otherUser.health);
            }
            else
            {
                System.out.println("Congrats! " + this.name + " successfully chopped up " +
                    otherUser.name + "'s " + otherUser.getBodyParts().get(randNum));
            }
            otherUser.getBodyParts().remove(otherUser.getBodyParts().get(randNum));
        }
    }



    public String toString() {
        return (this.name + " with " + this.experience + " experience and "
        + this.health + " health!");
    }
}
