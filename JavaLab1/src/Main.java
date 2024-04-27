import force.forcebase.ForceUser;
import force.jedi.JediInitiate;
import force.jedi.JediKnight;
import force.jedi.JediPadawan;
import force.jedi.JediMaster;
import force.sith.SithApprentice;
import force.sith.SithMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        List<ForceUser> forceUserList = getForceUsers();

        Scanner kbd = new Scanner (System.in);
        while (true)
        {
            System.out.println("Do you want to do stuff with Force Users? (yes or other)" );
            String decision = kbd.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                System.out.println("\tLIST OF ALREADY EXISTING FORCE USERS!");
                for (int i = 0; i < forceUserList.size(); ++i) {
                    System.out.println((i + 1) + ". " + forceUserList.get(i).toString());
                }

                Scanner sc = new Scanner(System.in);
                System.out.print("Enter index of a force user: ");
                int userIndex = sc.nextInt() - 1;

                try {
                    System.out.println("You have selected " + forceUserList.get(userIndex).getName() + "!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n You have selected a non-existing index... :/");
                }

                Scanner scan = new Scanner(System.in);
                int x = 0;
                String s = "";

                while (!"0".equals(s)) {
                    printOutUserMenu(forceUserList.get(userIndex));
                    s = scan.next();

                    try {
                        x = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input!");
                    }
                    Scanner switchScan = new Scanner(System.in);
                    int switchIndex;

                    switch (x) {
                        case 1:
                            forceUserList.get(userIndex).listenToTheForce();
                            break;
                        case 2:
                            printEveryoneButMe(userIndex, "fight yourself", forceUserList);
                            System.out.println("Who would you like to fight? ");
                            switchIndex = switchScan.nextInt() - 1;
                            if (userIndex == switchIndex) {
                                System.out.println("I already said that you can't fight yourself!!!");
                            } else {
                                forceUserList.get(userIndex).Fight(forceUserList.get(switchIndex));
                            }
                            break;
                        case 3:
                            forceUserList.get(userIndex).speak();
                            break;
                        case 4:
                            printEveryoneButMe(userIndex, "chop your own body parts", forceUserList);
                            System.out.println("Who's body part would you like to chop? ");
                            switchIndex = switchScan.nextInt() - 1;

                            if (userIndex == switchIndex) {
                                System.out.println("I already said that you can't chop up your own body parts!!!");
                            } else {
                                forceUserList.get(userIndex).chopUpBodyPart(forceUserList.get(switchIndex));
                            }
                            break;
                        case 5:
                            printEveryoneButMe(userIndex, "use Force on yourself", forceUserList);
                            System.out.println("Who are you gonna choose? ");
                            switchIndex = switchScan.nextInt() - 1;

                            if (userIndex == switchIndex) {
                                System.out.println("I already said that this is you!");
                            } else {
                                case5(forceUserList.get(userIndex), forceUserList.get(switchIndex));
                            }
                            break;
                        case 6:
                            if (forceUserList.get(userIndex) instanceof JediInitiate) {
                                ((JediInitiate)(forceUserList.get(userIndex))).Meditate();
                            } else if (forceUserList.get(userIndex) instanceof JediPadawan) {
                                ((JediPadawan)(forceUserList.get(userIndex))).Meditate();
                            } else if (forceUserList.get(userIndex) instanceof JediKnight) {
                                ((JediKnight)(forceUserList.get(userIndex))).Meditate();
                            } else if (forceUserList.get(userIndex) instanceof JediMaster) {
                                ((JediMaster)(forceUserList.get(userIndex))).Meditate();
                            } else if (forceUserList.get(userIndex) instanceof SithApprentice) {
                                printEveryoneButMe(userIndex, "use Force lightning on yourself", forceUserList);
                                System.out.println("Who are you going to use Force lightning on? ");
                                switchIndex = switchScan.nextInt() - 1;

                                if (userIndex == switchIndex) {
                                    System.out.println("I already said that this is you!");
                                } else {
                                    ((SithApprentice)(forceUserList.get(userIndex))).forceLightning(forceUserList.get(
                                            switchIndex
                                    ));
                                }


                            } else if (forceUserList.get(userIndex) instanceof SithMaster) {
                                printEveryoneButMe(userIndex, "use Force lightning on yourself", forceUserList);
                                System.out.println("Who are you gonna choose? ");
                                switchIndex = switchScan.nextInt() - 1;
                                if (userIndex == switchIndex) {
                                    System.out.println("I already said that this is you!");
                                } else {
                                    ((SithMaster)(forceUserList.get(userIndex))).forceLightning(forceUserList.get(
                                            switchIndex
                                    ));
                                }
                            }
                            break;
                        case 7:
                            if (forceUserList.get(userIndex) instanceof JediInitiate) {
                                ((JediInitiate)(forceUserList.get(userIndex))).pickOutLightsaber();
                            } else if (forceUserList.get(userIndex) instanceof JediPadawan) {
                                for (int i = 0; i < forceUserList.size(); ++i) {
                                    if (i == userIndex) {
                                        System.out.println((i + 1) + ". This is you!");
                                    } else {
                                        if (forceUserList.get(i) instanceof JediKnight || forceUserList.get(i) instanceof JediMaster) {
                                            System.out.println((i + 1) + ". " + forceUserList.get(i).toString());
                                        } else {
                                            System.out.println((i + 1) + ". " + forceUserList.get(i).getName() + " is not a" +
                                                    " Jedi Knight or a Jedi master!");
                                        }
                                    }
                                }
                                System.out.println("Who are you gonna choose? ");
                                switchIndex = switchScan.nextInt() - 1;
                                if (userIndex == switchIndex || !(forceUserList.get(switchIndex) instanceof JediKnight || forceUserList.get(switchIndex) instanceof JediMaster)) {
                                    System.out.println("I already said that you can't choose that!");
                                } else {
                                    if (forceUserList.get(switchIndex) instanceof JediKnight)
                                        ((JediPadawan)(forceUserList.get(userIndex))).assignMaster((JediKnight)(forceUserList.get(switchIndex)));
                                    else if (forceUserList.get(switchIndex) instanceof JediMaster)
                                        ((JediPadawan)(forceUserList.get(userIndex))).assignMaster((JediMaster)(forceUserList.get(switchIndex)));
                                }

                            } else if (forceUserList.get(userIndex) instanceof JediKnight) {
                                forceUserList.set(userIndex, new JediMaster((JediKnight)(forceUserList.get(userIndex))));
                            } else if (forceUserList.get(userIndex) instanceof JediMaster) {
                                forceUserList.set(userIndex, new SithApprentice((JediMaster)(forceUserList.get(userIndex))));
                            } else if (forceUserList.get(userIndex) instanceof SithApprentice) {
                                for (int i = 0; i < forceUserList.size(); ++i) {
                                    if (!(forceUserList.get(i) instanceof SithMaster)) {
                                        System.out.println((i + 1) + ". You can't choose that!");
                                    } else {
                                        System.out.println((i + 1) + ". " + forceUserList.get(i).toString());
                                    }
                                }
                                System.out.println("Who are you gonna choose? ");
                                switchIndex = switchScan.nextInt() - 1;
                                if (!(forceUserList.get(switchIndex) instanceof SithMaster)) {
                                    System.out.println("I already said that you can't choose that!");
                                } else {
                                    ((SithApprentice)(forceUserList.get(userIndex))).assignMaster((SithMaster)(forceUserList.get(switchIndex)));
                                }

                            } else if (forceUserList.get(userIndex) instanceof SithMaster) {
                                printEveryoneButMe(userIndex, "drain yourself", forceUserList);
                                System.out.println("Who are you gonna drain? ");
                                switchIndex = switchScan.nextInt() - 1;
                                if (userIndex == switchIndex) {
                                    System.out.println("I already said that you can't drain yourself!");
                                } else {
                                    ((SithMaster)(forceUserList.get(userIndex))).forceDrain(forceUserList.get(
                                            switchIndex
                                    ));
                                }
                            }
                            break;
                        case 8:
                            if (forceUserList.get(userIndex) instanceof JediMaster || forceUserList.get(userIndex) instanceof SithMaster) {
                                System.out.println("Option 8 doesn't exist for this Force User!");
                            } else {
                                if (forceUserList.get(userIndex) instanceof JediInitiate) {
                                    forceUserList.set(userIndex, new JediPadawan((JediInitiate)(forceUserList.get(userIndex))));

                                } else if (forceUserList.get(userIndex) instanceof JediPadawan) {
                                    ((JediPadawan)(forceUserList.get(userIndex))).trainWithMaster();

                                } else if (forceUserList.get(userIndex) instanceof JediKnight) {
                                    forceUserList.set(userIndex, new SithApprentice((JediKnight)(forceUserList.get(userIndex))));
                                } else if (forceUserList.get(userIndex) instanceof SithApprentice) {
                                    forceUserList.set(userIndex, new SithMaster((SithApprentice)(forceUserList.get(userIndex))));
                                }
                            }
                            break;
                        case 9:
                            if (forceUserList.get(userIndex) instanceof JediMaster || forceUserList.get(userIndex) instanceof SithApprentice
                    || forceUserList.get(userIndex) instanceof JediKnight || forceUserList.get(userIndex) instanceof SithMaster) {
                                System.out.println("Option 9 doesn't exist for this Force User!");
                            } else {
                                if (forceUserList.get(userIndex) instanceof JediInitiate) {
                                    forceUserList.set(userIndex, new SithApprentice((JediInitiate)(forceUserList.get(userIndex))));

                                } else if (forceUserList.get(userIndex) instanceof JediPadawan) {
                                    forceUserList.set(userIndex, new JediKnight((JediPadawan)(forceUserList.get(userIndex))));

                                }
                            }
                            break;
                        case 10:
                            if (forceUserList.get(userIndex) instanceof JediMaster || forceUserList.get(userIndex) instanceof JediInitiate
                                    || forceUserList.get(userIndex) instanceof JediKnight || forceUserList.get(userIndex) instanceof SithMaster ||
                                    forceUserList.get(userIndex) instanceof SithApprentice) {
                                System.out.println("Option 10 doesn't exist for this Force User!");
                            } else {
                                if (forceUserList.get(userIndex) instanceof JediPadawan) {
                                    forceUserList.set(userIndex, new SithApprentice((JediPadawan)(forceUserList.get(userIndex))));

                                }
                            }
                            break;
                        default:
                            System.out.println("Incorrect input!");
                            break;
                        case 0:
                            System.out.println("Bye-bye, " + forceUserList.get(userIndex).getName() + "!");
                    }
                }
            }
            else
                break;
        }
    }


    private static List<ForceUser> getForceUsers() {
        List<ForceUser> forceUserList = new ArrayList<>();
        JediMaster obiWan = new JediMaster("Obi-wan Kenobi", "blue", 33, new ArrayList<String>(List.of(new String[]{"head",
                "arm", "arm", "leg", "leg"})));
        JediKnight anakin = new JediKnight("Anakin Skywalker","blue",35, new ArrayList<String>(List.of(new String[]{"head",
                "arm", "mechanical arm", "leg", "leg"})));
        JediInitiate ashoka = new JediInitiate("Ashoka Tano", 11, new ArrayList<String>(List.of(new String[]{"head",
                "arm", "arm", "leg", "leg"})));
        SithApprentice maul = new SithApprentice("Maul", 16, (ArrayList<String>) new ArrayList<String>(List.of(new String[]{"head",
                "arm", "arm", "leg", "leg"})));
        SithMaster palpatine = new SithMaster("Sheev Palpatine", 49, (ArrayList<String>) new ArrayList<String>(List.of(new String[]{"head",
                "arm", "arm", "leg", "leg"})));
        forceUserList.add(obiWan);
        forceUserList.add(anakin);
        forceUserList.add(ashoka);
        forceUserList.add(maul);
        forceUserList.add(palpatine);
        return forceUserList;
    }

    private static void printOutUserMenu(ForceUser _user)
    {
        System.out.println("0. Exit this one.");
        System.out.println("1. Listen to the Force.");
        System.out.println("2. Fight with Someone.");
        System.out.println("3. Speak.");
        System.out.println("4. Chop up Someone's body part.");

        if (_user instanceof JediInitiate)
        {
            System.out.println("5. Force heal Someone.");
            System.out.println("6. Meditate.");
            System.out.println("7. Pick out a lightsaber.");
            System.out.println("8. Become a padawan.");
            System.out.println("9. Turn to the Dark Side.");
        }
        else if (_user instanceof JediPadawan)
        {
            System.out.println("5. Force heal Someone.");
            System.out.println("6. Meditate.");
            System.out.println("7. Pick out a Master.");
            System.out.println("8. Train with Master.");
            System.out.println("9. Go to the Knight Trials.");
            System.out.println("10. Turn to the Dark Side.");
        }
        else if (_user instanceof JediKnight)
        {
            System.out.println("5. Force heal Someone.");
            System.out.println("6. Meditate.");
            System.out.println("7. Become a Master.");
            System.out.println("8. Turn to the Dark Side.");
        }
        else if (_user instanceof JediMaster)
        {
            System.out.println("5. Force heal Someone.");
            System.out.println("6. Meditate.");
            System.out.println("7. Turn to the Dark Side.");
        }
        else if (_user instanceof SithApprentice)
        {
            System.out.println("5. Force choke Someone.");
            System.out.println("6. User Force lightning on Someone.");
            System.out.println("7. Pick out a Master.");
            System.out.println("8. Become a Sith Master.");
        }
        else if (_user instanceof SithMaster)
        {
            System.out.println("5. Force choke Someone.");
            System.out.println("6. User Force lightning on Someone.");
            System.out.println("7. Force drain Someone.");
        }
    }

    private static void case5(ForceUser _user, ForceUser otherUser)
    {
        if (_user instanceof JediInitiate)
        {
            ((JediInitiate)(_user)).ForceHeal(otherUser);
        }
        else if (_user instanceof JediPadawan)
        {
            ((JediPadawan)(_user)).ForceHeal(otherUser);
        }
        else if (_user instanceof JediKnight)
        {
            ((JediKnight)(_user)).ForceHeal(otherUser);
        }
        else if (_user instanceof JediMaster)
        {
            ((JediMaster)(_user)).ForceHeal(otherUser);
        }
        else if (_user instanceof SithApprentice)
        {
            ((SithApprentice)(_user)).forceChoke(otherUser);
        }
        else if (_user instanceof SithMaster)
        {
            ((SithMaster)(_user)).forceChoke(otherUser);
        }
    }

    private static void printEveryoneButMe(int userIndex, String str, List<ForceUser> forceUserList)
    {
        for (int i = 0; i < forceUserList.size(); ++i) {

            if (i == userIndex) {
                System.out.println((i + 1) + ". You can't " + str + "!");
            } else {
                System.out.println((i + 1) + ". " + forceUserList.get(i).toString());
            }
        }
    }

}