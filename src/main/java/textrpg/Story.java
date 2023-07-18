package textrpg;
//class that does nothing but storing methods to print out every part of the story
public class Story {

    public static String printIntro() {
        return "Once upon a time, in a land far away, there existed a mystical forest shrouded in enchantment and mystery. " +
                "Legends spoke of a hidden treasure concealed within its depths—a relic said to grant unimaginable power to its possessor. " +
                "Many brave adventurers had entered the forest in search of this legendary artifact, but few had returned.\n"
                + "\n" +
                "You find yourself standing at the entrance of the forest, a dense canopy of ancient trees blocking out the sunlight. " +
                "As you take your first step into the darkness, the path splits into four distinct trails. " +
                "Each path seems to hold its own secrets and perils. Which path will you choose?\n"
                + "\n" +
                "Option 1: The Path of Wisdom\n" +
                "This trail is marked by ancient inscriptions carved into the bark of trees. It promises knowledge and guidance.\n" +
                "\n" +
                "Option 2: The Path of Strength\n" +
                "This trail winds through thick underbrush, suggesting physical challenges lie ahead. It promises great power and mighty foes.\n" +
                "\n" +
                "Option 3: The Path of Stealth\n" +
                "This trail is veiled in a cloak of silence, hinting at hidden dangers and cunning adversaries. It promises stealth and subterfuge.\n" +
                "\n" +
                "Option 4: The Path of Compassion\n" +
                "This trail reveals a serene aura, whispering tales of empathy and unity. It promises alliances and compassion.\n" +
                "\n" +
                "Remember, your choices will shape your destiny in this enchanted forest. Choose wisely, for the adventure awaits!\n" +
                "\n" +
                "Enter 'Wisdom', 'Strength', 'Stealth' or 'Compassion'.\n" +
                "To get back to the menu, enter 'Menu'";
    }
    public static String printAct1Wisdom() {

        return "The Path of Wisdom\n" +
                "As you traverse the Path of Wisdom, you stumble upon an ancient library hidden within the forest's depths. " +
                "The shelves are lined with tomes containing forgotten knowledge. " +
                "One particular book catches your attention—the Book of Riddles." +
                " Opening it, you discover a riddle inscribed on the first page.\n" +
                "\n" +
                "Option 1: Solve the riddle.\n" +
                "Option 2: Ignore the riddle and explore the library.";
    }

    public static String printAct1Strength() {

        return "The Path of Strength\n" +
                "You find yourself facing a massive, towering tree blocking your way. " +
                "Its gnarled branches reach out menacingly, daring you to prove your strength. What will you do?\n" +
                "\n" +
                "Option 1: Confront the tree head-on and engage in combat.\n" +
                "Option 2: Look for an alternate route around the tree.";
    }

    public static String printAct1Stealth() {

        return "The Path of Stealth\n" +
                "As you move silently along the Path of Stealth, you come across a group of forest guards patrolling the area. " +
                "They seem unaware of your presence. What action will you take?\n" +
                "\n" +
                "Option 1: Engage the guards in a stealthy takedown.\n" +
                "Option 2: Slip past them unnoticed and continue your journey.";
    }

    public static String printAct1Compassion() {

        return "The Path of Compassion\n" +
                "Walking the Path of Compassion, you encounter a wounded creature lying pathetically on the ground. Its eyes meet yours, filled with fear and pain. What will you do?\n" +
                "\n" +
                "Option 1: Offer aid and tend to its wounds.\n" +
                "Option 2: Ignore the creature and press on.";
    }
}
