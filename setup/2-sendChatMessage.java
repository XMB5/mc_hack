/**
 * Sends a chat message from the player.
 */
public void sendChatMessage(String message)
{
    // hacks here
    // (always make a comment when modifying the original code, so that you can find the changes later)
    if (hacks.Hacks.chatMessageHook(message)) {
        // hook returned true, do not broadcast message on the server
        return; // ends the method immediately
    }
    // original code below

    this.connection.sendPacket(new CChatMessagePacket(message));
}