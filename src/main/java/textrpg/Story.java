package textrpg;

//class that does nothing but storing methods to print out every part of the story
public class Story {

    public static String printIntro() {
        return """
                Once upon a time, in a land far away, there existed a mystical forest shrouded in enchantment and mystery. Legends spoke of a hidden treasure concealed within its depths—a relic said to grant unimaginable power to its possessor. Many brave adventurers had entered the forest in search of this legendary artifact, but few had returned.

                You find yourself standing at the entrance of the forest, a dense canopy of ancient trees blocking out the sunlight. As you take your first step into the darkness, the path splits into four distinct trails. Each path seems to hold its own secrets and perils. Which path will you choose?

                Option 1: The Path of Wisdom
                This trail is marked by ancient inscriptions carved into the bark of trees. It promises knowledge and guidance.

                Option 2: The Path of Strength
                This trail winds through thick underbrush, suggesting physical challenges lie ahead. It promises great power and mighty foes.

                Option 3: The Path of Stealth
                This trail is veiled in a cloak of silence, hinting at hidden dangers and cunning adversaries. It promises stealth and subterfuge.

                Option 4: The Path of Compassion
                This trail reveals a serene aura, whispering tales of empathy and unity. It promises alliances and compassion.

                Remember, your choices will shape your destiny in this enchanted forest. Choose wisely, for the adventure awaits!

                Enter 'Wisdom', 'Strength', 'Stealth' or 'Compassion'.
                To get back to the menu, enter 'Menu'
                """;
    }
    public static String printAct1Wisdom() {

        return """
                The Path of Wisdom
                As you traverse the Path of Wisdom, you stumble upon an ancient library hidden within the forest's depths.The shelves are lined with tomes containing forgotten knowledge. One particular book catches your attention—the Book of Riddles. Opening it, you discover a riddle inscribed on the first page.

                Option 1: Solve the riddle.
                Option 2: Ignore the riddle and explore the library.
                """;
    }

    public static String printAct1Wisdom1() {

        return """
                With a determined look, you set your mind to solving the riddle. It reads:

                "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?"
                
                Option 1: The answer is "echo."
                Option 2: The answer is "whisper.
                """;
    }

    public static String printAct1WisdomEcho() {

        return """
                You ponder for a moment, and a realization dawns upon you. The answer must be an echo!
                As you utter the word, a secret passageway reveals itself.
                """;
    }

    public static String printAct1WisdomWhisper() {

        return """
                You consider the riddle carefully, and a different answer comes to mind.
                The answer must be a whisper! However, as you say the word aloud, nothing happens, leaving you with a sense of uncertainty.
                You decide to explore the library further.
                """;
    }

    public static String printAct1WisdomLibrary() {

        return """
                As you delve deeper into the library, you stumble upon a dusty tome, its pages worn with age.
                The book contains valuable information about the forest's history and the location of a hidden room. What will you do?
                                
                Option 1: Take note of the hidden room's location and proceed there.
                Option 2: Go home, you don't like adventuring anymore.
                """;
    }

    public static String printAct1WisdomHiddenRoom() {

        return """
                Curiosity takes hold of you, and you step into the revealed passageway.
                It leads you to a hidden chamber filled with ancient artifacts and a pedestal at its center.
                Resting atop the pedestal is a small, glowing orb—the coveted treasure. What will you do?
                
                Option 1: Reach out and grab the glowing orb.
                Option 2: Go home, you don't like adventuring anymore.
                """;
    }

    public static String printAct1WisdomOrb() {

        return """ 
                Driven by your desire for power, you decide to seize the glowing orb without hesitation.
                As your hand wraps around it, a surge of energy courses through your body.
                You feel a newfound strength and wisdom, but the room begins to shake.
                The forest's guardians have been alerted. What will you do?
                
                Option 1: Brace yourself and prepare for a confrontation.
                Option 2: Seek a swift exit and try to evade the guardians.
                """;
    }

    public static String printAct1WisdomGuards() {

        return """
                You concentrate on the emanating power of the glowing orb. You feel a tingling sensation in your whole body.
                Instinctively you raise your free hand in front of your body. A word flashes through your mind "Avada Kedavra".
                
                Nothing happens...
                
                No this not right. You've read too much Harry Potter.
                Suddenly, you uncontrollably yell some gibberish instead and the guardians fall in an instant.
                Not believing what just happened, you stumble out of the library and hastily make your way back home.
                """;
    }

    public static String printAct1Strength() {

        return """
                The Path of Strength
                You find yourself facing a massive, towering tree blocking your way. Its gnarled branches reach out menacingly, daring you to prove your strength. What will you do?

                Option 1: Confront the tree head-on and engage in combat.
                Option 2: Look for an alternate route around the tree.""";
    }

    public static String printAct1Stealth() {

        return """
                The Path of Stealth
                As you move silently along the Path of Stealth, you come across a group of forest guards patrolling the area. They seem unaware of your presence. What action will you take?

                Option 1: Engage the guards in a stealthy takedown.
                Option 2: Slip past them unnoticed and continue your journey.""";
    }

    public static String printAct1Compassion() {

        return """
                The Path of Compassion
                Walking the Path of Compassion, you encounter a wounded creature lying pathetically on the ground. Its eyes meet yours, filled with fear and pain. What will you do?

                Option 1: Offer aid and tend to its wounds.
                Option 2: Ignore the creature and press on.""";
    }
}
