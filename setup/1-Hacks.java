package hacks;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;

@SuppressWarnings("ConstantConditions") // ignore warnings that "xyz may produce NullPointerException"
public class Hacks {

    /**
     * Prints a message in the client chat
     */
    private static void chat(String message) {
        Minecraft.getInstance().ingameGUI.getChatGUI().printChatMessage(new StringTextComponent(message));
    }

    /**
     * Called when the user types a chat message
     * @return true to suppress broadcasting the chat message, false to forward the message to the server
     */
    public static boolean chatMessageHook(String message) {
        if (message.startsWith(".")) {
            // hack commands start with '.'
            // for example: ".step 7.5"
            //              ".fly on"
            //              ".fly off"
            //              ".nightvision"

            try {
                String[] args = message.split(" ");
                // ".step 5" -> {".step", "5"}

                if (args[0].equals(".step")) {
                    // change the step height of the player
                    // by default, step height is 0.6, allowing the player to walk up stairs and slabs
                    // however, we can increase the step height above its normal value, allowing the player to
                    // walk up walls that are multiple blocks high
                    float stepHeight = Float.parseFloat(args[1]);
                    Minecraft.getInstance().player.stepHeight = stepHeight;
                    chat("stepHeight=" + stepHeight);

                } else if (args[0].equals(".fly")) {
                    boolean flyHackEnabled = args[1].equals("on");
                    // TODO: implement fly hack
                    // hint: ctrl+f for `flying` in ClientPlayerEntity
                    chat("fly=" + flyHackEnabled);

                } else if (args[0].equals(".nightvision")) {
                    // TODO: implement night vision hack
                    // hint: `gamma`
                    chat("nightvision enabled");

                } else if (args[0].equals(".doublejump")) {
                    boolean doubleJumpEnabled = args[1].equals("on");
                    // TODO: implement double jump hack
                    // hint: `onGround`
                    chat("doublejump=" + doubleJumpEnabled);

                } else {
                    chat("unknown hack command: " + args[0]);
                }
            } catch (Exception e) {
                // catch errors instead of crashing the game
                e.printStackTrace();
                chat("error when processing hack command: " + e);
            }

            return true; // don't forward the message to server
        } else {
            return false; // normal chat message, broadcast it on the server
        }
    }

}