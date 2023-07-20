import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import textrpg.*;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {

    private final Map<Long, UserState> userStates = new HashMap<>();
    UserState userState = userStates.getOrDefault(null, new UserState());
    long chatId;

    public Bot() {
        this.chatId = 0L;
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())         //Who are we sending a message to
                .text(what).build();            //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        chatId = update.getMessage().getChatId();
        String msgReceived = update.getMessage().getText();
        userStates.put(chatId, userState);
        System.out.println(msgReceived);

        //Status = userState.Start
        //the game starts of by showing the title screen and lets the user choose a name
        while (userState.getState() == State.START) {
            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                //Start of the game
                    sendResponse(chatId, GameLogic.titleScreen());
                    sendResponse(chatId, "You can end the game at any time by entering '/end'");
                    userState.setProgress(1);
                    sendResponse(chatId, "\nPlease enter a name for your character:");
                    break;
            }

            //User enters his/her/their name
            if (userState.getProgress() == 1) {
                sendResponse(chatId, GameLogic.chooseName(msgReceived));
                userState.setProgress(2);
                break;
            }

            if (userState.getProgress() == 2) {
                //Check whether the entered name is correct
                if (msgReceived.equalsIgnoreCase("yes")) {
                    sendResponse(chatId, "Created player with name " + GameLogic.playerName);
                    GameLogic.createPlayer();
                    userState.setState(State.PLAYING);
                    userState.setProgress(0);
                } else {
                    sendResponse(chatId, "Please enter another name:");
                    userState.setProgress(1);
                    break;
                }
            }
        }

        //Status = userState.PLAYING
        //The actual game loop begins
        while (userState.getState() == State.PLAYING) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                sendResponse(chatId, GameLogic.printMenu());
                userState.setProgress(1);
                break;
            }

            if (userState.getProgress() == 1) {
                if (msgReceived.equalsIgnoreCase("1") ||
                        msgReceived.equalsIgnoreCase("Continue")) {
                    sendResponse(chatId, Story.printIntro());
                    userState.setState(State.ACT1);
                    userState.setProgress(0);
                    break;
                } else if (msgReceived.equalsIgnoreCase("2")||
                        msgReceived.equalsIgnoreCase("Character Info")) {
                    sendResponse(chatId, GameLogic.characterInfo());
                    sendResponse(chatId, GameLogic.printMenu());
                    break;
                } else if (msgReceived.equalsIgnoreCase("3")||
                        msgReceived.equalsIgnoreCase("Exit")) {
                    userState.setState(State.END);
                    break;
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                }
            }
        }

        while (userState.getState() == State.ACT1) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                } if (msgReceived.equalsIgnoreCase("Wisdom")) {
                    userState.setState(State.WISDOM);
                } else if (msgReceived.equalsIgnoreCase("Strength")) {
                    userState.setState(State.STRENGTH);
                } else if (msgReceived.equalsIgnoreCase("Stealth")) {
                    userState.setState(State.STEALTH);
                } else if (msgReceived.equalsIgnoreCase("Compassion")) {
                    userState.setState(State.COMPASSION);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    sendResponse(chatId, "Only 'The Path of Wisdom' is currently fully supported.\n" +
                            "So please enter 'Wisdom'.");
                    break;
                }

        }

        //The Path of Wisdom
        while (userState.getState() == State.WISDOM) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                sendResponse(chatId, Story.printAct1Wisdom());
                sendResponse(chatId, "Choose option '1' or '2':");
                userState.setProgress(1);
                break;
            }

            if (userState.getProgress() == 1) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    sendResponse(chatId, Story.printAct1Wisdom1());
                    sendResponse(chatId, "Choose option '1' or '2':");
                    userState.setProgress(11);
                    break;
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    userState.setProgress(22);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    break;
                }
            }
            if (userState.getProgress() == 11) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    sendResponse(chatId, Story.printAct1WisdomEcho());
                    userState.setProgress(21);
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    sendResponse(chatId, Story.printAct1WisdomWhisper());
                    userState.setProgress(22);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    break;
                }
            }

            if (userState.getProgress() == 21) {
                sendResponse(chatId, Story.printAct1WisdomHiddenRoom());
                sendResponse(chatId, "Choose option '1' or '2':");
                userState.setProgress(31);
                break;
            }

            if (userState.getProgress() == 31) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    sendResponse(chatId, Story.printAct1WisdomOrb());
                    userState.setProgress(41);
                    sendResponse(chatId, "Choose option '1' or '2':");
                    break;
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    userState.setState(State.END);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    break;
                }
            }

            if (userState.getProgress() == 41) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    sendResponse(chatId, Story.printAct1WisdomGuards());
                    userState.setProgress(99);
                    userState.setState(State.END);
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    userState.setProgress(99);
                    userState.setState(State.END);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    break;
                }
            }

            if (userState.getProgress() == 22) {
                sendResponse(chatId, Story.printAct1WisdomLibrary());
                sendResponse(chatId, "Choose option '1' or '2':");
                userState.setProgress(32);
                break;
            }

            if (userState.getProgress() == 32) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    userState.setProgress(21);
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    userState.setState(State.END);
                } else {
                    sendResponse(chatId, "Please enter a valid option:");
                    break;
                }
            }
        }

        //The Path of Strength
        while (userState.getState() == State.STRENGTH) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                sendResponse(chatId, Story.printAct1Strength());
                userState.setState(State.ACT1);
                sendResponse(chatId, "Please enter a valid option:");
                sendResponse(chatId, "Only 'The Path of Wisdom' is currently fully supported.\n" +
                        "So please enter 'Wisdom'.");
                break;
            }
        }

        //The Path of Stealth
        while (userState.getState() == State.STEALTH) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                sendResponse(chatId, Story.printAct1Stealth());
                userState.setState(State.ACT1);
                sendResponse(chatId, "Please enter a valid option:");
                sendResponse(chatId, "Only 'The Path of Wisdom' is currently fully supported.\n" +
                        "So please enter 'Wisdom'.");
                break;
            }
        }

        //The Path of Compassion
        while (userState.getState() == State.COMPASSION) {
            if (msgReceived.equals("/start")) {
                userState.setState(State.START);
                userState.setProgress(0);
                break;
            }

            if (msgReceived.equals("/end")) {
                userState.setState(State.END);
                break;
            }

            if (userState.getProgress() == 0) {
                sendResponse(chatId, Story.printAct1Compassion());
                userState.setState(State.ACT1);
                sendResponse(chatId, "Please enter a valid option:");
                sendResponse(chatId, "Only 'The Path of Wisdom' is currently fully supported.\n" +
                        "So please enter 'Wisdom'.");
                break;
            }
        }

        //Status = userState.END
        //End of the game!! Thank you for playing! :)
        if (userState.getState() == State.END) {
            if(userState.getProgress() == 99) {
                sendResponse(chatId, "Congratulations! 🥳 You have won the game!");
                userState.setState(State.START);
                userState.setProgress(0);
                // System.exit(0); //ends the game loop for now
            } else if (userState.getProgress() == 100) {
                sendResponse(chatId, "This path is currently not implemented.\n" +
                        "The game ends here.");
                userState.setState(State.START);
                userState.setProgress(0);
                //System.exit(0); //ends the game loop for now
            } else {
                sendResponse(chatId, "This is the end for now. Thank you for playing");
                userState.setState(State.START);
                userState.setProgress(0);
                //System.exit(0); //ends the game loop for now
            }
        }
    }

    @Override
    public String getBotUsername () {
        return "patrickchatbot";
    }

    @Override
    public String getBotToken () {
        return "6048269057:AAFTlZasLKrp1HaTUGHT3QPH10LI-Ji_PNw";
    }

    @Override
    public void onRegister () {
        super.onRegister();
    }

    private void sendResponse(long chatId, String s) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(s);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

